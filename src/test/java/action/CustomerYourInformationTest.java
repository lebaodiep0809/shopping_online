package action;

import UI.*;
import Utils.ExcelUtils;
import Utils.Hook;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class CustomerYourInformationTest extends Hook {


    @Test
    public void testYourInformationUIWithoutNotRemoveProduct() {
        ProductPage page = new ProductPage(driver);
        YourCartPage cartPage = new YourCartPage(driver);

        // Add product
        page.addThreeProduct();

        // Click cart
        page.clickShoppingCart();

        // Verify đã vào cart page
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/cart.html"
        );

        // Click checkout
        cartPage.clickCheckOut();

        // Verify đã vào Your Information page
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/checkout-step-one.html"
        );

        // LOGO
        Assert.assertEquals(
                driver.findElement(YourInformation.LOGO).getText(),
                "Swag Labs"
        );

        // TITLE
        Assert.assertEquals(
                driver.findElement(YourInformation.TITLE).getText(),
                "Checkout: Your Information"
        );

        // CART COUNT
        Assert.assertEquals(
                driver.findElement(YourInformation.SHOPPING_CART_COUNT).getText(),
                "3"
        );

        // CART ICON
        Assert.assertTrue(
                driver.findElement(YourInformation.SHOPPING_CART).isDisplayed()
        );

        // INPUT PLACEHOLDER
        Assert.assertEquals(
                driver.findElement(YourInformation.FIRST_NAME_INPUT)
                        .getAttribute("placeholder"),
                "First Name"
        );

        Assert.assertEquals(
                driver.findElement(YourInformation.LAST_NAME_INPUT)
                        .getAttribute("placeholder"),
                "Last Name"
        );

        Assert.assertEquals(
                driver.findElement(YourInformation.POSTAL_CODE_INPUT)
                        .getAttribute("placeholder"),
                "Zip/Postal Code"
        );

        // BUTTON
        Assert.assertEquals(
                driver.findElement(YourInformation.CANCEL_BTN).getText(),
                "Cancel"
        );

        Assert.assertTrue(
                driver.findElement(YourInformation.CANCEL_BTN).isDisplayed()
        );

        Assert.assertTrue(
                driver.findElement(YourInformation.CONTINUE_BTN).isDisplayed()
        );
    }
    @Test
    public void testYourInformationUIWithoutRemoveBikeProduct() {

        ProductPage page = new ProductPage(driver);

        page.addThreeProduct();

        driver.findElement(ProductPage.SHOPPING_CART).click();

        driver.findElement(YourCartPage.BIKE_REMOVE_BTN).click();

        driver.findElement(YourCartPage.CHECKOUT_BTN).click();

        Assert.assertEquals(
                driver.findElement(YourInformation.SHOPPING_CART_COUNT).getText(),
                "2"
        );
    }

    @Test
    public void testYourInformationUIWithoutRemoveAllProduct() throws InterruptedException {

        ProductPage page = new ProductPage(driver);
        YourCartPage cartPage = new YourCartPage(driver);

        page.addThreeProduct();

        page.clickShoppingCart();

        YourCartPage.removeThreeProductWithCart();
        cartPage.clickCheckOut();

        Assert.assertTrue(
                driver.findElements(YourInformation.SHOPPING_CART_COUNT).isEmpty()
        );
    }

    @Test
    public void testBlankAllAndClickContinue() {

        ProductPage page = new ProductPage(driver);
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation informationPage = new YourInformation(driver);

        page.addThreeProduct();
        page.clickShoppingCart();
        cartPage.clickCheckOut();

        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "blankAll"
        );

        Map<String, String> data = list.get(0);

        informationPage.fillInformationForm(
                data.get("firstName"),
                data.get("lastName"),
                data.get("zipCode")
        );

        driver.findElement(YourInformation.CONTINUE_BTN).click();

        Assert.assertEquals(
                driver.findElement(YourInformation.ERROR_MESSAGE).getText(),
                "Error: First Name is required"
        );
    }

    @Test
    public void testBlankFirstNameAndClickContinue() throws InterruptedException {

        ProductPage page = new ProductPage(driver);
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation informationPage = new YourInformation(driver);

        page.addThreeProduct();

        page.clickShoppingCart();

        cartPage.clickCheckOut();

        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "blankFirstName"
        );

        Map<String, String> data = list.get(1);

        informationPage.fillInformationForm(
                data.get("firstName"),
                data.get("lastName"),
                data.get("zipCode")
        );

        informationPage.clickContinue();

        Assert.assertEquals(
                driver.findElement(YourInformation.ERROR_MESSAGE).getText(),
                "Error: First Name is required"
        );
    }

    @Test
    public void testBlankLastNameAndClickContinue() {

        ProductPage page = new ProductPage(driver);
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation informationPage = new YourInformation(driver);

        page.addThreeProduct();

        page.clickShoppingCart();

        cartPage.clickCheckOut();

        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "blankLastName"
        );

        Map<String, String> data = list.get(2);

        System.out.println(data);

        informationPage.fillInformationForm(
                data.get("firstName"),
                data.get("lastName"),
                data.get("zipCode")
        );

        informationPage.clickContinue();

        Assert.assertEquals(
                driver.findElement(YourInformation.ERROR_MESSAGE).getText(),
                "Error: Last Name is required"
        );
    }

    @Test
    public void testBlankZipCodeAndClickContinue() {

        ProductPage page = new ProductPage(driver);
        YourInformation yourInformation = new YourInformation(driver);

        page.addThreeProduct();

        driver.findElement(ProductPage.SHOPPING_CART).click();

        driver.findElement(YourCartPage.CHECKOUT_BTN).click();

        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "blankZipCode"
        );

        Map<String, String> data = list.get(3);

        yourInformation.fillInformationForm(
                data.get("firstName"),
                data.get("lastName"),
                data.get("zipCode")
        );

        driver.findElement(YourInformation.CONTINUE_BTN).click();

        Assert.assertEquals(
                driver.findElement(YourInformation.ERROR_MESSAGE).getText(),
                "Error: Postal Code is required"
        );
    }

    @Test
    public void testTextOnlyInputAndClickContinue() {

        ProductPage page = new ProductPage(driver);
        YourInformation yourInformation = new YourInformation(driver);

        page.addThreeProduct();

        driver.findElement(ProductPage.SHOPPING_CART).click();

        driver.findElement(YourCartPage.CHECKOUT_BTN).click();

        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "textOnlyInput"
        );

        Map<String, String> data = list.get(4);

        yourInformation.fillInformationForm(
                data.get("firstName"),
                data.get("lastName"),
                data.get("zipCode")
        );

        driver.findElement(YourInformation.CONTINUE_BTN).click();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/checkout-step-two.html"
        );
    }
}