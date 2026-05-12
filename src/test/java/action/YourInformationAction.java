package action;

import ui.YourInformationUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourInformationAction {

    private WebDriver driver;
    private WebDriverWait wait;

    public YourInformationAction(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillInformationForm(String firstName, String lastName, String zipCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(zipCode);
    }

    public void enterFirstName(String firstName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(YourInformationUI.FIRST_NAME_INPUT));
        element.clear();
        element.sendKeys(firstName != null ? firstName : "");
    }

    public void enterLastName(String lastName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(YourInformationUI.LAST_NAME_INPUT));
        element.clear();
        element.sendKeys(lastName != null ? lastName : "");
    }

    public void enterPostalCode(String zipCode) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(YourInformationUI.POSTAL_CODE_INPUT));
        element.clear();
        element.sendKeys(zipCode != null ? zipCode : "");
    }

    private void clickByJS(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickContinue(){
        clickByJS(YourInformationUI.CONTINUE_BTN);
    }

    public void clickCancel(){
        clickByJS(YourInformationUI.CANCEL_BTN);
    }

    public String getLogoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourInformationUI.LOGO)).getText();
    }

    public String getTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourInformationUI.TITLE)).getText();
    }

    public boolean isShoppingCartDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourInformationUI.SHOPPING_CART)).isDisplayed();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourInformationUI.ERROR_MESSAGE)).getText();
    }
}
