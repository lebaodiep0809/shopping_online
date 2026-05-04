package action;

import UI.LoginPage;
import UI.ProductPage;
import UI.YourCartPage;
import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerProductTest {
    WebDriver driver;
    ConfigReader config;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        config = new ConfigReader();
        driver.get(config.getUrl());
        LoginPage login = new LoginPage(driver);
        login.performLogin(
                config.getUsername(),
                config.getPassword()
        );

    }
    @Test
    public void testProductPageUI(){
        ProductPage page = new ProductPage(driver);
        //Kiểm tra logo
        Assert.assertTrue(page.isLogoDisplayed(),"Swag Labs");
        //Kiểm tra tên trang
        Assert.assertEquals(page.getTitle(),"Products");
        //Kiểm tra giỏ hàng
        Assert.assertTrue(page.isShoppingCartEnable());
        //Kiểm tra sắp xêps
        Assert.assertTrue(page.isArrangeDisplayed());
        //Kiểm tra gias trị trong cbx Sắp xếp
        Assert.assertEquals(page.getSortTextByIndex(1),"Name (Z to A)");

        //Sauce Labs Backpack
        Assert.assertEquals(page.getBackpackName(),"Sauce Labs Backpack");
        Assert.assertEquals(page.getBackpackInfo(),"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        Assert.assertEquals(page.getBackpackPrice(),"$29.99");
        Assert.assertTrue(page.isBackpackImageDisplayed());
        Assert.assertEquals(page.addBackpackText(),"Add to cart");

        //Sauce Labs Bike Light
        Assert.assertEquals(page.getBikeName(),"Sauce Labs Bike Light");
        Assert.assertEquals(page.getBikeInfo(),"A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
        Assert.assertEquals(page.getBikePrice(),"$9.99");
        Assert.assertTrue(page.isBackpackImageDisplayed());
        Assert.assertEquals(page.addBikeLightText(),"Add to cart");
        Assert.assertTrue(page.isBikeImageDisplayed());

        //Sauce Labs Fleece Jacket
        Assert.assertEquals(page.getJacketName(),"Sauce Labs Fleece Jacket");
        Assert.assertEquals(page.getJacketInfo(),"It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        Assert.assertEquals(page.getJacketPrice(),"$49.99");
        Assert.assertTrue(page.isBackpackImageDisplayed());
        Assert.assertEquals(page.addFleeceJacketText(),"Add to cart");
        Assert.assertTrue(page.isJacketImageDisplayed());
    }
    @Test
    public void testAddToCartProduct() throws InterruptedException {
        ProductPage page = new ProductPage(driver);

        page.addThreeProduct();

        Assert.assertEquals(page.getShoppingCartCount(), 3);

        Assert.assertEquals(page.removeBackpackText(), "Remove");
        Assert.assertEquals(page.removeBikeLightText(), "Remove");
        Assert.assertEquals(page.removeFleeceJacketText(), "Remove");
    }

    @Test
    public void testRemoveProductBikeLight() throws InterruptedException {
        ProductPage page = new ProductPage(driver);
        page.addThreeProduct();
        page.removeBikeLight();
        Thread.sleep(3000);

        Assert.assertEquals(page.getShoppingCartCount(),2);
        Assert.assertEquals(page.removeBackpackText(),"Remove");
        Assert.assertEquals(page.addBikeLightText(),"Add to cart");
        Assert.assertEquals(page.removeFleeceJacketText(),"Remove");
    }
    @Test
    public void testSortProductByAZ(){
        ProductPage page = new ProductPage(driver);
        page.sortTextByIndex(0);
        Assert.assertEquals(page.getProductNameByIndex(1),"Sauce Labs Backpack");
        Assert.assertEquals(page.getProductNameByIndex(2),"Sauce Labs Bike Light");
        Assert.assertEquals(page.getProductNameByIndex(3),"Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(page.getProductNameByIndex(4),"Sauce Labs Fleece Jacket");
        Assert.assertEquals(page.getProductNameByIndex(5),"Sauce Labs Onesie");
        Assert.assertEquals(page.getProductNameByIndex(6),"Test.allTheThings() T-Shirt (Red)");    }

    @Test
    public void testSortProductByZA(){
        ProductPage page = new ProductPage(driver);
        page.sortTextByIndex(1);
        Assert.assertEquals(page.getProductNameByIndex(6),"Sauce Labs Backpack");
        Assert.assertEquals(page.getProductNameByIndex(5),"Sauce Labs Bike Light");
        Assert.assertEquals(page.getProductNameByIndex(4),"Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(page.getProductNameByIndex(3),"Sauce Labs Fleece Jacket");
        Assert.assertEquals(page.getProductNameByIndex(2),"Sauce Labs Onesie");
        Assert.assertEquals(page.getProductNameByIndex(1),"Test.allTheThings() T-Shirt (Red)");
    }
    @Test
    public void testSortProductPriceLowToHight(){
        ProductPage page = new ProductPage(driver);
        page.sortTextByIndex(2);
        Assert.assertEquals(page.getProductNameByIndex(1),"Sauce Labs Onesie");
        Assert.assertEquals(page.getProductNameByIndex(2),"Sauce Labs Bike Light");
        Assert.assertEquals(page.getProductNameByIndex(3),"Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(page.getProductNameByIndex(4),"Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(page.getProductNameByIndex(5),"Sauce Labs Backpack");
        Assert.assertEquals(page.getProductNameByIndex(6),"Sauce Labs Fleece Jacket");
    }
    @Test
    public void testSortProductPriceHighToLow(){
        ProductPage page = new ProductPage(driver);
        page.sortTextByIndex(3);
        Assert.assertEquals(page.getProductNameByIndex(6),"Sauce Labs Onesie");
        Assert.assertEquals(page.getProductNameByIndex(5),"Sauce Labs Bike Light");
        Assert.assertEquals(page.getProductNameByIndex(3),"Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(page.getProductNameByIndex(4),"Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(page.getProductNameByIndex(2),"Sauce Labs Backpack");
        Assert.assertEquals(page.getProductNameByIndex(1),"Sauce Labs Fleece Jacket");
    }
    @Test
    public void testShoppingCart(){
        ProductPage page = new ProductPage(driver);
        YourCartPage cart = new YourCartPage(driver);
        page.clickShoppingCart();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cart.getLogo(),"Swag Labs");
        Assert.assertEquals(cart.getTilte(),"Your Cart");
    }

    @Test
    public void testRovemoAllProductAndClickShoppingCart() throws InterruptedException {
        ProductPage page = new ProductPage(driver);
        YourCartPage cart = new YourCartPage(driver);
        page.addThreeProduct();
        Thread.sleep(3000);
        page.removeThreeProduct();

        Assert.assertEquals(page.addBikeLightText(),"Add to cart");
        Assert.assertEquals(page.addBackpackText(),"Add to cart");
        Assert.assertEquals(page.addFleeceJacketText(),"Add to cart");
        page.clickShoppingCart();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cart.getLogo(),"Swag Labs");
        Assert.assertEquals(cart.getTilte(),"Your Cart");
    }


    @AfterMethod
    public void afterMethod(){
        if(driver != null){
            driver.quit();
        }
    }
}
