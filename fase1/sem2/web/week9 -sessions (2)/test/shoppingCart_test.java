import domain.model.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class shoppingCart_test {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\School\\sem2\\web\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/Controller?command=overview");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void link_add_to_shoppingCart_exists() {
        String firstProduct = driver.findElement(By.cssSelector("tr td")).getText();
        WebElement link = driver.findElement(By.cssSelector("tr td a"));
        assertTrue(link.getAttribute("href").contains("Controller?command=addToCart&productId="+firstProduct));
    }

    @Test
    public void product_is_added_to_shoppingCart_and_shown_in_overview() {
        String firstProduct = driver.findElement(By.cssSelector("tr td")).getText();
        WebElement link = driver.findElement(By.cssSelector("tr td a"));
        link.click();
        assertEquals("Shopping Cart",driver.findElement(By.tagName("h2")).getText());
        assertTrue(findProductInOverview(Integer.parseInt(firstProduct)));
    }

    /**
     * Returns true if a td exists containing given id, false otherwise
     */
    private boolean findProductInOverview(int id) {
        List<WebElement> tds = driver.findElements(By.tagName("td"));
        for (WebElement td:tds) {
            if (td.getText().equals(id+""))
                return true;
        }
        return false;
    }

    @Test
    public void second_browser_gives_different_shoppingcart() {
        // add product to shoppingcart of first browser
        WebElement link = driver.findElement(By.cssSelector("tr td a"));
        link.click();
        // open browser 2 and check shoppingCart is empty
        WebDriver driver2 = new ChromeDriver();
        driver2.get("http://localhost:8080/Controller?command=showCart");
        assertEquals("No products in your shopping cart",driver2.findElement(By.tagName("p")).getText());
        driver2.quit();
    }

    @Test
    public void link_remove_from_shoppingCart_exists() {
        String firstProduct = driver.findElement(By.cssSelector("tr td")).getText();
        WebElement linkAddToCart = driver.findElement(By.cssSelector("tr td a"));
        linkAddToCart.click();
        WebElement linkRemoveFromCart = driver.findElement(By.cssSelector("tr td a"));
        assertTrue(linkRemoveFromCart.getAttribute("href").contains("Controller?command=removeFromCart&productId="+firstProduct));
    }

    @Test
    public void product_is_removed_from_shoppingCart() {
        String firstProduct = driver.findElement(By.cssSelector("tr td")).getText();
        WebElement linkAddToCart = driver.findElement(By.cssSelector("tr td a"));
        linkAddToCart.click();
        WebElement linkRemoveFromCart = driver.findElement(By.cssSelector("tr td a"));
        linkRemoveFromCart.click();
        assertEquals("Shopping Cart",driver.findElement(By.tagName("h2")).getText());
        boolean present = false;
        if (driver.findElements(By.tagName("td"))!=null)
            present = findProductInOverview(Integer.parseInt(firstProduct));
        assertFalse(present);
    }


}
