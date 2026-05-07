package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators giữ nguyên static final là đúng chuẩn
    public static final By LOGO = By.className("app_logo");
    public static final By PRODUCT_TITLE = By.className("title");
    public static final By SORT_DROPDOWN = By.className("product_sort_container");
    public static final By ACTIVE_SORT_OPTION = By.className("active_option");
    public static final By SHOPPING_CART = By.className("shopping_cart_link");
    public static final By SHOPPING_CART_COUNT = By.className("shopping_cart_badge");

    // Các locator sản phẩm (Rút gọn cho bạn dễ nhìn, giữ nguyên phần cũ của bạn)
    public static final By BACKPACK_NAME = By.id("item_4_title_link");
    public static final By BACKPACK_PRICE = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']");
    public static final By BACKPACK_ADD = By.id("add-to-cart-sauce-labs-backpack");
    public static final By BACKPACK_REMOVE = By.id("remove-sauce-labs-backpack");
    public static final By BIKE_ADD = By.id("add-to-cart-sauce-labs-bike-light");
    public static final By BIKE_REMOVE = By.id("remove-sauce-labs-bike-light");
    public static final By JACKET_ADD = By.id("add-to-cart-sauce-labs-fleece-jacket");
    public static final By JACKET_REMOVE = By.id("remove-sauce-labs-fleece-jacket");

    // ================= METHODS (ĐÃ BỎ STATIC) =================

    private void clickByJS(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickShoppingCart(){
        clickByJS(SHOPPING_CART);
    }

    public void addThreeProduct() {
        clickByJS(BACKPACK_ADD);
        clickByJS(BIKE_ADD);
        clickByJS(JACKET_ADD);
    }

    public void removeThreeProduct() {
        clickByJS(BACKPACK_REMOVE);
        clickByJS(BIKE_REMOVE);
        clickByJS(JACKET_REMOVE);
    }

    public void sortByIndex(int index) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(SORT_DROPDOWN)));
        select.selectByIndex(index);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACTIVE_SORT_OPTION));
    }

    public String getSortTextByIndex(int index) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(SORT_DROPDOWN)));
        return select.getOptions().get(index).getText();
    }

    public String getProductNameByIndex(int index) {
        // XPath trong Selenium bắt đầu từ 1, index truyền vào nên khớp với thứ tự hiển thị
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[contains(@class,'inventory_item_name')])[" + index + "]")
        )).getText();
    }
}