package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static final By USER_NAME = By.id("user-name");
    public static final By PASS_NAME = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE  = By.xpath("//h3[@data-test='error']");
    public static final By APP_LOGO       = By.className("app_logo");
    public static final By INVENTORY_ITEM = By.className("inventory_item");



    public static void performLogin(WebDriver driver, String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userInp = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.USER_NAME));
        WebElement passInp = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.PASS_NAME));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.LOGIN_BUTTON));

        userInp.sendKeys(username);
        passInp.sendKeys(password);
        loginBtn.click();
    }



}
