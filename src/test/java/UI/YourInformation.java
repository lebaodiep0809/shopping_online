package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourInformation {
    WebDriver driver;
    WebDriverWait wait;

    public YourInformation(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By logo = By.xpath("//div[@class='app_logo']");
    private By title = By.xpath("//span[text()='Checkout: Your Information']");
    private By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");
    private By shoppingCartCount = By.xpath("//span[@class='shopping_cart_badge']");
    private By firstNameFile = By.xpath("//input[@id='first-name']");
    private By lastNameFile = By.xpath("//input[@id='last-name']");
    private By zipPostalCodeFile = By.xpath("//input[@id='postal-code']");
    private By cancel = By.xpath("//button[@id='cancel']");
    private By continueInfor = By.xpath("//input[@id='continue']");

    public String getLogo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).getText();
    }
    public String getTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }
    public boolean isShoppingCart(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCart)).isEnabled();
    }
    public boolean isShoppingCartCount(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartCount)).isDisplayed();
    }
    public int getShoppingCartCount(){
        try {
            String text = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(shoppingCartCount)
            ).getText().trim();

            return Integer.parseInt(text);

        } catch (Exception e){
            return 0;
        }
    }
    public String getFirstNamePlaceholder(){
        return driver.findElement(firstNameFile).getAttribute("placeholder");
    }

    public void enterFirstName(String firstName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFile));
        driver.findElement(firstNameFile).sendKeys(firstName);
    }

    public String getLastNamePlaceholder(){
        return driver.findElement(lastNameFile).getAttribute("placeholder");
    }

    public void enterLastName(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFile));
        driver.findElement(lastNameFile).sendKeys(lastName);
    }

    public String getZipCodePlaceholder(){
        return driver.findElement(zipPostalCodeFile).getAttribute("placeholder");
    }

    public void enterZipCode(String zipCode){
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipPostalCodeFile));
        driver.findElement(zipPostalCodeFile).sendKeys(zipCode);
    }

    public String getCancel(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cancel)).getText();
    }

    public boolean isCancel(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cancel)).isEnabled();
    }
    public void clickCancel(){
        wait.until(ExpectedConditions.elementToBeClickable(cancel)).click();
    }

    public String getContinue(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(continueInfor)).getText();
    }

    public boolean isContinue(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(continueInfor)).isEnabled();
    }

    public void clickContinue(){
        wait.until(ExpectedConditions.elementToBeClickable(continueInfor)).click();
    }






}
