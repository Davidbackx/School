package view;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import static org.junit.Assert.*;

public class TestPreview {
	
	private WebDriver driver;
// pas aan naar jouw eigen project
	String url = "http://localhost:8080/";

	@Before
	public void setUp() throws Exception {
//		 Voor Windows (vergeet "\" niet te escapen met een tweede "\")
		System.setProperty("webdriver.chrome.driver", "C:\\School\\sem2\\web\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void init_test(){
		driver.get(url+"bikeOverview.jsp");
		// controleer of je geen 404-fout krijgt
		assertFalse(driver.getPageSource().contains("HTTP Status 404"));
	}

	@Test
	public void all_fields_correct_except_price_negative_throws_exception () {
		driver.get(url+"bikeAdd.jsp");
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

		// Wanneer er een assertTrue fail is kan het zijn dat dit komt door da er bij het toevoegen
		// met een GET methode wordt gewerkt en niet met een POST
		assertTrue(hasElementWithValue(driver.findElements(By.tagName("li")), "No valid price"));
		assertEquals(driver.getTitle(), "Bikes - view detail");
	}

	@Test
	public void all_fields_correct_and_bike_in_overview () {
		driver.get(url+"bikeAdd.jsp");
		WebElement e = driver.findElement(By.id("itemId"));
		e.clear();
		e.sendKeys("10");

		String brand = "EPIC_BRAND";
		e = driver.findElement(By.id("brand"));
		e.clear();
		e.sendKeys(brand);

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
		assertTrue(hasElementWithValue(driver.findElements(By.tagName("td")), brand));
	}

	@After
	public void clean() {
		driver.quit();
	}

	private static boolean hasElementWithValue (List<WebElement> elements, String s) {
		for (WebElement e : elements) {
			if (e.getText().equals(s)) return true;
		}
		return false;
	}


}
