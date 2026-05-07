package action;

import UI.ProductPage;
import UI.YourCartPage;
import UI.YourInformation;
import Utils.Hook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerYourCartTest extends Hook {

    @Test
    public void testYourCartPageUI() {

        ProductPage page = new ProductPage(driver);

        page.addThreeProduct();

        driver.findElement(ProductPage.SHOPPING_CART).click();

        // Logo
        WebElement isLogo = driver.findElement(ProductPage.LOGO);

        Assert.assertTrue(
                isLogo.isDisplayed(),
                "Logo not displayed"
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.LOGO).getText(),
                "Swag Labs"
        );

        // Title
        Assert.assertEquals(
                driver.findElement(YourCartPage.TITLE).getText(),
                "Your Cart"
        );

        // Shopping cart
        Assert.assertTrue(
                driver.findElement(YourCartPage.SHOPPING_CART).isDisplayed(),
                "Cart not displayed"
        );

        // Backpack
        Assert.assertEquals(
                driver.findElement(YourCartPage.BACKPACK_NAME).getText(),
                "Sauce Labs Backpack"
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.BACKPACK_DESC).getText(),
                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.BACKPACK_PRICE).getText(),
                "$29.99"
        );

        // Bike Light
        Assert.assertEquals(
                driver.findElement(YourCartPage.BIKE_NAME).getText(),
                "Sauce Labs Bike Light"
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.BIKE_DESC).getText(),
                "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.BIKE_PRICE).getText(),
                "$9.99"
        );

        // Jacket
        Assert.assertEquals(
                driver.findElement(YourCartPage.JACKET_NAME).getText(),
                "Sauce Labs Fleece Jacket"
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.JACKET_DESC).getText(),
                "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.JACKET_PRICE).getText(),
                "$49.99"
        );
    }

    @Test
    public void testRemoveProductBikeLight() {

        ProductPage page = new ProductPage(driver);
        YourCartPage cartPage = new YourCartPage(driver);

        page.addThreeProduct();

        page.clickShoppingCart();

        cartPage.removeBike();
        Assert.assertEquals(
                driver.findElement(YourCartPage.SHOPPING_CART_COUNT).getText(),
                "2"
        );

        // Backpack
        Assert.assertEquals(
                driver.findElement(YourCartPage.BACKPACK_NAME).getText(),
                "Sauce Labs Backpack"
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.BACKPACK_PRICE).getText(),
                "$29.99"
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.BACKPACK_QTY).getText(),
                "1"
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.BACKPACK_REMOVE_BTN).getText(),
                "Remove"
        );

        // Jacket
        Assert.assertEquals(
                driver.findElement(YourCartPage.JACKET_NAME).getText(),
                "Sauce Labs Fleece Jacket"
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.JACKET_PRICE).getText(),
                "$49.99"
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.JACKET_QTY).getText(),
                "1"
        );

        Assert.assertEquals(
                driver.findElement(YourCartPage.JACKET_REMOVE_BTN).getText(),
                "Remove"
        );
    }

    @Test
    public void testRemoveAllProduct() throws InterruptedException {

        ProductPage productPage = new ProductPage(driver);

        YourCartPage cartPage = new YourCartPage(driver);

        productPage.addThreeProduct();

        driver.findElement(ProductPage.SHOPPING_CART).click();

        cartPage.removeThreeProductWithCart();

        Assert.assertTrue(
                driver.findElements(YourCartPage.SHOPPING_CART_COUNT).isEmpty()
        );
    }

    @Test
    public void testNotRemoveProductAndClickContinueShopping() {

        ProductPage page = new ProductPage(driver);
        YourCartPage cartPage = new YourCartPage(driver);

        page.addThreeProduct();

        page.clickShoppingCart();

        cartPage.clickContinueShopping();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html"
        );

        Assert.assertEquals(
                driver.findElement(ProductPage.SHOPPING_CART_COUNT).getText(),
                "3"
        );

        Assert.assertEquals(
                driver.findElement(ProductPage.JACKET_REMOVE).getText(),
                "Remove"
        );

        Assert.assertEquals(
                driver.findElement(ProductPage.BIKE_REMOVE).getText(),
                "Remove"
        );

        Assert.assertEquals(
                driver.findElement(ProductPage.BACKPACK_REMOVE).getText(),
                "Remove"
        );
    }

    @Test
    public void testRemoveProductBikeLightAndClickContinueShopping() {

        ProductPage page = new ProductPage(driver);
        YourCartPage cartPage = new YourCartPage(driver);

        page.addThreeProduct();

        page.clickShoppingCart();

        cartPage.removeBike();
        cartPage.clickContinueShopping();


        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html"
        );

        Assert.assertEquals(
                driver.findElement(ProductPage.SHOPPING_CART_COUNT).getText(),
                "2"
        );

        Assert.assertEquals(
                driver.findElement(ProductPage.JACKET_REMOVE).getText(),
                "Remove"
        );

        Assert.assertEquals(
                driver.findElement(ProductPage.BIKE_ADD).getText(),
                "Add to cart"
        );

        Assert.assertEquals(
                driver.findElement(ProductPage.BACKPACK_REMOVE).getText(),
                "Remove"
        );
    }

    @Test
    public void testRemoveAllProductAndClickContinueShopping() throws InterruptedException {

        ProductPage page = new ProductPage(driver);

        YourCartPage cartPage = new YourCartPage(driver);

        page.addThreeProduct();

        page.clickShoppingCart();

        cartPage.removeThreeProductWithCart();

        cartPage.clickContinueShopping();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html"
        );

        Assert.assertTrue(
                driver.findElements(ProductPage.SHOPPING_CART_COUNT).isEmpty()
        );

        Assert.assertEquals(
                driver.findElement(ProductPage.JACKET_ADD).getText(),
                "Add to cart"
        );

        Assert.assertEquals(
                driver.findElement(ProductPage.BIKE_ADD).getText(),
                "Add to cart"
        );

        Assert.assertEquals(
                driver.findElement(ProductPage.BACKPACK_ADD).getText(),
                "Add to cart"
        );
    }

    @Test
    public void testNotRemoveProductAndClickCheckout() {

        ProductPage page = new ProductPage(driver);
        YourCartPage cartPage = new YourCartPage(driver);

        page.addThreeProduct();

        page.clickShoppingCart();

        cartPage.clickCheckOut();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/checkout-step-one.html"
        );

        Assert.assertEquals(
                driver.findElement(YourInformation.LOGO).getText(),
                "Swag Labs"
        );

        Assert.assertEquals(
                driver.findElement(YourInformation.TITLE).getText(),
                "Checkout: Your Information"
        );

        Assert.assertEquals(
                driver.findElement(YourInformation.SHOPPING_CART_COUNT).getText(),
                "3"
        );
    }

    @Test
    public void testRemoveProductBikeLightAndClickCheckout() {

        ProductPage page = new ProductPage(driver);
        YourCartPage cartPage = new YourCartPage(driver);

        page.addThreeProduct();

        page.clickShoppingCart();
        cartPage.removeBike();
        cartPage.clickCheckOut();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/checkout-step-one.html"
        );

        Assert.assertEquals(
                driver.findElement(YourInformation.LOGO).getText(),
                "Swag Labs"
        );

        Assert.assertEquals(
                driver.findElement(YourInformation.TITLE).getText(),
                "Checkout: Your Information"
        );

        Assert.assertEquals(
                driver.findElement(YourInformation.SHOPPING_CART_COUNT).getText(),
                "2"
        );
    }

    @Test
    public void testRemoveAllProductAndClickCheckout() throws InterruptedException {

        ProductPage page = new ProductPage(driver);

        YourCartPage cartPage = new YourCartPage(driver);

        page.addThreeProduct();

        page.clickShoppingCart();

        cartPage.removeThreeProductWithCart();

        cartPage.clickCheckOut();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/checkout-step-one.html"
        );

        Assert.assertEquals(
                driver.findElement(YourInformation.LOGO).getText(),
                "Swag Labs"
        );

        Assert.assertEquals(
                driver.findElement(YourInformation.TITLE).getText(),
                "Checkout: Your Information"
        );

        Assert.assertTrue(
                driver.findElements(YourInformation.SHOPPING_CART_COUNT).isEmpty()
        );
    }

    @Test
    public void testClickCheckoutWhenNoProductAdded() {

        driver.findElement(ProductPage.SHOPPING_CART).click();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/cart.html"
        );
    }
}