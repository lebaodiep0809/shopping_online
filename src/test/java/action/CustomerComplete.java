package action;

import UI.*;
import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerComplete {
    WebDriver driver;
    ConfigReader config;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        config = new ConfigReader();
        driver.get(config.getUrl());

        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(
                config.getUsername(),
                config.getPassword()
        );
    }

    @Test
    public void testCheckoutCompleteUI() throws InterruptedException {
        ProductPage page = new ProductPage(driver);
        page.addThreeProduct();
        page.clickShoppingCart();
        YourCartPage youCart = new YourCartPage(driver);
        youCart.clickCheckout();
        YourInformation yourInfor = new YourInformation(driver);
        yourInfor.enterFirstName("A");
        yourInfor.enterLastName("B");
        yourInfor.enterZipCode("123");
        yourInfor.clickContinue();
        Overview overview = new Overview(driver);
        overview.clickFinish();
        Complete complete = new Complete(driver);
        Assert.assertEquals(complete.getLogo(),"Swag Labs");
        Assert.assertEquals(complete.getTitle(),"Checkout: Complete!");
        Assert.assertTrue(complete.isIconDisble());
        Assert.assertTrue(complete.isShoppingCartDisable());
        Assert.assertEquals(complete.getThankYou(),"Thank you for your order!");
        Assert.assertEquals(complete.getCompleteText(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        Assert.assertTrue(complete.isBackHomeDisable());
    }

    @Test
    public void testCheckoutCompleteWithClickBackHome() throws InterruptedException {
        ProductPage page = new ProductPage(driver);
        page.addThreeProduct();
        page.clickShoppingCart();
        YourCartPage youCart = new YourCartPage(driver);
        youCart.clickCheckout();
        YourInformation yourInfor = new YourInformation(driver);
        yourInfor.enterFirstName("A");
        yourInfor.enterLastName("B");
        yourInfor.enterZipCode("123");
        yourInfor.clickContinue();
        Overview overview = new Overview(driver);
        overview.clickFinish();
        Complete complete = new Complete(driver);
        complete.clickBackHome();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(page.getShoppingCartCount(),0);
    }



    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
