package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  class Complete {
    WebDriver driver;
    WebDriverWait wait;

    public   Complete(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static final By LOGO = By.className("app_logo");
    public static final By TITLE = By.className("title");
    public static final By SHOPPING_CART = By.xpath("//a[@class='shopping_cart_link']");
    public static final By ICON = By.className("pony_express");
    public static final By THANK_YOU = By.className("complete-header");
    public static final By COMPLETE_TEXT = By.className("complete-text");
    public static final By BACK_HOME = By.id("back-to-products");

}
