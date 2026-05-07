package action;

import UI.LoginPage;
import Utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Map;

public class LoginHappyUnHappyCaseTest {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/");    }

    @Test
    public void testLoginValid() {

        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "valid"
        );

        Map<String, String> data = list.get(0);

        String user = data.get("userName");
        String pass = data.get("passWord");

        LoginPage.performLogin(driver, user,pass);

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

        WebElement logo = driver.findElement(LoginPage.APP_LOGO);
        Assert.assertTrue(logo.isDisplayed());
        int itemCount = driver.findElements(LoginPage.INVENTORY_ITEM).size();
        Assert.assertTrue(itemCount > 0);
    }

    @Test
    public void testLoginInvalid() {

        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "inValid"
        );

        Map<String, String> data = list.get(1);

        String user = data.get("userName");
        String pass = data.get("passWord");

        LoginPage.performLogin(driver, user,pass);
        WebElement errorMsg = driver.findElement(LoginPage.ERROR_MESSAGE);

        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertTrue(errorMsg.getText().contains(
                "Epic sadface: Username and password do not match any user in this service"
        ));
    }

    @Test
    public void testLoginInvalidPassword() {

        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "invalidPassword"
        );

        Map<String, String> data = list.get(2);

        String user = data.get("userName");
        String pass = data.get("passWord");

        LoginPage.performLogin(driver, user,pass);


        WebElement errorMsg = driver.findElement(LoginPage.ERROR_MESSAGE);

        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertTrue(errorMsg.getText().contains(
                "Epic sadface: Username and password do not match any user in this service"
        ));
    }

    @Test
    public void testLoginInvalidUser() {

        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "invaliUser"
        );

        Map<String, String> data = list.get(3);

        String user = data.get("userName");
        String pass = data.get("passWord");

        LoginPage.performLogin(driver, user,pass);


        WebElement errorMsg = driver.findElement(LoginPage.ERROR_MESSAGE);

        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertTrue(errorMsg.getText().contains(
                "Epic sadface: Username and password do not match any user in this service"
        ));
    }

    @Test
    public void testLoginEmptyUserPassword() {

        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "empty"
        );

        Map<String, String> data = list.get(4);

        String user = data.get("userName");
        String pass = data.get("passWord");

        LoginPage.performLogin(driver, user,pass);


        WebElement errorMsg =  driver.findElement(LoginPage.ERROR_MESSAGE);

        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertTrue(errorMsg.getText().contains(
                "Epic sadface: Username is required"
        ));
    }

    @Test
    public void testLoginEmptyPassword() {

        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "emptyPassword"
        );

        Map<String, String> data = list.get(5);

        String user = data.get("userName");
        String pass = data.get("passWord");

        LoginPage.performLogin(driver, user,pass);


        WebElement errorMsg =  driver.findElement(LoginPage.ERROR_MESSAGE);

        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertTrue(errorMsg.getText().contains(
                "Epic sadface: Password is required"
        ));
    }

    @Test
    public void testLoginEmptyUser() {

        List<Map<String, String>> list = ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "emptyUser"
        );

        Map<String, String> data = list.get(6);

        String user = data.get("userName");
        String pass = data.get("passWord");

        LoginPage.performLogin(driver, user,pass);
        WebElement errorMsg = driver.findElement(LoginPage.ERROR_MESSAGE);
        Assert.assertTrue(errorMsg.isDisplayed());
        Assert.assertTrue(errorMsg.getText().contains(
                "Epic sadface: Username is required"
        ));
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}