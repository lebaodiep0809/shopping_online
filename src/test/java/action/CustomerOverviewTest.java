package action;

import UI.*;
import Utils.Hook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerOverviewTest extends Hook {

    @Test
    public void testOverviewUIWithoutSelectingProductFromProductsPage() {

        ProductPage page = new ProductPage(driver);
        YourInformation yourInformation = new YourInformation(driver);

        page.addThreeProduct();

        driver.findElement(ProductPage.SHOPPING_CART).click();

        driver.findElement(YourCartPage.CHECKOUT_BTN).click();

        yourInformation.fillInformationForm("A", "B", "123");

        driver.findElement(YourInformation.CONTINUE_BTN).click();

        // ================= HEADER =================

        Assert.assertEquals(
                driver.findElement(Overview.LOGO).getText(),
                "Swag Labs"
        );

        Assert.assertEquals(
                driver.findElement(Overview.TITLE).getText(),
                "Checkout: Overview"
        );

        Assert.assertTrue(
                driver.findElement(Overview.SHOPPING_CART).isDisplayed()
        );

        Assert.assertEquals(
                driver.findElement(Overview.SHOPPING_CART_COUNT).getText(),
                "3"
        );

        // ================= TITLE =================

        Assert.assertEquals(
                driver.findElement(Overview.QTY_TITLE).getText(),
                "QTY"
        );

        Assert.assertEquals(
                driver.findElement(Overview.DESC_TITLE).getText(),
                "Description"
        );

        // ================= PAYMENT =================

        Assert.assertEquals(
                driver.findElement(Overview.PAYMENT_INFORMATION).getText(),
                "Payment Information:"
        );

        Assert.assertEquals(
                driver.findElement(Overview.SAUCE_CARD).getText(),
                "SauceCard #31337"
        );

        Assert.assertEquals(
                driver.findElement(Overview.SHIPPING_INFORMATION).getText(),
                "Shipping Information:"
        );

        Assert.assertEquals(
                driver.findElement(Overview.FREE_PONY).getText(),
                "Free Pony Express Delivery!"
        );

        // ================= TOTAL =================

        String itemTotalText =
                driver.findElement(Overview.ITEM_TOTAL).getText();

        String taxText =
                driver.findElement(Overview.TAX).getText();

        String totalText =
                driver.findElement(Overview.TOTAL).getText();

        double itemTotal =
                Double.parseDouble(itemTotalText.replace("Item total: $", ""));

        double tax =
                Double.parseDouble(taxText.replace("Tax: $", ""));

        double total =
                Double.parseDouble(totalText.replace("Total: $", ""));

        Assert.assertTrue(itemTotal > 0);

        Assert.assertTrue(tax >= 0);

        Assert.assertTrue(total > 0);

        Assert.assertEquals(
                total,
                itemTotal + tax,
                0.01
        );

        // ================= BUTTON =================

        Assert.assertTrue(
                driver.findElement(Overview.CANCEL_BTN).isEnabled()
        );

        Assert.assertTrue(
                driver.findElement(Overview.FINISH_BTN).isEnabled()
        );
    }

    @Test
    public void testOverviewUIWithThreeProducts() {

        ProductPage page = new ProductPage(driver);
        YourInformation yourInformation = new YourInformation(driver);

        page.addThreeProduct();

        driver.findElement(ProductPage.SHOPPING_CART).click();

        driver.findElement(YourCartPage.CHECKOUT_BTN).click();

        yourInformation.fillInformationForm("A", "B", "123");

        driver.findElement(YourInformation.CONTINUE_BTN).click();

        // ================= HEADER =================

        Assert.assertEquals(
                driver.findElement(Overview.LOGO).getText(),
                "Swag Labs"
        );

        Assert.assertEquals(
                driver.findElement(Overview.TITLE).getText(),
                "Checkout: Overview"
        );

        Assert.assertTrue(
                driver.findElement(Overview.SHOPPING_CART).isDisplayed()
        );

        Assert.assertEquals(
                driver.findElement(Overview.SHOPPING_CART_COUNT).getText(),
                "3"
        );

        // ================= TITLE =================

        Assert.assertEquals(
                driver.findElement(Overview.QTY_TITLE).getText(),
                "QTY"
        );

        Assert.assertEquals(
                driver.findElement(Overview.DESC_TITLE).getText(),
                "Description"
        );

        // ================= PAYMENT =================

        Assert.assertEquals(
                driver.findElement(Overview.PAYMENT_INFORMATION).getText(),
                "Payment Information:"
        );

        Assert.assertEquals(
                driver.findElement(Overview.SAUCE_CARD).getText(),
                "SauceCard #31337"
        );

        Assert.assertEquals(
                driver.findElement(Overview.SHIPPING_INFORMATION).getText(),
                "Shipping Information:"
        );

        Assert.assertEquals(
                driver.findElement(Overview.FREE_PONY).getText(),
                "Free Pony Express Delivery!"
        );

        // ================= TOTAL =================

        double priceBack =
                Double.parseDouble(
                        driver.findElement(Overview.PRICE_BACKPACK)
                                .getText()
                                .replace("$", "")
                );

        double priceBike =
                Double.parseDouble(
                        driver.findElement(Overview.PRICE_BIKE_LIGHT)
                                .getText()
                                .replace("$", "")
                );

        double priceJacket =
                Double.parseDouble(
                        driver.findElement(Overview.PRICE_JACKET)
                                .getText()
                                .replace("$", "")
                );

        double expectedItemTotal =
                priceBack + priceBike + priceJacket;

        double itemTotal =
                Double.parseDouble(
                        driver.findElement(Overview.ITEM_TOTAL)
                                .getText()
                                .replaceAll("[^0-9.]", "")
                );

        double tax =
                Double.parseDouble(
                        driver.findElement(Overview.TAX)
                                .getText()
                                .replaceAll("[^0-9.]", "")
                );

        double total =
                Double.parseDouble(
                        driver.findElement(Overview.TOTAL)
                                .getText()
                                .replaceAll("[^0-9.]", "")
                );

        Assert.assertEquals(
                itemTotal,
                expectedItemTotal,
                0.01
        );

        Assert.assertEquals(
                total,
                itemTotal + tax,
                0.01
        );

        // ================= BUTTON =================

        Assert.assertTrue(
                driver.findElement(Overview.CANCEL_BTN).isEnabled()
        );

        Assert.assertTrue(
                driver.findElement(Overview.FINISH_BTN).isEnabled()
        );
    }

    @Test
    public void testOverviewWithClickCancel() {

        ProductPage page = new ProductPage(driver);
        YourInformation yourInformation = new YourInformation(driver);

        page.addThreeProduct();

        driver.findElement(ProductPage.SHOPPING_CART).click();

        driver.findElement(YourCartPage.CHECKOUT_BTN).click();

        yourInformation.fillInformationForm("A", "B", "123");

        driver.findElement(YourInformation.CONTINUE_BTN).click();

        driver.findElement(Overview.CANCEL_BTN).click();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html"
        );
    }

    @Test
    public void testOverviewWithClickFinish() {

        ProductPage page = new ProductPage(driver);
        YourInformation yourInformation = new YourInformation(driver);


        page.addThreeProduct();

        driver.findElement(ProductPage.SHOPPING_CART).click();

        driver.findElement(YourCartPage.CHECKOUT_BTN).click();

        yourInformation.fillInformationForm("A", "B", "123");

        driver.findElement(YourInformation.CONTINUE_BTN).click();

        driver.findElement(Overview.FINISH_BTN).click();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/checkout-complete.html"
        );
    }
}