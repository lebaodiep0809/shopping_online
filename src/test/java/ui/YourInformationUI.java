package ui;

import org.openqa.selenium.By;

public class YourInformationUI {
    public static final By LOGO = By.className("app_logo");
    public static final By TITLE = By.className("title");
    public static final By SHOPPING_CART = By.className("shopping_cart_link");
    public static final By SHOPPING_CART_COUNT = By.className("shopping_cart_badge");

    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By POSTAL_CODE_INPUT = By.id("postal-code");

    public static final By CANCEL_BTN = By.id("cancel");
    public static final By CONTINUE_BTN = By.id("continue");

    public static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");
}
