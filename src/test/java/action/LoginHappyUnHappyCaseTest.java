package action;

import UI.LoginPage;
import Utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class LoginHappyUnHappyCaseTest {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        System.out.println("==== Khởi tạo ===");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("=== Mở trang web ===");
        driver.get("https://www.saucedemo.com/");
    }
    //Thực hiện test login vơới ueser và pass hợp lệ
    @Test
    public void testLoginValid(){
        List<Map<String, String>> list =   ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "valid"
        );
        Map<String, String> data = list.get(0);
        String user = data.get("userName");
        String pass = data.get("passWord");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(user,pass);
        //Xác nhận vào trang bằng action
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        //Kiểm tra logo & sản phẩm
        WebElement appLogo = driver.findElement(By.className("app_logo"));
        Assert.assertTrue(appLogo.isDisplayed(),"App logo is disaplay on invertor page");

        //Kiểm tra có ít nhất 1 sản phẩm được hiển thị
        int itemCount = driver.findElements(By.className("inventory_item")).size();
        Assert.assertTrue(itemCount > 0, "No product displayed on inventory page!");
    }

    //Thực hiện test login với ueser và password không hợp lệ
    @Test
    public void testLoginInValid(){
        List<Map<String, String>> list =   ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "inValid"
        );
        Map<String, String> data = list.get(1);
        String user = data.get("userName");
        String pass = data.get("passWord");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(user,pass);

        //Kiểm tra thông báo lỗi
        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed");
        Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    //Thực hiện test login với user đúng và password sai
    @Test
    public void testLoginInValidPassWord(){
        List<Map<String, String>> list =   ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "invalidPassword"
        );
        Map<String, String> data = list.get(2);
        String user = data.get("userName");
        String pass = data.get("passWord");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(user,pass);

        //Kiểm tra thông báo lỗi
        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed");
        Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    //Thực hiện test login với user sai và password đúng
    @Test
    public void testLoginInValidUser(){
        List<Map<String, String>> list =   ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "invaliUser"
        );
        Map<String, String> data = list.get(3);
        String user = data.get("userName");
        String pass = data.get("passWord");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(user,pass);

        //Kiểm tra thông báo lỗi
        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed");
        Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    //Thực hiện test login khi để trống user và password
    @Test
    public void testLoginEmptyUserPassWord(){
        List<Map<String, String>> list =   ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "empty"
        );
        Map<String, String> data = list.get(4);
        String user = data.get("userName");
        String pass = data.get("passWord");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(user,pass);

        //Kiểm tra thông báo lỗi
        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed");
        Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username is required"));
    }

    // Thực hiên test login khi để trống password
    @Test
    public void testLoginEmptyPassWord(){
        List<Map<String, String>> list =   ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "emptyPassword"
        );
        Map<String, String> data = list.get(5);
        String user = data.get("userName");
        String pass = data.get("passWord");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(user,pass);

        //Kiểm tra thông báo lỗi
        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed");
        Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Password is required"));
    }

    // Thực hiện test login khi để trống user
    @Test
    public void testLoginEmptyUser(){
        List<Map<String, String>> list =   ExcelUtils.readExcelData(
                "login.xlsx",
                "Sheet1",
                "emptyUser"
        );
        Map<String, String> data = list.get(6);
        String user = data.get("userName");
        String pass = data.get("passWord");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.performLogin(user,pass);

        //Kiểm tra thông báo lỗi
        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed");
        Assert.assertTrue(errorMsg.getText().contains("Epic sadface: Username is required"));
    }



    @AfterClass
    public void afterClass() {
        System.out.println("=== @AfterClass: Đóng Driver - Chạy sau tất cả các method trong class này ===");
        if (driver != null) {
            driver.quit();
        }
    }


}
