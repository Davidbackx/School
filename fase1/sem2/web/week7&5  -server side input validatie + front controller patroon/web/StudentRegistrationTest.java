package ui.view;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudentRegistrationTest {
    private WebDriver driver;
    private String url = "http://localhost:8080/";

    @Before
    public void setUp() throws Exception {
        // PAS DIT AAN NAAR JE EIGEN CHROME OF GECKODRIVER
        System.setProperty("webdriver.chrome.driver", "C:\\School\\sem2\\web\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test_als_Lege_Student_Toegevoegd_Dan_Wordt_Formulier_Opnieuw_Getoond() {
        driver.get(url + "studentForm.jsp");
        voegStudentToe("", "", 0, "");
        assertEquals("Voeg een student toe", driver.getTitle());
        assertEquals("Voeg een student toe", driver.findElement(By.tagName("h2")).getText());
    }

    @Test
    public void test_StudentForm_alles_invullen_gaat_naar_overzicht_en_toont_nieuwe_student_in_tabel() {
        driver.get(url + "studentForm.jsp");
        voegStudentToe("Kemme", "Mieke", 18, "TI");
        assertEquals("Overzicht Studenten", driver.getTitle());
        assertEquals("Overzicht studenten", driver.findElement(By.tagName("h2")).getText());
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Kemme"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Mieke"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "18"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "TI"));

    }

    @Test
    public void test_als_student_gezocht_die_niet_toegevoegd_is_geeft_nietgevonden() {
        driver.get(url + "zoekForm.jsp");
        int rand = new Random().nextInt(999999);
        zoekStudent("x" + rand, "y" + rand);
        assertEquals("Niet gevonden", driver.getTitle());
        assertEquals("Helaas, de student waarnaar je vraagt is niet gevonden.",
                driver.findElement(By.id("foutboodschap")).getText());

    }

    @Test
    public void test_student_uit_constructor_wordt_gevonden() {
        driver.get(url + "zoekForm.jsp");
        zoekStudent("Steegmans", "Elke");
        assertEquals("Gevonden", driver.getTitle());
        assertEquals("Je vroeg naar volgende gegevens: Steegmans Elke (16 jaar): Vroedkunde",
                driver.findElement(By.id("boodschap")).getText());

    }

    @Test
    public void test_student_die_nieuw_toegevoegd_is_wordt_gevonden() {
        driver.get(url + "studentForm.jsp");
        int rand = new Random().nextInt(999999);
        voegStudentToe("Janssens " + rand, "Jan", rand, "BLT");
        driver.get(url + "zoekForm.jsp");
        zoekStudent("Janssens " + rand, "Jan");
        assertEquals("Gevonden", driver.getTitle());
        assertEquals("Je vroeg naar volgende gegevens: Janssens " + rand + " Jan (" + rand + " jaar): BLT",
                driver.findElement(By.id("boodschap")).getText());

    }

    private void voegStudentToe(String naam, String voornaam, int leeftijd, String studierichting) {
        driver.findElement(By.id("naam")).sendKeys(naam);
        driver.findElement(By.id("voornaam")).sendKeys(voornaam);
        driver.findElement(By.id("leeftijd")).sendKeys(leeftijd + "");
        driver.findElement(By.id("studierichting")).sendKeys(studierichting);
        driver.findElement(By.id("bewaar")).click();

    }

    private void zoekStudent(String naam, String voornaam) {
        driver.findElement(By.id("naam")).sendKeys(naam);
        driver.findElement(By.id("voornaam")).sendKeys(voornaam);
        driver.findElement(By.id("zoek")).click();
    }

    private boolean paginaBevatTdMetText(List<WebElement> tds, String tekst) {
        for (WebElement td : tds) {
            if (td.getText().equals(tekst)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test_StudentForm_niets_invullen_geeft_foutmelding() {
    	driver.get(url + "studentForm.jsp");
		driver.findElement(By.id("bewaar")).click();

		assertEquals("Voeg een student toe", driver.getTitle());
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("li")), "Invalide voornaam"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("li")), "Invalide naam"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("li")), "Invalide leeftijd"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("li")), "Invalide studierichting"));
    }

    @Test
    public void test_StudentForm_naam_en_voornaam_juist_de_rest_leeg_behoud_naam_en_voornaam() {
        driver.get(url + "studentForm.jsp");

        driver.findElement(By.id("naam")).sendKeys("Stijn");
        driver.findElement(By.id("voornaam")).sendKeys("Stijn");

        driver.findElement(By.id("bewaar")).click();

        assertEquals("Voeg een student toe", driver.getTitle());

        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("li")), "Invalide leeftijd"));
        assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("li")), "Invalide studierichting"));
        assertEquals("Stijn", driver.findElement(By.id("voornaam")).getAttribute("value"));
        assertEquals("Stijn", driver.findElement(By.id("naam")).getAttribute("value"));
    }


}
