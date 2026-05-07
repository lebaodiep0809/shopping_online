package action;

import UI.*;
import Utils.Hook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerComplete extends Hook {

    @Test
    public void testCheckoutCompleteUI() {

        ProductPage page = new ProductPage(driver);
        YourInformation yourInformation = new YourInformation(driver);

        page.addThreeProduct();

        driver.findElement(ProductPage.SHOPPING_CART).click();

        driver.findElement(YourCartPage.CHECKOUT_BTN).click();

        yourInformation.fillInformationForm("A", "B", "123");

        driver.findElement(YourInformation.CONTINUE_BTN).click();

        driver.findElement(Overview.FINISH_BTN).click();

        Assert.assertEquals(
                driver.findElement(Complete.LOGO).getText(),
                "Swag Labs"
        );

        Assert.assertEquals(
                driver.findElement(Complete.TITLE).getText(),
                "Checkout: Complete!"
        );

        Assert.assertTrue(
                driver.findElement(Complete.ICON).isDisplayed()
        );

        Assert.assertTrue(
                driver.findElement(Complete.SHOPPING_CART).isDisplayed()
        );

        Assert.assertEquals(
                driver.findElement(Complete.THANK_YOU).getText(),
                "Thank you for your order!"
        );

        Assert.assertEquals(
                driver.findElement(Complete.COMPLETE_TEXT).getText(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
        );

        Assert.assertTrue(
                driver.findElement(Complete.BACK_HOME).isEnabled()
        );
    }

    @Test
    public void testCheckoutCompleteWithClickBackHome() {

        ProductPage page = new ProductPage(driver);
        YourInformation yourInformation = new YourInformation(driver);

        page.addThreeProduct();

        driver.findElement(ProductPage.SHOPPING_CART).click();

        driver.findElement(YourCartPage.CHECKOUT_BTN).click();

        yourInformation.fillInformationForm("A", "B", "123");

        driver.findElement(YourInformation.CONTINUE_BTN).click();

        driver.findElement(Overview.FINISH_BTN).click();

        driver.findElement(Complete.BACK_HOME).click();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html"
        );

        Assert.assertTrue(
                driver.findElements(ProductPage.SHOPPING_CART_COUNT).isEmpty()
        );
    }
}