package action;

import UI.LoginPage;
import UI.ProductPage;
import UI.YourCartPage;
import UI.YourInformation;
import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerYourCartTest {
    WebDriver driver;
    ConfigReader config;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        config = new ConfigReader();
        driver.get(config.getUrl());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(
                config.getUsername(),
                config.getPassword()
        );
        ProductPage productPage = new ProductPage(driver);
        productPage.addBikeLight();
        Thread.sleep(2000);
        productPage.addFleeceJacket();
        Thread.sleep(2000);
        productPage.addBackpack();
        Thread.sleep(2000);
        productPage.clickShoppingCart();
        Thread.sleep(2000);
    }

    @Test
    public void testYourCartPageUI(){
        YourCartPage youCart = new YourCartPage(driver);
        //Kiểm tra logo
        Assert.assertEquals(youCart.getLogo(),"Swag Labs");
        //Kiểm tra tilte
        Assert.assertEquals(youCart.getTilte(),"Your Cart");
        //Kiểm tra số lượng sản phẩm
        Assert.assertEquals(youCart.getShoppingCartCount(),3);
        //Kiểm tra traạng thái giỏ hàng
        Assert.assertTrue(youCart.isShoppingCartEnable());
        //Kiểm tra sản phẩm Bike
        Assert.assertEquals(youCart.getProductBike(),"Sauce Labs Bike Light");
        Assert.assertEquals(youCart.getInforBike(),"A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
        Assert.assertEquals(youCart.getSerialBike(),"1");
        Assert.assertEquals(youCart.getPriceBike(),"$9.99");
        Assert.assertTrue(youCart.isRemoveBikeEnable());
        Assert.assertEquals(youCart.getRemoveBike(),"Remove");

        //Kiểm tra sản phẩm Backpack
        Assert.assertEquals(youCart.getProductBack(),"Sauce Labs Backpack");
        Assert.assertEquals(youCart.getInforBack(),"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        Assert.assertEquals(youCart.getSerialBack(),"1");
        Assert.assertEquals(youCart.getPriceBack(),"$29.99");
        Assert.assertTrue(youCart.isRemoveBackEnable());
        Assert.assertEquals(youCart.getRemoveBack(),"Remove");

        //Kiểm tra sản phẩm Jacket
        Assert.assertEquals(youCart.getProductJacket(),"Sauce Labs Fleece Jacket");
        Assert.assertEquals(youCart.getInforJacket(),"It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        Assert.assertEquals(youCart.getSerialJacket(),"1");
        Assert.assertEquals(youCart.getPriceJacket(),"$49.99");
        Assert.assertTrue(youCart.isRemoveJacketEnable());
        Assert.assertEquals(youCart.getRemoveJacket(),"Remove");
    }

    @Test
    public void testRemoveProductBikeLight(){
        YourCartPage youCart = new YourCartPage(driver);
        youCart.clickRemoveBike();
        Assert.assertEquals(youCart.getShoppingCartCount(),2);
        Assert.assertEquals(youCart.getProductBack(),"Sauce Labs Backpack");
        Assert.assertEquals(youCart.getInforBack(),"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        Assert.assertEquals(youCart.getSerialBack(),"1");
        Assert.assertEquals(youCart.getPriceBack(),"$29.99");
        Assert.assertTrue(youCart.isRemoveBackEnable());
        Assert.assertEquals(youCart.getRemoveBack(),"Remove");

        //Kiểm tra sản phẩm Jacket
        Assert.assertEquals(youCart.getProductJacket(),"Sauce Labs Fleece Jacket");
        Assert.assertEquals(youCart.getInforJacket(),"It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        Assert.assertEquals(youCart.getSerialJacket(),"1");
        Assert.assertEquals(youCart.getPriceJacket(),"$49.99");
        Assert.assertTrue(youCart.isRemoveJacketEnable());
        Assert.assertEquals(youCart.getRemoveJacket(),"Remove");
    }

    @Test
    public void testRemoveAllProduct() throws InterruptedException {
        YourCartPage youCart = new YourCartPage(driver);
        youCart.clickRemoveBike();
        Thread.sleep(2000);
        youCart.clickRemoveBack();
        Thread.sleep(2000);
        youCart.clickRemoveJacket();
        Assert.assertEquals(youCart.getShoppingCartCount(),0);
    }

    @Test
    public void testNotRemoveProductAndClickContinueShopping(){
        ProductPage page = new ProductPage(driver);
        YourCartPage youCart = new YourCartPage(driver);

        youCart.clickContinueShopping();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(page.getShoppingCartCount(),3);
        Assert.assertEquals(page.removeBackpackText(),"Remove");
        Assert.assertEquals(page.removeFleeceJacketText(),"Remove");
        Assert.assertEquals(page.removeBikeLightText(),"Remove");
    }

    @Test
    public void testRemoveProductBikeLightAndClickContinueShopping(){
        YourCartPage youCart = new YourCartPage(driver);
        ProductPage page = new ProductPage(driver);
        youCart.clickRemoveBike();
        youCart.clickContinueShopping();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(page.getShoppingCartCount(),2);
        Assert.assertEquals(page.removeBackpackText(),"Remove");
        Assert.assertEquals(page.removeFleeceJacketText(),"Remove");
        Assert.assertEquals(page.addBikeLightText(),"Add to cart");
    }

    @Test
    public void testRemoveAllProductAndClickContinueShopping() throws InterruptedException {
        YourCartPage youCart = new YourCartPage(driver);
        ProductPage page = new ProductPage(driver);
        youCart.clickRemoveBike();
        Thread.sleep(1000);
        youCart.clickRemoveBack();
        Thread.sleep(1000);
        youCart.clickRemoveJacket();
        youCart.clickContinueShopping();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(page.getShoppingCartCount(),0);
        Assert.assertEquals(page.addBackpackText(),"Add to cart");
        Assert.assertEquals(page.addFleeceJacketText(),"Add to cart");
        Assert.assertEquals(page.addBikeLightText(),"Add to cart");
    }

    @Test
    public void testNotRemoveProductAndClickCheckout(){
        YourCartPage youCart = new YourCartPage(driver);
        YourInformation yourInformation = new YourInformation(driver);

        youCart.clickCheckout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
        Assert.assertEquals(yourInformation.getLogo(),"Swag Labs");
        Assert.assertEquals(yourInformation.getTitle(),"Checkout: Your Information");
        Assert.assertEquals(yourInformation.getShoppingCartCount(),3);

    }

    @Test
    public void testRemoveProductBikeLightAndClickCheckout(){
        YourCartPage youCart = new YourCartPage(driver);
        YourInformation yourInformation = new YourInformation(driver);
        youCart.clickRemoveBike();
        youCart.clickCheckout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
        Assert.assertEquals(yourInformation.getLogo(),"Swag Labs");
        Assert.assertEquals(yourInformation.getTitle(),"Checkout: Your Information");
        Assert.assertEquals(yourInformation.getShoppingCartCount(),2);
    }

    @Test
    public void testRemoveAllProductAndClickCheckout() throws InterruptedException {
        YourCartPage youCart = new YourCartPage(driver);
        YourInformation yourInformation = new YourInformation(driver);
        youCart.clickRemoveBike();
        Thread.sleep(1000);
        youCart.clickRemoveBack();
        Thread.sleep(1000);
        youCart.clickRemoveJacket();
        youCart.clickCheckout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
        Assert.assertEquals(yourInformation.getLogo(),"Swag Labs");
        Assert.assertEquals(yourInformation.getTitle(),"Checkout: Your Information");
        Assert.assertEquals(yourInformation.getShoppingCartCount(),0);
    }

    @AfterMethod
    public void afterMethod(){
        if (driver != null) {
            driver.quit();
        }
    }
}

