package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourCart {
    WebDriver driver;
    WebDriverWait wait;

    public YourCart (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By logo = By.xpath("//div[@class='app_logo']");
    private By title = By.xpath("//span[@class='title']");




    public String getLogo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).getText();
    }

    public  String getTilte(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }
}
