package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    // ===== COMMON =====
    private By logo = By.className("app_logo");
    private By proName = By.xpath("//span[@class='title']");
    private By arrange  = By.xpath("//select[@class='product_sort_container']");
    private By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");

    // ===== BACKPACK =====
    private By productBack = By.xpath("//div[text()='Sauce Labs Backpack']");
    private By inforBack   = By.xpath("//div[text()='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']");
    private By priceBack   = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']");
    private By addBack  = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBack = By.id("remove-sauce-labs-backpack");
    private By itemBack = By.xpath("//img[@alt='Sauce Labs Backpack']");

    // ===== BIKE =====
    private By productBike = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private By inforBike = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_desc']");
    private By priceBike = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']");
    private By addBike = By.id("add-to-cart-sauce-labs-bike-light");
    private By removeBike = By.id("remove-sauce-labs-bike-light");
    private By itemBike = By.xpath("//img[@alt='Sauce Labs Bike Light']");

    // ===== JACKET =====
    private By productJack = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    private By inforJack = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_desc']");
    private By priceJack = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']");
    private By addJack = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By remvoJack = By.id("remove-sauce-labs-fleece-jacket");
    private By itemJack = By.xpath("//img[@alt='Sauce Labs Fleece Jacket']");

    // ===== COMMON METHOD =====
    public boolean isLogoDisplayed(){
        return driver.findElement(logo).isDisplayed();
    }

    public String getTitle(){
        return driver.findElement(proName).getText();
    }

    public boolean isArrangeDisplayed(){
        return driver.findElement(arrange).isDisplayed();
    }

    public boolean isShoppingCartDisplayed(){
        return driver.findElement(shoppingCart).isDisplayed();
    }

    // ===== BACKPACK =====
    public String getBackpackName(){
        return driver.findElement(productBack).getText();
    }

    public String getBackpackInfo(){
        return driver.findElement(inforBack).getText();
    }

    public String getBackpackPrice(){
        return driver.findElement(priceBack).getText();
    }

    public boolean isBackpackImageDisplayed(){
        return driver.findElement(itemBack).isDisplayed();
    }

    public void addBackpack(){
        driver.findElement(addBack).click();
    }

    public void removeBackpack(){
        driver.findElement(removeBack).click();
    }

    // ===== BIKE =====
    public String getBikeName(){
        return driver.findElement(productBike).getText();
    }

    public String getBikeInfo(){
        return driver.findElement(inforBike).getText();
    }

    public String getBikePrice(){
        return driver.findElement(priceBike).getText();
    }

    public boolean isBikeImageDisplayed(){
        return driver.findElement(itemBike).isDisplayed();
    }

    public void addBike(){
        driver.findElement(addBike).click();
    }

    public void removeBike(){
        driver.findElement(removeBike).click();
    }

    // ===== JACKET =====
    public String getJacketName(){
        return driver.findElement(productJack).getText();
    }

    public String getJacketInfo(){
        return driver.findElement(inforJack).getText();
    }

    public String getJacketPrice(){
        return driver.findElement(priceJack).getText();
    }

    public boolean isJacketImageDisplayed(){
        return driver.findElement(itemJack).isDisplayed();
    }

    public void addJacket(){
        driver.findElement(addJack).click();
    }

    public void removeJacket(){
        driver.findElement(remvoJack).click();
    }
}