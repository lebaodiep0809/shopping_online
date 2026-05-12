package ui;

import org.openqa.selenium.By;

public class OverviewUI {
    public static final By LOGO = By.className("app_logo");
    public static final By TITLE = By.className("title");
    public static final By QTY_TITLE = By.className("cart_quantity_label");
    public static final By DESC_TITLE = By.className("cart_desc_label");

    public static final By PRODUCT_BACKPACK = By.xpath("//div[text()='Sauce Labs Backpack']");
    public static final By ITEM_TOTAL = By.cssSelector("[data-test='subtotal-label']");
    public static final By TAX = By.cssSelector("[data-test='tax-label']");
    public static final By TOTAL = By.cssSelector("[data-test='total-label']");

    public static final By CANCEL_BTN = By.id("cancel");
    public static final By FINISH_BTN = By.id("finish");
}
