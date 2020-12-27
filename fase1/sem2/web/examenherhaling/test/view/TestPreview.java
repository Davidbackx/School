package view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;

public class TestPreview {
	
	private WebDriver driver;
// pas aan naar jouw eigen project
	String url = "http://localhost:8080/";

	@Before
	public void setUp() throws Exception {
//		 Voor Windows (vergeet "\" niet te escapen met een tweede "\")
		System.setProperty("webdriver.chrome.driver", "C:\\School\\sem2\\web\\chromedriver.exe");
//		 Voor mac:
//		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
		driver = new ChromeDriver();
	}

	@Test
	public void someTest(){
		driver.get(url+"bikeOverview.jsp");
		// controleer of je geen 404-fout krijgt
		assertFalse(driver.getPageSource().contains("HTTP Status 404"));
	}
	
	@After
	public void clean() {
		driver.quit();
	}


}
