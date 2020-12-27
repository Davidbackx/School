package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.SubmissionPublisher;

import static org.junit.jupiter.api.Assertions.*;

public class formTest {
    private WebDriver driver;
    @Before
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "C:\\School\\sem2\\web\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_war_exploded/form.jsp");
    }

    @Test
    public void test_from_is_shown_again_if_all_fields_are_empty () {
        Submit();
        assertEquals("Nieuwe game - Games", driver.getTitle());
    }

    @Test
    public void test_Form_is_shown_again_with_error_messages_If_name_field_is_left_empty() {
        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("");

        WebElement developerInput = driver.findElement(By.id("developer"));
        developerInput.clear();
        developerInput.sendKeys("Hideo Kojima");

        WebElement soortInput = driver.findElement(By.id("soort"));
        soortInput.clear();
        soortInput.sendKeys("Walking Simulator");

        WebElement prijsInput = driver.findElement(By.id("prijs"));
        prijsInput.clear();
        prijsInput.sendKeys("60");

        Submit();
        assertEquals("Nieuwe game - Games", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Naam is invalid"));
    }

    @Test
    public void test_overview_is_shown_when_all_fields_are_correctly_filled_in () {
        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("Death Stranding");

        WebElement developerInput = driver.findElement(By.id("developer"));
        developerInput.clear();
        developerInput.sendKeys("Hideo Kojima");

        WebElement soortInput = driver.findElement(By.id("soort"));
        soortInput.clear();
        soortInput.sendKeys("Walking Simulator");

        WebElement prijsInput = driver.findElement(By.id("prijs"));
        prijsInput.clear();
        prijsInput.sendKeys("60");

        Submit();
        assertEquals("Overzicht - Games", driver.getTitle());
    }


    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)) {
                return true;
            }
        } return false;
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    public void Submit() {
        driver.findElement(By.id("submit")).click();
    }
}