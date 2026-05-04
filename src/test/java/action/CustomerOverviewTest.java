package action;

import UI.*;
import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerOverviewTest {

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
    public void testOverviewUIWithoutSelectingProductFromProductsPage() {

        ProductPage page = new ProductPage(driver);
        page.clickShoppingCart();

        YourCartPage yourCart = new YourCartPage(driver);
        yourCart.clickCheckout();

        YourInformation yourInfor = new YourInformation(driver);
        yourInfor.enterFirstName("A");
        yourInfor.enterLastName("B");
        yourInfor.enterZipCode("123");
        yourInfor.clickContinue();

        Overview overview = new Overview(driver);

        Assert.assertEquals(overview.getLogo(), "Swag Labs");
        Assert.assertEquals(overview.getTitle(), "Checkout: Overview");

        Assert.assertTrue(overview.isShoppingCartDisplayed());
        Assert.assertEquals(overview.getShoppingCartCount(), 0);

        Assert.assertEquals(overview.getQtyTitle(), "QTY");
        Assert.assertEquals(overview.getDescTitle(), "Description");

        Assert.assertEquals(overview.getPaymentInformation(), "Payment Information:");
        Assert.assertEquals(overview.getSauceCard(), "SauceCard #31337");

        Assert.assertEquals(overview.getShippingInformation(), "Shipping Information:");
        Assert.assertEquals(overview.getFreeExpress(), "Free Pony Express Delivery!");

        // ================= PRICES =================
        double itemTotal = overview.getItemTotalPrice();
        double tax = overview.getTaxPrice();
        double total = overview.getTotalPrice();

        Assert.assertEquals(itemTotal, 0.0);
        Assert.assertEquals(tax, 0.0);
        Assert.assertEquals(total, 0.0);

        Assert.assertEquals(total, itemTotal + tax, 0.01);

        Assert.assertTrue(overview.isCancelEnable());
        Assert.assertTrue(overview.isFinishEnable());
    }

    @Test
    public void testOverviewUIWithThreeProducts() throws InterruptedException {

        ProductPage page = new ProductPage(driver);
        page.addThreeProduct();
        page.clickShoppingCart();

        YourCartPage yourCart = new YourCartPage(driver);
        yourCart.clickCheckout();

        YourInformation yourInfor = new YourInformation(driver);
        yourInfor.enterFirstName("A");
        yourInfor.enterLastName("B");
        yourInfor.enterZipCode("123");
        yourInfor.clickContinue();

        Overview overview = new Overview(driver);

        // ==========PRODUCTS=============
        Assert.assertEquals(overview.getProductBikeName(),"Sauce Labs Bike Light");
        Assert.assertEquals(overview.getProductBikeInfo(),"A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
        Assert.assertEquals(overview.getBikePrice(),"$9.99");

        Assert.assertEquals(overview.getProductBackName(),"Sauce Labs Backpack");
        Assert.assertEquals(overview.getProductBackInfo(),"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        Assert.assertEquals(overview.getBackPrice(),"$29.99");

        Assert.assertEquals(overview.getProductJacketName(),"Sauce Labs Fleece Jacket");
        Assert.assertEquals(overview.getProductJacketInfo(),"It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        Assert.assertEquals(overview.getJacketPrice(),"$49.99");
        // ================= HEADER =================
        Assert.assertEquals(overview.getLogo(), "Swag Labs");
        Assert.assertEquals(overview.getTitle(), "Checkout: Overview");

        Assert.assertTrue(overview.isShoppingCartDisplayed());
        Assert.assertEquals(overview.getShoppingCartCount(), 3);

        Assert.assertEquals(overview.getQtyTitle(), "QTY");
        Assert.assertEquals(overview.getDescTitle(), "Description");
        // ================= PAYMENT =================
        Assert.assertEquals(overview.getPaymentInformation(), "Payment Information:");
        Assert.assertEquals(overview.getSauceCard(), "SauceCard #31337");

        Assert.assertEquals(overview.getShippingInformation(), "Shipping Information:");
        Assert.assertEquals(overview.getFreeExpress(), "Free Pony Express Delivery!");

        // ================= PRICES =================
        double priceBack = overview.getProductBackPrice();
        double priceBike = overview.getProductBikePrice();
        double priceJacket = overview.getProductJacketPrice();

        double expectedItemTotal = priceBack + priceBike + priceJacket;

        double itemTotal = overview.getItemTotalPrice();
        double tax = overview.getTaxPrice();
        double total = overview.getTotalPrice();

        double itemTotalTax = itemTotal + tax;

        // check item total đúng
        Assert.assertEquals(itemTotal, expectedItemTotal, 0.01);

        // check công thức
        Assert.assertEquals(total, itemTotal + tax, 0.01);

        // ================= BUTTON =================
        Assert.assertTrue(overview.isCancelEnable());
        Assert.assertTrue(overview.isFinishEnable());
    }

    @Test
    public void testOvervieWithClickCancel() throws InterruptedException {
        ProductPage page = new ProductPage(driver);
        page.addThreeProduct();
        page.clickShoppingCart();

        YourCartPage yourCart = new YourCartPage(driver);
        yourCart.clickCheckout();

        YourInformation yourInfor = new YourInformation(driver);
        yourInfor.enterFirstName("A");
        yourInfor.enterLastName("B");
        yourInfor.enterZipCode("123");
        yourInfor.clickContinue();

        Overview overview = new Overview(driver);
        overview.clickCancel();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testOvervieWithClickFinish() throws InterruptedException {
        ProductPage page = new ProductPage(driver);
        page.addThreeProduct();
        page.clickShoppingCart();

        YourCartPage yourCart = new YourCartPage(driver);
        yourCart.clickCheckout();

        YourInformation yourInfor = new YourInformation(driver);
        yourInfor.enterFirstName("A");
        yourInfor.enterLastName("B");
        yourInfor.enterZipCode("123");
        yourInfor.clickContinue();

        Overview overview = new Overview(driver);
        overview.clickFinish();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}