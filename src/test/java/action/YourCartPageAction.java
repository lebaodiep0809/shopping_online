package action;

import ui.YourCartPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourCartPageAction {
    private WebDriver driver;
    private WebDriverWait wait;

    public YourCartPageAction(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void clickByJS(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickContinueShopping(){
        clickByJS(YourCartPageUI.CONTINUE_SHOPPING_BTN);
    }

    public void clickCheckOut(){
        clickByJS(YourCartPageUI.CHECKOUT_BTN);
    }

    public String getLogoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartPageUI.LOGO)).getText();
    }

    public String getTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartPageUI.TITLE)).getText();
    }

    public String getQtyTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartPageUI.QTY_TITLE)).getText();
    }

    public String getDescTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartPageUI.DESC_TITLE)).getText();
    }

    public boolean isShoppingCartDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartPageUI.SHOPPING_CART)).isDisplayed();
    }

    public String getBackpackName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartPageUI.BACKPACK_NAME)).getText();
    }

    public String getBackpackQty() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartPageUI.BACKPACK_QTY)).getText();
    }

    public String getBackpackPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartPageUI.BACKPACK_PRICE)).getText();
    }

    public boolean isBackpackRemoveBtnDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartPageUI.BACKPACK_REMOVE_BTN)).isDisplayed();
    }

    public boolean isBikeNameDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartPageUI.BIKE_NAME)).isDisplayed();
    }

    public boolean isJacketNameDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartPageUI.JACKET_NAME)).isDisplayed();
    }

    public String getCartCount() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(YourCartPageUI.SHOPPING_CART_COUNT)).getText();
        } catch (Exception e) {
            return "0";
        }
    }
}
