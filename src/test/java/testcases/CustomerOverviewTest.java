package testcases;

import action.*;
import Utils.Hook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerOverviewTest extends Hook {

    @Test
    public void testOverviewUI() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);
        YourInformationAction yourInformationAction = new YourInformationAction(driver);
        OverviewAction overviewAction = new OverviewAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();
        yourCartAction.clickCheckOut();
        yourInformationAction.fillInformationForm("A", "B", "123");
        yourInformationAction.clickContinue();

        Assert.assertEquals(overviewAction.getLogoText(), "Swag Labs");
        Assert.assertEquals(overviewAction.getTitleText(), "Checkout: Overview");
        Assert.assertEquals(overviewAction.getQtyTitleText(), "QTY");
        Assert.assertEquals(overviewAction.getDescTitleText(), "Description");

        String itemTotalText = overviewAction.getItemTotalText();
        String taxText = overviewAction.getTaxText();
        String totalText = overviewAction.getTotalText();

        double itemTotal = Double.parseDouble(itemTotalText.replaceAll("[^0-9.]", ""));
        double tax = Double.parseDouble(taxText.replaceAll("[^0-9.]", ""));
        double total = Double.parseDouble(totalText.replaceAll("[^0-9.]", ""));

        Assert.assertTrue(itemTotal > 0);
        Assert.assertTrue(tax >= 0);
        Assert.assertTrue(total > 0);
        Assert.assertEquals(total, itemTotal + tax, 0.01);
    }

    @Test
    public void testOverviewWithClickCancel() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);
        YourInformationAction yourInformationAction = new YourInformationAction(driver);
        OverviewAction overviewAction = new OverviewAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();
        yourCartAction.clickCheckOut();
        yourInformationAction.fillInformationForm("A", "B", "123");
        yourInformationAction.clickContinue();

        overviewAction.clickCancel();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void testOverviewWithClickFinish() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);
        YourInformationAction yourInformationAction = new YourInformationAction(driver);
        OverviewAction overviewAction = new OverviewAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();
        yourCartAction.clickCheckOut();
        yourInformationAction.fillInformationForm("A", "B", "123");
        yourInformationAction.clickContinue();

        overviewAction.clickFinish();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
    }
}
