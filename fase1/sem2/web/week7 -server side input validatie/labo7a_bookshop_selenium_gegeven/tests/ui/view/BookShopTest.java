package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class BookShopTest {
    WebDriver driver;

    String url = "http://localhost:8080/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\School\\sem2\\web\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void Test_navigate_to_form () {
        driver.get(url);
        assertEquals(driver.getTitle(), "Book Info");
    }

    @Test
    public void Test_blank_fields_and_submit_form () {
        driver.get(url);
        driver.findElement(By.id("calculate")).click();

        WebElement error = driver.findElement(By.cssSelector("p"));
        assertEquals(error.getText(), "Vul alle velden in.");
    }

    @Test
    public void Test_enter_correct_input () {
        driver.get(url);

        WebElement titleInput = driver.findElement(By.id("title"));
        titleInput.clear();
        titleInput.sendKeys("Alles Komt Goed");

        WebElement priceInput = driver.findElement(By.id("price"));
        priceInput.clear();
        priceInput.sendKeys("10");

        WebElement numberInput = driver.findElement(By.id("number"));
        numberInput.clear();
        numberInput.sendKeys("7");

        driver.findElement(By.id("calculate")).click();

        assertEquals("Book", driver.getTitle());
        assertEquals("Alles Komt Goed", driver.findElement(By.id("title")).getText());
        assertEquals("70", driver.findElement(By.id("amount")).getText());
    }
}