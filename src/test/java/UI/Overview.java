package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Overview {

    WebDriver driver;
    WebDriverWait wait;

    public Overview(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ================= HEADER =================
    private By logo = By.className("app_logo");
    private By title = By.className("title");
    private By qtyTitle = By.className("cart_quantity_label");
    private By descTitle = By.className("cart_desc_label");

    // ================= PRODUCTS =================

    // BACKPACK
    private By productBack = By.xpath("//div[text()='Sauce Labs Backpack']");
    private By serialBack = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='cart_quantity']");
    private By inforBack = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='inventory_item_desc']");
    private By priceBack = By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']");

    // BIKE LIGHT
    private By productBike = By.xpath("//div[text()='Sauce Labs Bike Light']");
    private By serialBike = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']//div[@class='cart_quantity']");
    private By inforBike = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']//div[@class='inventory_item_desc']");
    private By priceBike = By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']");

    // FLEECE JACKET
    private By productJacket = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    private By serialJacket = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//div[@class='cart_quantity']");
    private By inforJacket = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//div[@class='inventory_item_desc']");
    private By priceJacket = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']");

    // ================= PAYMENT =================
    private By paymentInformation = By.xpath("//div[contains(text(),'Payment Information:')]");
    private By sauceCard = By.xpath("//div[contains(text(),'SauceCard')]");
    private By shippingInformation = By.xpath("//div[contains(text(),'Shipping Information:')]");
    private By freePony = By.xpath("//div[contains(text(),'Free Pony Express Delivery!')]");

    // ================= TOTAL =================
    private By itemTotal = By.cssSelector("[data-test='subtotal-label']");
    private By tax = By.cssSelector("[data-test='tax-label']");
    private By total = By.cssSelector("[data-test='total-label']");

    // ================= BUTTON =================
    private By cancel = By.id("cancel");
    private By finish = By.id("finish");

    private By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");
    private By shoppingCartCount = By.xpath("//span[@class='shopping_cart_badge']");

    // ================= HEADER METHODS =================
    public String getLogo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).getText().trim();
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText().trim();
    }

    public String getQtyTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(qtyTitle)).getText().trim();
    }

    public String getDescTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(descTitle)).getText().trim();
    }

    public boolean isShoppingCartDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCart)).isDisplayed();
    }

    public int getShoppingCartCount() {
        try {
            return Integer.parseInt(
                    wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartCount))
                            .getText().trim()
            );
        } catch (Exception e) {
            return 0;
        }
    }

    // ================= PAYMENT METHODS =================
    public String getPaymentInformation() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInformation)).getText().trim();
    }

    public String getSauceCard() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sauceCard)).getText().trim();
    }

    public String getShippingInformation() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shippingInformation)).getText().trim();
    }

    public String getFreeExpress() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(freePony)).getText().trim();
    }

    // ================= TOTAL METHODS =================
    public double getItemTotalPrice() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(itemTotal))
                .getText().replace("Item total: $", "").trim();
        return Double.parseDouble(text);
    }

    public double getTaxPrice() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(tax))
                .getText().replace("Tax: $", "").trim();
        return Double.parseDouble(text);
    }

    public double getTotalPrice() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(total))
                .getText().replace("Total: $", "").trim();
        return Double.parseDouble(text);
    }

    // ================= PRODUCTS METHODS =================

    // BACKPACK
    public String getProductBackName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productBack)).getText().trim();
    }

    public String getProductBackInfo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inforBack)).getText().trim();
    }

    public String getBackPrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priceBack)).getText();
    }

    public double getProductBackPrice() {
        return Double.parseDouble(
                wait.until(ExpectedConditions.visibilityOfElementLocated(priceBack))
                        .getText().replace("$", "").trim()
        );
    }

    // BIKE
    public String getProductBikeName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productBike)).getText().trim();
    }

    public String getProductBikeInfo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inforBike)).getText().trim();
    }

    public String getBikePrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priceBike)).getText();
    }



    public double getProductBikePrice() {
        return Double.parseDouble(
                wait.until(ExpectedConditions.visibilityOfElementLocated(priceBike))
                        .getText().replace("$", "").trim()
        );
    }

    // JACKET
    public String getProductJacketName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productJacket)).getText().trim();
    }

    public String getProductJacketInfo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inforJacket)).getText().trim();
    }

    public String getJacketPrice(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(priceJacket)).getText();
    }

    public double getProductJacketPrice() {
        return Double.parseDouble(
                wait.until(ExpectedConditions.visibilityOfElementLocated(priceJacket))
                        .getText().replace("$", "").trim()
        );
    }

    // ================= TOTAL PRODUCTS =================
    public double getAllProductsTotal() {
        return getProductBackPrice()
                + getProductBikePrice()
                + getProductJacketPrice();
    }

    // ================= ACTION =================
    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancel)).click();
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(finish)).click();
    }

    public boolean isCancelEnable() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cancel)).isEnabled();
    }

    public boolean isFinishEnable() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(finish)).isEnabled();
    }
}