package action;

import ui.LoginPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageAction {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPageAction(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password){
        WebElement userInp = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageUI.USER_NAME));
        WebElement passInp = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageUI.PASS_NAME));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(LoginPageUI.LOGIN_BUTTON));

        userInp.clear();
        userInp.sendKeys(username != null ? username : "");
        passInp.clear();
        passInp.sendKeys(password != null ? password : "");
        loginBtn.click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageUI.ERROR_MESSAGE)).getText();
    }

    public boolean isLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageUI.APP_LOGO)).isDisplayed();
    }

    public int getInventoryItemCount() {
        return driver.findElements(LoginPageUI.INVENTORY_ITEM).size();
    }

    public String getLogoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageUI.APP_LOGO)).getText();
    }
}
