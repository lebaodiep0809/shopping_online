package action;

import UI.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerProductTest {
    WebDriver driver;
    @BeforeClass
    public void setUpClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void setUp(){
        driver.get("https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void testProductPageUI(){
        ProductPage page = new ProductPage(driver);
        Assert.assertTrue(page.);
    }
}
