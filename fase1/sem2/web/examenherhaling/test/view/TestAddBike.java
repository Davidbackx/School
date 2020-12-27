package view;

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.List;

public class TestAddBike {
	
	private WebDriver driver;
	String url = "http://localhost:8080/";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\School\\sem2\\web\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(url+"bikeAdd.jsp");
	}

	@Test
	public void test_all_fields_correct_except_price () {
		WebElement e = driver.findElement(By.id("itemId"));
		e.clear();
		e.sendKeys("10");

		e = driver.findElement(By.id("brand"));
		e.clear();
		e.sendKeys("brand");

		e = driver.findElement(By.id("category"));
		e.clear();
		e.sendKeys("CITY");

		e = driver.findElement(By.id("description"));
		e.clear();
		e.sendKeys("desc");

		e = driver.findElement(By.id("price"));
		e.clear();
		e.sendKeys("-10");

		driver.findElement(By.id("submit")).click();

		assertEquals(driver.getTitle(), "Bikes - view detail");
		assertTrue(hasElementWithValue(driver.findElements(By.tagName("li")), "No valid price"));
	}

	@Test
	public void test_add_bike_correct () {
		WebElement e = driver.findElement(By.id("itemId"));
		e.clear();
		e.sendKeys("10");

		e = driver.findElement(By.id("brand"));
		e.clear();
		e.sendKeys("brand");

		e = driver.findElement(By.id("category"));
		e.clear();
		e.sendKeys("CITY");

		e = driver.findElement(By.id("description"));
		e.clear();
		e.sendKeys("desc");

		e = driver.findElement(By.id("price"));
		e.clear();
		e.sendKeys("10");

		driver.findElement(By.id("submit")).click();

		assertEquals(driver.getTitle(), "Overview Bikes");
		assertTrue(hasElementWithValue(driver.findElements(By.tagName("td")), "brand"));
	}

	private static boolean hasElementWithValue (List<WebElement> elements, String s) {
		for (WebElement e : elements) {
			if (e.getText().equals(s)) return true;
		}
		return false;
	}

	@After
	public void clean() {
		driver.quit();
	}
}
