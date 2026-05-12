package action;

import ui.CompleteUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompleteAction {
    private WebDriver driver;
    private WebDriverWait wait;

    public CompleteAction(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getLogoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CompleteUI.LOGO)).getText();
    }

    public String getTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CompleteUI.TITLE)).getText();
    }

    public boolean isIconDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CompleteUI.ICON)).isDisplayed();
    }

    public boolean isShoppingCartDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CompleteUI.SHOPPING_CART)).isDisplayed();
    }

    public String getThankYouText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CompleteUI.THANK_YOU)).getText();
    }

    public String getCompleteText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CompleteUI.COMPLETE_TEXT)).getText();
    }

    public boolean isBackHomeButtonEnabled() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CompleteUI.BACK_HOME)).isEnabled();
    }

    public void clickBackHome() {
        wait.until(ExpectedConditions.elementToBeClickable(CompleteUI.BACK_HOME)).click();
    }
}
