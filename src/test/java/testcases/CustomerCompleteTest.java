package testcases;

import action.*;
import Utils.Hook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerCompleteTest extends Hook {

    @Test
    public void testCheckoutCompleteUI() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);
        YourInformationAction yourInformationAction = new YourInformationAction(driver);
        OverviewAction overviewAction = new OverviewAction(driver);
        CompleteAction completeAction = new CompleteAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();

        yourCartAction.clickCheckOut();

        yourInformationAction.fillInformationForm("A", "B", "123");
        yourInformationAction.clickContinue();

        overviewAction.clickFinish();

        Assert.assertEquals(completeAction.getLogoText(), "Swag Labs");
        Assert.assertEquals(completeAction.getTitleText(), "Checkout: Complete!");
        Assert.assertTrue(completeAction.isIconDisplayed());
        Assert.assertTrue(completeAction.isShoppingCartDisplayed());
        Assert.assertEquals(completeAction.getThankYouText(), "Thank you for your order!");
        Assert.assertEquals(completeAction.getCompleteText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        Assert.assertTrue(completeAction.isBackHomeButtonEnabled());
    }

    @Test
    public void testCheckoutCompleteWithClickBackHome() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);
        YourInformationAction yourInformationAction = new YourInformationAction(driver);
        OverviewAction overviewAction = new OverviewAction(driver);
        CompleteAction completeAction = new CompleteAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();

        yourCartAction.clickCheckOut();

        yourInformationAction.fillInformationForm("A", "B", "123");
        yourInformationAction.clickContinue();

        overviewAction.clickFinish();

        completeAction.clickBackHome();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertFalse(productAction.isCartBadgeDisplayed());
    }
}
