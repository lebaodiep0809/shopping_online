package action;

import ui.OverviewUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OverviewAction {

    private WebDriver driver;
    private WebDriverWait wait;

    public OverviewAction(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(OverviewUI.FINISH_BTN)).click();
    }

    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(OverviewUI.CANCEL_BTN)).click();
    }

    public String getLogoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(OverviewUI.LOGO)).getText();
    }

    public String getTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(OverviewUI.TITLE)).getText();
    }

    public String getQtyTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(OverviewUI.QTY_TITLE)).getText();
    }

    public String getDescTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(OverviewUI.DESC_TITLE)).getText();
    }

    public String getItemTotalText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(OverviewUI.ITEM_TOTAL)).getText();
    }

    public String getTaxText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(OverviewUI.TAX)).getText();
    }

    public String getTotalText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(OverviewUI.TOTAL)).getText();
    }

    public boolean isBackpackDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(OverviewUI.PRODUCT_BACKPACK)).isDisplayed();
    }
}
