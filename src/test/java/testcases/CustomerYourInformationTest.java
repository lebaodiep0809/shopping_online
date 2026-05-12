package testcases;

import action.ProductPageAction;
import action.YourCartPageAction;
import action.YourInformationAction;
import Utils.ExcelUtils;
import Utils.Hook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class CustomerYourInformationTest extends Hook {

    @Test
    public void testYourInformationUI() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);
        YourInformationAction yourInformationAction = new YourInformationAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();
        yourCartAction.clickCheckOut();

        Assert.assertEquals(yourInformationAction.getLogoText(), "Swag Labs");
        Assert.assertEquals(yourInformationAction.getTitleText(), "Checkout: Your Information");
        Assert.assertTrue(yourInformationAction.isShoppingCartDisplayed());
    }

    @Test
    public void testBlankFirstNameAndClickContinue() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);
        YourInformationAction yourInformationAction = new YourInformationAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();
        yourCartAction.clickCheckOut();

        List<Map<String, String>> list = ExcelUtils.readExcelData("login.xlsx", "Sheet2", "blankFirstName");
        Map<String, String> data = list.get(1);

        yourInformationAction.fillInformationForm(data.get("firstName"), data.get("lastName"), data.get("zipCode"));
        yourInformationAction.clickContinue();

        Assert.assertEquals(yourInformationAction.getErrorMessage(), "Error: First Name is required");
    }

    @Test
    public void testBlankLastNameAndClickContinue() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);
        YourInformationAction yourInformationAction = new YourInformationAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();
        yourCartAction.clickCheckOut();

        List<Map<String, String>> list = ExcelUtils.readExcelData("login.xlsx", "Sheet2", "blankLastName");
        Map<String, String> data = list.get(2);

        yourInformationAction.fillInformationForm(data.get("firstName"), data.get("lastName"), data.get("zipCode"));
        yourInformationAction.clickContinue();

        Assert.assertEquals(yourInformationAction.getErrorMessage(), "Error: Last Name is required");
    }

    @Test
    public void testBlankZipCodeAndClickContinue() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);
        YourInformationAction yourInformationAction = new YourInformationAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();
        yourCartAction.clickCheckOut();

        List<Map<String, String>> list = ExcelUtils.readExcelData("login.xlsx", "Sheet2", "blankZipCode");
        Map<String, String> data = list.get(3);

        yourInformationAction.fillInformationForm(data.get("firstName"), data.get("lastName"), data.get("zipCode"));
        yourInformationAction.clickContinue();

        Assert.assertEquals(yourInformationAction.getErrorMessage(), "Error: Postal Code is required");
    }

    @Test
    public void testTextOnlyInputAndClickContinue() {
        ProductPageAction productAction = new ProductPageAction(driver);
        YourCartPageAction yourCartAction = new YourCartPageAction(driver);
        YourInformationAction yourInformationAction = new YourInformationAction(driver);

        productAction.addThreeProduct();
        productAction.clickShoppingCart();
        yourCartAction.clickCheckOut();

        List<Map<String, String>> list = ExcelUtils.readExcelData("login.xlsx", "Sheet2", "textOnlyInput");
        Map<String, String> data = list.get(4);

        yourInformationAction.fillInformationForm(data.get("firstName"), data.get("lastName"), data.get("zipCode"));
        yourInformationAction.clickContinue();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
    }
}
