package testcases;

import action.LoginPageAction;
import Utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Map;

public class LoginHappyUnHappyCaseTest {

    WebDriver driver;
    LoginPageAction loginAction;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/");
        loginAction = new LoginPageAction(driver);
    }

    @Test
    public void testLoginValid() {
        List<Map<String, String>> list = ExcelUtils.readExcelData("login.xlsx", "Sheet1", "valid");
        Map<String, String> data = list.get(0);

        loginAction.login(data.get("userName"), data.get("passWord"));

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(loginAction.isLogoDisplayed());
        Assert.assertTrue(loginAction.getInventoryItemCount() > 0);
    }

    @Test
    public void testLoginInvalid() {
        List<Map<String, String>> list = ExcelUtils.readExcelData("login.xlsx", "Sheet1", "inValid");
        Map<String, String> data = list.get(1);

        loginAction.login(data.get("userName"), data.get("passWord"));
        String errorMsg = loginAction.getErrorMessage();

        Assert.assertTrue(errorMsg.contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void testLoginInvalidPassword() {
        List<Map<String, String>> list = ExcelUtils.readExcelData("login.xlsx", "Sheet1", "invalidPassword");
        Map<String, String> data = list.get(2);

        loginAction.login(data.get("userName"), data.get("passWord"));
        String errorMsg = loginAction.getErrorMessage();

        Assert.assertTrue(errorMsg.contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void testLoginInvalidUser() {
        List<Map<String, String>> list = ExcelUtils.readExcelData("login.xlsx", "Sheet1", "invaliUser");
        Map<String, String> data = list.get(3);

        loginAction.login(data.get("userName"), data.get("passWord"));
        String errorMsg = loginAction.getErrorMessage();

        Assert.assertTrue(errorMsg.contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void testLoginEmptyUserPassword() {
        List<Map<String, String>> list = ExcelUtils.readExcelData("login.xlsx", "Sheet1", "empty");
        Map<String, String> data = list.get(4);

        loginAction.login(data.get("userName"), data.get("passWord"));
        String errorMsg = loginAction.getErrorMessage();

        Assert.assertTrue(errorMsg.contains("Epic sadface: Username is required"));
    }

    @Test
    public void testLoginEmptyPassword() {
        List<Map<String, String>> list = ExcelUtils.readExcelData("login.xlsx", "Sheet1", "emptyPassword");
        Map<String, String> data = list.get(5);

        loginAction.login(data.get("userName"), data.get("passWord"));
        String errorMsg = loginAction.getErrorMessage();

        Assert.assertTrue(errorMsg.contains("Epic sadface: Password is required"));
    }

    @Test
    public void testLoginEmptyUser() {
        List<Map<String, String>> list = ExcelUtils.readExcelData("login.xlsx", "Sheet1", "emptyUser");
        Map<String, String> data = list.get(6);

        loginAction.login(data.get("userName"), data.get("passWord"));
        String errorMsg = loginAction.getErrorMessage();

        Assert.assertTrue(errorMsg.contains("Epic sadface: Username is required"));
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
