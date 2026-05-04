package action;

import UI.LoginPage;
import UI.ProductPage;
import UI.YourCartPage;
import UI.YourInformation;
import Utils.ConfigReader;
import Utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class CustomerYourInformationTest {
    WebDriver driver;
    ConfigReader config;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        config = new ConfigReader();
        driver.get(config.getUrl());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(
                config.getUsername(),
                config.getPassword()
        );
    }

    @Test
    public void testYourInformationUIWithoutNotRemoveProduct() throws InterruptedException {
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.addThreeProduct();
        productPage.clickShoppingCart();
        cartPage.clickCheckout();
        Assert.assertEquals(yourInfor.getLogo(),"Swag Labs");
        Assert.assertEquals(yourInfor.getTitle(),"Checkout: Your Information");
        Assert.assertEquals(yourInfor.getShoppingCartCount(),3);
        Assert.assertTrue(yourInfor.isShoppingCart());
        Assert.assertEquals(yourInfor.getFirstNamePlaceholder(),"First Name");
        Assert.assertEquals(yourInfor.getLastNamePlaceholder(),"Last Name");
        Assert.assertEquals(yourInfor.getZipCodePlaceholder(),"Zip/Postal Code");
        Assert.assertEquals(yourInfor.getCancel(),"Cancel");
        Assert.assertTrue(yourInfor.isCancel());
        Assert.assertEquals(yourInfor.getContinue(),"");
        Assert.assertTrue(yourInfor.isContinue());
    }

    @Test
    public void testYourInformationUIWithoutRemoveBikeProduct() throws InterruptedException {
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.addThreeProduct();
        productPage.clickShoppingCart();
        cartPage.clickRemoveBike();
        cartPage.clickCheckout();
        Assert.assertEquals(yourInfor.getLogo(),"Swag Labs");
        Assert.assertEquals(yourInfor.getTitle(),"Checkout: Your Information");
        Assert.assertEquals(yourInfor.getShoppingCartCount(),2);
        Assert.assertTrue(yourInfor.isShoppingCart());
        Assert.assertEquals(yourInfor.getFirstNamePlaceholder(),"First Name");
        Assert.assertEquals(yourInfor.getLastNamePlaceholder(),"Last Name");
        Assert.assertEquals(yourInfor.getZipCodePlaceholder(),"Zip/Postal Code");
        Assert.assertEquals(yourInfor.getCancel(),"Cancel");
        Assert.assertTrue(yourInfor.isCancel());
        Assert.assertEquals(yourInfor.getContinue(),"");
        Assert.assertTrue(yourInfor.isContinue());
    }

    @Test
    public void testYourInformationUIWithoutRemoveAllProduct() throws InterruptedException {
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.addThreeProduct();
        productPage.clickShoppingCart();
        Thread.sleep(3000);
        cartPage.removeThreeProduct();
        Thread.sleep(3000);
        cartPage.clickCheckout();
        Assert.assertEquals(yourInfor.getLogo(),"Swag Labs");
        Assert.assertEquals(yourInfor.getTitle(),"Checkout: Your Information");
        Assert.assertEquals(yourInfor.getShoppingCartCount(),0);
        Assert.assertTrue(yourInfor.isShoppingCart());
        Assert.assertEquals(yourInfor.getFirstNamePlaceholder(),"First Name");
        Assert.assertEquals(yourInfor.getLastNamePlaceholder(),"Last Name");
        Assert.assertEquals(yourInfor.getZipCodePlaceholder(),"Zip/Postal Code");
        Assert.assertEquals(yourInfor.getCancel(),"Cancel");
        Assert.assertTrue(yourInfor.isCancel());
        Assert.assertEquals(yourInfor.getContinue(),"");
        Assert.assertTrue(yourInfor.isContinue());
    }

    @Test
    public void testBlankAllAndClickContinue() throws InterruptedException {
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.addThreeProduct();
        productPage.clickShoppingCart();
        cartPage.clickCheckout();
        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "blankAll"
        );
        Map<String, String> data = list.get(0);
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String zipCode = data.get("zipCode");
        yourInfor.fillInformationForm(firstName,lastName,zipCode);
        Assert.assertEquals(yourInfor.getFirstNamePlaceholder(),"First Name");
        Assert.assertEquals(yourInfor.getLastNamePlaceholder(),"Last Name");
        Assert.assertEquals(yourInfor.getZipCodePlaceholder(),"Zip/Postal Code");
        yourInfor.clickContinue();
        Assert.assertEquals(yourInfor.getRequiredFirstName(),"Error: First Name is required");
    }

    @Test
    public void testBlankFirstNameAndClickContinue() throws InterruptedException {
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.addThreeProduct();
        productPage.clickShoppingCart();
        cartPage.clickCheckout();
        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "blankFirstName"
        );
        Map<String, String> data = list.get(1);
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String zipCode = data.get("zipCode");
        yourInfor.fillInformationForm(firstName,lastName,zipCode);
        yourInfor.clickContinue();
        Assert.assertEquals(yourInfor.getRequiredFirstName(),"Error: First Name is required");
    }

    @Test
    public void testBlankLastNameAndClickContinue() throws InterruptedException {
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.addThreeProduct();
        productPage.clickShoppingCart();
        cartPage.clickCheckout();
        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "blankLastName"
        );
        Map<String, String> data = list.get(2);
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String zipCode = data.get("zipCode");
        yourInfor.fillInformationForm(firstName,lastName,zipCode);
        Thread.sleep(1000);
        yourInfor.clickContinue();
        Assert.assertEquals(yourInfor.getRequiredLastName(),"Error: Last Name is required");
    }

    @Test
    public void testBlankZipCodeAndClickContinue() throws InterruptedException {
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.addThreeProduct();
        productPage.clickShoppingCart();
        cartPage.clickCheckout();
        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "blankZipCode"
        );
        Map<String, String> data = list.get(3);
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String zipCode = data.get("zipCode");
        yourInfor.fillInformationForm(firstName,lastName,zipCode);
        yourInfor.clickContinue();
        Assert.assertEquals(yourInfor.getRequiredLastName(),"Error: Postal Code is required");
    }

    @Test
    public void testTextOnlyInputAndClickContinue() throws InterruptedException {
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.addThreeProduct();
        productPage.clickShoppingCart();
        cartPage.clickCheckout();
        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "textOnlyInput"
        );
        Map<String, String> data = list.get(4);
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String zipCode = data.get("zipCode");
        yourInfor.fillInformationForm(firstName,lastName,zipCode);
        yourInfor.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
    }

    @Test
    public void testSpecialCharInputAndClickContinue() throws InterruptedException {
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.addThreeProduct();
        productPage.clickShoppingCart();
        cartPage.clickCheckout();
        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "specialCharInput"
        );
        Map<String, String> data = list.get(5);
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String zipCode = data.get("zipCode");
        yourInfor.fillInformationForm(firstName,lastName,zipCode);
        yourInfor.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
    }

    @Test
    public void testSpaceAroundInputAndClickContinue() throws InterruptedException {
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.addThreeProduct();
        productPage.clickShoppingCart();
        cartPage.clickCheckout();
        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "spaceAroundInput"
        );
        Map<String, String> data = list.get(6);
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String zipCode = data.get("zipCode");
        yourInfor.fillInformationForm(firstName,lastName,zipCode);
        yourInfor.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
    }

    @Test
    public void testTextOnlyInputAndClickCancle() throws InterruptedException {
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.addThreeProduct();
        productPage.clickShoppingCart();
        cartPage.clickCheckout();
        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "textOnlyInput"
        );
        Map<String, String> data = list.get(4);
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String zipCode = data.get("zipCode");
        yourInfor.fillInformationForm(firstName,lastName,zipCode);
        yourInfor.clickCancel();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
    }

    @Test
    public void checkDataClearedAfterCancelAndReopenCheckout() throws InterruptedException {
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.addThreeProduct();
        productPage.clickShoppingCart();
        cartPage.clickCheckout();
        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "textOnlyInput"
        );
        Map<String, String> data = list.get(4);
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String zipCode = data.get("zipCode");
        yourInfor.fillInformationForm(firstName,lastName,zipCode);
        yourInfor.clickCancel();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        cartPage.clickCheckout();
        Assert.assertEquals(yourInfor.getFirstNamePlaceholder(),"First Name");
        Assert.assertEquals(yourInfor.getLastNamePlaceholder(),"Last Name");
        Assert.assertEquals(yourInfor.getZipCodePlaceholder(),"Zip/Postal Code");
    }

    @Test
    public void testContinueCheckoutWithoutProducts(){
        YourCartPage cartPage = new YourCartPage(driver);
        YourInformation yourInfor = new YourInformation(driver);
        ProductPage productPage = new ProductPage(driver);
        productPage.clickShoppingCart();
        cartPage.clickCheckout();
        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet2",
                "textOnlyInput"
        );
        Map<String, String> data = list.get(6);
        String firstName = data.get("firstName");
        String lastName = data.get("lastName");
        String zipCode = data.get("zipCode");
        yourInfor.fillInformationForm(firstName,lastName,zipCode);
        yourInfor.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
    }

    @AfterMethod
    public void  afterMethod(){
        if (driver != null) {
            driver.quit();
        }
    }
}
