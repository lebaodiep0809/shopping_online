package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= COMMON =================
    private By logo = By.className("app_logo");
    private By proName = By.xpath("//span[@class='title']");
    private By arrange  = By.xpath("//select[@class='product_sort_container']");
    private By activeSort = By.className("active_option");
    private By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");
    private By shoppingCartCount = By.xpath("//span[@class='shopping_cart_badge']");

    // ================= BACKPACK =================
    private By productBack = By.xpath("//div[text()='Sauce Labs Backpack']");
    private By inforBack   = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_desc']");
    private By priceBack   = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']");
    private By addBack  = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBack = By.id("remove-sauce-labs-backpack");
    private By itemBack = By.xpath("//img[@alt='Sauce Labs Backpack']");

    // ================= BIKE =================
    private By productBike = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private By inforBike = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_desc']");
    private By priceBike = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']");
    private By addBike = By.id("add-to-cart-sauce-labs-bike-light");
    private By removeBike = By.id("remove-sauce-labs-bike-light");
    private By itemBike = By.xpath("//img[@alt='Sauce Labs Bike Light']");

    // ================= JACKET =================
    private By productJack = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    private By inforJack = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_desc']");
    private By priceJack = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']");
    private By addJack = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By removeJack = By.id("remove-sauce-labs-fleece-jacket");
    private By itemJack = By.xpath("//img[@alt='Sauce Labs Fleece Jacket']");

    // ================= COMMON =================
    public boolean isLogoDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    public String getTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(proName)).getText();
    }

    public boolean isArrangeDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(arrange)).isDisplayed();
    }

    public void sortTextByIndex(int index){

        Select select = new Select(
                wait.until(ExpectedConditions.visibilityOfElementLocated(arrange))
        );

        select.selectByIndex(index);

        wait.until(ExpectedConditions.visibilityOfElementLocated(activeSort));
    }
    public String getSortTextByIndex(int index){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(arrange)));
        return select.getOptions().get(index).getText();
    }
    public String getProductNameByIndex(int index){

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//div[contains(@class,'inventory_item_name')])[" + index + "]")
                )
        ).getText();
    }
    public boolean isShoppingCartDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCart)).isDisplayed();
    }

    public void clickShoppingCart(){
         wait.until(ExpectedConditions.elementToBeClickable(shoppingCart)).click();
    }

    // ================= CART COUNT =================
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

    // ================= BACKPACK =================
    public String getBackpackName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productBack)).getText();
    }

    public String getBackpackInfo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inforBack)).getText();
    }

    public String getBackpackPrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priceBack)).getText();
    }

    public boolean isBackpackImageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(itemBack)).isDisplayed();
    }

    public void addBackpack(){
        wait.until(ExpectedConditions.elementToBeClickable(addBack)).click();
    }

    public String addBackpackText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addBack)).getText();
    }

    public void removeBackpack(){
        wait.until(ExpectedConditions.elementToBeClickable(removeBack)).click();
    }

    public String removeBackpackText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeBack)).getText();
    }

    // ================= BIKE =================
    public String getBikeName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productBike)).getText();
    }

    public String getBikeInfo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inforBike)).getText();
    }

    public String getBikePrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priceBike)).getText();
    }

    public boolean isBikeImageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(itemBike)).isDisplayed();
    }

    public void addBikeLight(){
        wait.until(ExpectedConditions.elementToBeClickable(addBike)).click();
    }

    public void removeBikeLight(){
        wait.until(ExpectedConditions.elementToBeClickable(removeBike)).click();
    }

    public String addBikeLightText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addBike)).getText();
    }

    public String removeBikeLightText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeBike)).getText();
    }

    // ================= JACKET =================
    public String getJacketName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productJack)).getText();
    }

    public String getJacketInfo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inforJack)).getText();
    }

    public String getJacketPrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priceJack)).getText();
    }

    public boolean isJacketImageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(itemJack)).isDisplayed();
    }

    public void addFleeceJacket(){
        wait.until(ExpectedConditions.elementToBeClickable(addJack)).click();
    }

    public void removeFleeceJacket(){
        wait.until(ExpectedConditions.elementToBeClickable(removeJack)).click();
    }

    public String addFleeceJacketText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addJack)).getText();
    }

    public String removeFleeceJacketText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(removeJack)).getText();
    }


}