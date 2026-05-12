package ui;

import org.openqa.selenium.By;

public class YourCartPageUI {
    public static final By LOGO = By.xpath("//div[@class='app_logo']");
    public static final By TITLE = By.xpath("//span[@class='title']");
    public static final By QTY_TITLE = By.xpath("//div[@class='cart_quantity_label']");
    public static final By DESC_TITLE = By.xpath("//div[@class='cart_desc_label']");
    public static final By SHOPPING_CART = By.xpath("//a[@class='shopping_cart_link']");
    public static final By SHOPPING_CART_COUNT = By.xpath("//span[@class='shopping_cart_badge']");

    public static final By BACKPACK_NAME = By.xpath("//div[text()='Sauce Labs Backpack']");
    public static final By BACKPACK_QTY = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='cart_quantity']");
    public static final By BACKPACK_PRICE = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']");
    public static final By BACKPACK_REMOVE_BTN = By.id("remove-sauce-labs-backpack");

    public static final By BIKE_NAME = By.xpath("//div[text()='Sauce Labs Bike Light']");
    public static final By JACKET_NAME = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");

    public static final By CONTINUE_SHOPPING_BTN = By.id("continue-shopping");
    public static final By CHECKOUT_BTN = By.id("checkout");
}
