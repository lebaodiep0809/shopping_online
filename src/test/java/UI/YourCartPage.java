package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourCartPage {
    WebDriver driver;
    WebDriverWait wait;

    public YourCartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By logo = By.xpath("//div[@class='app_logo']");
    private By title = By.xpath("//span[@class='title']");
    private By qtyTilte = By.xpath("//div[@class='cart_quantity_label']");
    private By desTilte = By.xpath("//div[@class='cart_desc_label']");
    private By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");
    private By shoppingCartCount = By.xpath("//span[@class='shopping_cart_badge']");

    //Backpack
    private By productBack = By.xpath("//div[text()='Sauce Labs Backpack']");
    private By serialBack = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']/descendant::div[text()='1']");
    private By inforBack = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']/descendant::div[@class='inventory_item_desc']");
    private By priceBack = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']/descendant::div[@class='inventory_item_price']");
    private By removeBack = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']/descendant::button[@class='btn btn_secondary btn_small cart_button']");

    //Bike Light
    private By productBike = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private By inforBike = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']/descendant::div[@class='inventory_item_desc']");
    private By serialBike = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']/descendant::div[@class='cart_quantity']");
    private By removeBike = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']/descendant::button[@class='btn btn_secondary btn_small cart_button']");
    private By priceBike = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']/descendant::div[@class='inventory_item_price']");

    //Sauce Labs Fleece Jacket
    private By productJacket = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    private By inforJacket = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']/descendant::div[@class='inventory_item_desc']");
    private By serialJacket = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']/descendant::div[@class='cart_quantity']");
    private By priceJacket = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']/descendant::div[@class='inventory_item_price']");
    private By removeJacket = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']/descendant::button[@class='btn btn_secondary btn_small cart_button']");

    private By continueShopping = By.xpath("//button[@id='continue-shopping']");
    private By checkout = By.xpath("//button[@id='checkout']");




    public String getLogo(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).getText();
    }

    public  String getTilte(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public String getQtyTilte(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(qtyTilte)).getText();
    }

    public String getDesTilte(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(desTilte)).getText();
    }

    public boolean isShoppingCartEnable(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCart)).isEnabled();
    }
    public boolean isShoppingCartCountDisable(){
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

    public String getProductBack(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productBack)).getText();
    }

    public String getSerialBack(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(serialBack)).getText();
    }

    public String getInforBack(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inforBack)).getText();
    }

    public String getPriceBack(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priceBack)).getText();
    }

    public String getRemoveBack(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeBack)).getText();
    }

    public void clickRemoveBack(){
        wait.until(ExpectedConditions.elementToBeClickable(removeBack)).click();
    }

    public boolean isRemoveBackEnable(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(removeBack)).isEnabled();
    }

    //
    public String getProductJacket(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productJacket)).getText();
    }

    public String getSerialJacket(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(serialJacket)).getText();
    }

    public String getInforJacket(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inforJacket)).getText();
    }

    public String getPriceJacket(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priceJacket)).getText();
    }

    public String getRemoveJacket(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeJacket)).getText();
    }

    public void clickRemoveJacket(){
        wait.until(ExpectedConditions.elementToBeClickable(removeJacket)).click();
    }

    public boolean isRemoveJacketEnable(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeJacket)).isEnabled();
    }

    //
    public String getProductBike(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productBike)).getText();
    }

    public String getSerialBike(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(serialBike)).getText();
    }

    public String getInforBike(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inforBike)).getText();
    }

    public String getPriceBike(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priceBike)).getText();
    }

    public String getRemoveBike(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeBike)).getText();
    }

    public void clickRemoveBike(){
        wait.until(ExpectedConditions.elementToBeClickable(removeBike)).click();
    }

    public boolean isRemoveBikeEnable(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeBike)).isEnabled();
    }

    //

    public void clickContinueShopping(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShopping)).click();
    }
    public void getContinueShopping(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopping)).getText();
    }
    public boolean isContinueShoppingEnable(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopping)).isEnabled();
    }

    public void clickCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
    }

    public String getCheckout(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(checkout)).getText();
    }

    public boolean isCheckoutEnable(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkout)).isEnabled();
    }


}
