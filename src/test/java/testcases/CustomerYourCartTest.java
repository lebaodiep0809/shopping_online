package testcases;

import action.ProductPageAction;
import action.YourCartPageAction;
import Utils.Hook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerYourCartTest extends Hook {

    @Test
    public void testYourCartPageUI() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();

        Assert.assertTrue(yourCartAction.isShoppingCartDisplayed(), "Cart not displayed");
        Assert.assertEquals(yourCartAction.getLogoText(), "Swag Labs");
        Assert.assertEquals(yourCartAction.getTitleText(), "Your Cart");

        Assert.assertEquals(yourCartAction.getBackpackName(), "Sauce Labs Backpack");
        Assert.assertEquals(yourCartAction.getBackpackPrice(), "$29.99");
        Assert.assertTrue(yourCartAction.isBikeNameDisplayed());
        Assert.assertTrue(yourCartAction.isJacketNameDisplayed());
    }

    @Test
    public void testRemoveProductBikeLight() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();

        productAction.removeThreeProduct();
        
        Assert.assertEquals(yourCartAction.getCartCount(), "0");
    }

    @Test
    public void testNotRemoveProductAndClickContinueShopping() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();

        yourCartAction.clickContinueShopping();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(productAction.getCartCount(), "3");
    }

    @Test
    public void testClickCheckoutWhenNoProductAdded() {
        ProductPageAction productAction = new ProductPageAction(driver);
        productAction.clickShoppingCart();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }
}
