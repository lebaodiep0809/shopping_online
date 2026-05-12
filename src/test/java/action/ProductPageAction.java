package action;

import ui.ProductPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPageAction {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPageAction(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void clickByJS(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickShoppingCart(){
        clickByJS(ProductPageUI.SHOPPING_CART);
    }

    public void addThreeProduct() {
        clickByJS(ProductPageUI.BACKPACK_ADD);
        clickByJS(ProductPageUI.BIKE_ADD);
        clickByJS(ProductPageUI.JACKET_ADD);
    }

    public void removeThreeProduct() {
        clickByJS(ProductPageUI.BACKPACK_REMOVE);
        clickByJS(ProductPageUI.BIKE_REMOVE);
        clickByJS(ProductPageUI.JACKET_REMOVE);
    }

    public void sortByIndex(int index) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.SORT_DROPDOWN)));
        select.selectByIndex(index);
    }

    public String getActiveSortText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.ACTIVE_SORT_OPTION)).getText();
    }

    public String getLogoText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.LOGO)).getText();
    }

    public boolean isLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.LOGO)).isDisplayed();
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.PRODUCT_TITLE)).getText();
    }

    public boolean isSortDropdownDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.SORT_DROPDOWN)).isDisplayed();
    }

    public boolean isShoppingCartDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.SHOPPING_CART)).isDisplayed();
    }

    public String getBackpackName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.BACKPACK_NAME)).getText();
    }

    public String getBackpackPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.BACKPACK_PRICE)).getText();
    }

    public boolean isBackpackAddButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.BACKPACK_ADD)).isDisplayed();
    }

    public boolean isBikeAddButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.BIKE_ADD)).isDisplayed();
    }

    public boolean isJacketAddButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.JACKET_ADD)).isDisplayed();
    }

    public String getCartCount() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.SHOPPING_CART_COUNT)).getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public boolean isCartBadgeDisplayed() {
        return !driver.findElements(ProductPageUI.SHOPPING_CART_COUNT).isEmpty();
    }

    public String getJacketRemoveButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.JACKET_REMOVE)).getText();
    }

    public String getSortTextByIndex(int index) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageUI.SORT_DROPDOWN)));
        return select.getOptions().get(index).getText();
    }

    public String getProductNameByIndex(int index) {
        String xpath = "(//div[contains(@class,'inventory_item_name')])[" + index + "]";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
    }
}
