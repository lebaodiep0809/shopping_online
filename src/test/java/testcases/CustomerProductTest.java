package testcases;

import action.ProductPageAction;
import action.YourCartPageAction;
import Utils.Hook;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerProductTest extends Hook {
    ProductPageAction productAction;

    @BeforeMethod
    public void setUpPage() {
        productAction = new ProductPageAction(driver);
    }

    @Test
    public void testProductPageUI() {
        Assert.assertTrue(productAction.isLogoDisplayed(), "Logo not displayed");
        Assert.assertEquals(productAction.getLogoText(), "Swag Labs");
        Assert.assertEquals(productAction.getTitle(), "Products");
        Assert.assertTrue(productAction.isSortDropdownDisplayed(), "Sort dropdown not displayed");
        Assert.assertEquals(productAction.getSortTextByIndex(1), "Name (Z to A)");
        Assert.assertTrue(productAction.isShoppingCartDisplayed(), "Shopping cart not displayed");

        Assert.assertEquals(productAction.getBackpackName(), "Sauce Labs Backpack");
        Assert.assertEquals(productAction.getBackpackPrice(), "$29.99");
        Assert.assertTrue(productAction.isBackpackAddButtonDisplayed(), "Backpack add button not displayed");
        Assert.assertTrue(productAction.isBikeAddButtonDisplayed(), "Bike add button not displayed");
        Assert.assertTrue(productAction.isJacketAddButtonDisplayed(), "Jacket add button not displayed");
    }

    @Test
    public void testAddThreeProducts() {
        productAction.addThreeProduct();
        Assert.assertEquals(productAction.getCartCount(), "3");
        Assert.assertEquals(productAction.getJacketRemoveButtonText(), "Remove");
    }

    @Test
    public void testRemoveThreeProducts() {
        productAction.addThreeProduct();
        productAction.removeThreeProduct();
        Assert.assertFalse(productAction.isCartBadgeDisplayed(), "Cart badge still displayed");
    }

    @Test
    public void testSortProductNameAToZ() {
        productAction.sortByIndex(0);
        Assert.assertEquals(productAction.getActiveSortText(), "Name (A to Z)");
        Assert.assertEquals(productAction.getProductNameByIndex(1), "Sauce Labs Backpack");
    }

    @Test
    public void testSortProductNameZToA() {
        productAction.sortByIndex(1);
        Assert.assertEquals(productAction.getActiveSortText(), "Name (Z to A)");
    }

    @Test
    public void testShoppingCart() {
        productAction.clickShoppingCart();
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        Assert.assertEquals(yourCartAction.getLogoText(), "Swag Labs");
        Assert.assertEquals(yourCartAction.getTitleText(), "Your Cart");
    }

    @Test
    public void testRemoveAllProductAndClickShoppingCart() {
        productAction.addThreeProduct();
        productAction.removeThreeProduct();
        productAction.clickShoppingCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }
}
