package ui;

import org.openqa.selenium.By;

public class ProductPageUI {
    public static final By LOGO = By.className("app_logo");
    public static final By PRODUCT_TITLE = By.className("title");
    public static final By SORT_DROPDOWN = By.className("product_sort_container");
    public static final By ACTIVE_SORT_OPTION = By.className("active_option");
    public static final By SHOPPING_CART = By.className("shopping_cart_link");
    public static final By SHOPPING_CART_COUNT = By.className("shopping_cart_badge");

    public static final By BACKPACK_NAME = By.id("item_4_title_link");
    public static final By BACKPACK_PRICE = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']");
    public static final By BACKPACK_ADD = By.id("add-to-cart-sauce-labs-backpack");
    public static final By BACKPACK_REMOVE = By.id("remove-sauce-labs-backpack");
    public static final By BIKE_ADD = By.id("add-to-cart-sauce-labs-bike-light");
    public static final By BIKE_REMOVE = By.id("remove-sauce-labs-bike-light");
    public static final By JACKET_ADD = By.id("add-to-cart-sauce-labs-fleece-jacket");
    public static final By JACKET_REMOVE = By.id("remove-sauce-labs-fleece-jacket");
    
    public static final By PRODUCT_NAME_BY_INDEX = By.xpath("(//div[contains(@class,'inventory_item_name')])[INDEX]");
}
