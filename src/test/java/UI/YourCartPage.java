package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourCartPage {
    static WebDriver driver;
    WebDriverWait wait;

    public YourCartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ===== COMMON =====
    public static final By LOGO = By.xpath("//div[@class='app_logo']");
    public static final By TITLE = By.xpath("//span[@class='title']");
    public static final By QTY_TITLE = By.xpath("//div[@class='cart_quantity_label']");
    public static final By DESC_TITLE = By.xpath("//div[@class='cart_desc_label']");
    public static final By SHOPPING_CART = By.xpath("//a[@class='shopping_cart_link']");
    public static final By SHOPPING_CART_COUNT = By.xpath("//span[@class='shopping_cart_badge']");

    // ===== BACKPACK =====
    public static final By BACKPACK_NAME = By.xpath("//div[text()='Sauce Labs Backpack']");
    public static final By BACKPACK_QTY = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='cart_quantity']");
    public static final By BACKPACK_DESC = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='inventory_item_desc']");
    public static final By BACKPACK_PRICE = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']");
    public static final By BACKPACK_REMOVE_BTN = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//button[contains(@class,'cart_button')]");

    // ===== BIKE LIGHT =====
    public static final By BIKE_NAME = By.xpath("//div[text()='Sauce Labs Bike Light']");
    public static final By BIKE_QTY = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']//div[@class='cart_quantity']");
    public static final By BIKE_DESC = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']//div[@class='inventory_item_desc']");
    public static final By BIKE_PRICE = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']");
    public static final By BIKE_REMOVE_BTN = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']//button[contains(@class,'cart_button')]");

    // ===== JACKET =====
    public static final By JACKET_NAME = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    public static final By JACKET_QTY = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//div[@class='cart_quantity']");
    public static final By JACKET_DESC = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//div[@class='inventory_item_desc']");
    public static final By JACKET_PRICE = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']");
    public static final By JACKET_REMOVE_BTN = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//button[contains(@class,'cart_button')]");

    // ===== ACTION =====
    public static final By CONTINUE_SHOPPING_BTN = By.id("continue-shopping");
    public static final By CHECKOUT_BTN = By.id("checkout");



    public static void clickByJS(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void clickContinueShopping(){
        clickByJS(CONTINUE_SHOPPING_BTN);
    }

    public static void clickCheckOut(){
        clickByJS(CHECKOUT_BTN);
    }

    public static void removeBike(){
        clickByJS(ProductPage.BIKE_REMOVE);
    }

    public static void removeBack(){
        clickByJS(ProductPage.BACKPACK_REMOVE);
    }

    public static void removeJacket(){
        clickByJS(ProductPage.JACKET_REMOVE);
    }

    public static void removeThreeProductWithCart() throws InterruptedException {
        removeBike();
        removeBack();
        removeJacket();
    }

}
