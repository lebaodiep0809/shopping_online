package UI;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Overview {

    WebDriver driver;
    WebDriverWait wait;

    public Overview(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= HEADER =================
    public  static final By LOGO = By.className("app_logo");
    public  static final By TITLE = By.className("title");
    public  static final By QTY_TITLE = By.className("cart_quantity_label");
    public  static final By DESC_TITLE = By.className("cart_desc_label");

// ================= PRODUCTS =================

    // BACKPACK
    public  static final By PRODUCT_BACKPACK = By.xpath("//div[text()='Sauce Labs Backpack']");
    public  static final By SERIAL_BACKPACK = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='cart_quantity']");
    public  static final By INFO_BACKPACK = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='inventory_item_desc']");
    public  static final By PRICE_BACKPACK = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']");

    // BIKE LIGHT
    public  static final By PRODUCT_BIKE_LIGHT = By.xpath("//div[text()='Sauce Labs Bike Light']");
    public  static final By SERIAL_BIKE_LIGHT = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']//div[@class='cart_quantity']");
    public  static final By INFO_BIKE_LIGHT = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']//div[@class='inventory_item_desc']");
    public  static final By PRICE_BIKE_LIGHT = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']");

    // FLEECE JACKET
    public  static final By PRODUCT_JACKET = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    public  static final By SERIAL_JACKET = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//div[@class='cart_quantity']");
    public  static final By INFO_JACKET = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//div[@class='inventory_item_desc']");
    public  static final By PRICE_JACKET = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']");

    // ================= PAYMENT =================
    public  static final By PAYMENT_INFORMATION = By.xpath("//div[contains(text(),'Payment Information:')]");
    public  static final By SAUCE_CARD = By.xpath("//div[contains(text(),'SauceCard')]");
    public  static final By SHIPPING_INFORMATION = By.xpath("//div[contains(text(),'Shipping Information:')]");
    public  static final By FREE_PONY = By.xpath("//div[contains(text(),'Free Pony Express Delivery!')]");

    // ================= TOTAL =================
    public  static final By ITEM_TOTAL = By.cssSelector("[data-test='subtotal-label']");
    public  static final By TAX = By.cssSelector("[data-test='tax-label']");
    public  static final By TOTAL = By.cssSelector("[data-test='total-label']");

    // ================= BUTTON =================
    public  static final By CANCEL_BTN = By.id("cancel");
    public  static final By FINISH_BTN = By.id("finish");

    // ================= CART =================
    public  static final By SHOPPING_CART = By.className("shopping_cart_link");
    public  static final By SHOPPING_CART_COUNT = By.className("shopping_cart_badge");


}