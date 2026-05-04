package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Complete {
    WebDriver driver;
    WebDriverWait wait;

    public Complete(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By logo = By.className("app_logo");
    private By title = By.className("title");
    private By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");
    private By icon = By.className("pony_express");
    private By thankYou = By.className("complete-header");
    private By completeText = By.className("complete-text");
    private By backHome = By.id("back-to-products");


    public String getLogo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).getText();
    }

    public String getTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public boolean isIconDisble(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(icon)).isDisplayed();
    }

    public String getThankYou(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(thankYou)).getText();
    }

    public String getCompleteText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(completeText)).getText();
    }

    public boolean isShoppingCartDisable(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCart)).isDisplayed();
    }

    public void clickBackHome(){
        wait.until(ExpectedConditions.elementToBeClickable(backHome)).click();
    }

    public boolean isBackHomeDisable(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(backHome)).isDisplayed();
    }

}
