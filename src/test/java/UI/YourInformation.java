package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourInformation {

    private  WebDriver driver;
    private WebDriverWait wait;

    public YourInformation(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static final By LOGO = By.xpath("//div[@class='app_logo']");
    public static final By TITLE = By.xpath("//span[text()='Checkout: Your Information']");
    public static final By SHOPPING_CART = By.xpath("//a[@class='shopping_cart_link']");
    public static final By SHOPPING_CART_COUNT = By.xpath("//span[@class='shopping_cart_badge']");

    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By POSTAL_CODE_INPUT = By.id("postal-code");

    public static final By CANCEL_BTN = By.id("cancel");
    public static final By CONTINUE_BTN = By.id("continue");

    public static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");


    public void fillInformationForm(String firstName, String lastName, String zipCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(zipCode);
    }

    private void enterFirstName(String firstName) {
        driver.findElement(FIRST_NAME_INPUT).clear();
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
    }

    private void enterLastName(String lastName) {
        driver.findElement(LAST_NAME_INPUT).clear();
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
    }

    private void enterPostalCode(String zipCode) {
        driver.findElement(POSTAL_CODE_INPUT).clear();
        driver.findElement(POSTAL_CODE_INPUT).sendKeys(zipCode);
    }

    private void clickByJS(By locator) {
        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public void clickContinue(){
        clickByJS(CONTINUE_BTN);
    }
}