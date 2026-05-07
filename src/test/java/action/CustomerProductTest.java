package action;

import UI.ProductPage;
import UI.YourCartPage;
import Utils.Hook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerProductTest extends Hook {
    ProductPage page;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpPage() {
        // Khởi tạo page object sau khi driver từ Hook đã sẵn sàng
        page = new ProductPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

        @Test
        public void testProductPageUI() {

            ProductPage page = new ProductPage(driver);

            // ================= LOGO =================

            WebElement logo = driver.findElement(ProductPage.LOGO);

            Assert.assertTrue(
                    logo.isDisplayed(),
                    "Logo not displayed"
            );

            Assert.assertEquals(
                    logo.getText(),
                    "Swag Labs"
            );

            // ================= TITLE =================

            Assert.assertEquals(
                    driver.findElement(ProductPage.PRODUCT_TITLE).getText(),
                    "Products"
            );

            // ================= SORT =================

            Assert.assertTrue(
                    driver.findElement(ProductPage.SORT_DROPDOWN).isDisplayed(),
                    "Sort dropdown not displayed"
            );

            Assert.assertEquals(
                    page.getSortTextByIndex(1),
                    "Name (Z to A)"
            );

            // ================= SHOPPING CART =================

            Assert.assertTrue(
                    driver.findElement(ProductPage.SHOPPING_CART).isDisplayed(),
                    "Shopping cart not displayed"
            );

            // ================= BACKPACK =================

            Assert.assertEquals(
                    driver.findElement(ProductPage.BACKPACK_NAME).getText(),
                    "Sauce Labs Backpack"
            );

            Assert.assertEquals(
                    driver.findElement(ProductPage.BACKPACK_PRICE).getText(),
                    "$29.99"
            );

            Assert.assertTrue(
                    driver.findElement(ProductPage.BACKPACK_ADD).isDisplayed(),
                    "Backpack add button not displayed"
            );

            // ================= BIKE =================

            Assert.assertTrue(
                    driver.findElement(ProductPage.BIKE_ADD).isDisplayed(),
                    "Bike add button not displayed"
            );

            // ================= JACKET =================

            Assert.assertTrue(
                    driver.findElement(ProductPage.JACKET_ADD).isDisplayed(),
                    "Jacket add button not displayed"
            );
        }


    @Test
    public void testAddThreeProducts() {

        ProductPage page = new ProductPage(driver);

        page.addThreeProduct();

        Assert.assertEquals(
                driver.findElement(ProductPage.SHOPPING_CART_COUNT).getText(),
                "3");
        Assert.assertEquals(driver.findElement(ProductPage.JACKET_REMOVE).getText(), "Remove");
    }

    @Test
    public void testRemoveThreeProducts() {

        ProductPage page = new ProductPage(driver);

        page.addThreeProduct();

        page.removeThreeProduct();

        Assert.assertTrue(
                driver.findElements(ProductPage.SHOPPING_CART_COUNT).isEmpty(),
                "Cart badge still displayed"
        );
    }

    @Test
    public void testSortProductNameAToZ() {

        ProductPage page = new ProductPage(driver);

        // Sort A -> Z
        page.sortByIndex(0);

        // Verify active option
        Assert.assertEquals(
                driver.findElement(ProductPage.ACTIVE_SORT_OPTION).getText(),
                "Name (A to Z)"
        );

        // Verify first product after sorting
        Assert.assertEquals(
                page.getProductNameByIndex(1),
                "Sauce Labs Backpack"
        );
    }

    @Test
    public void testSortProductNameZToA() {

        ProductPage page = new ProductPage(driver);

        page.sortByIndex(1);

        Assert.assertEquals(
                driver.findElement(ProductPage.ACTIVE_SORT_OPTION).getText(),
                "Name (Z to A)"
        );
    }

    @Test
    public void testShoppingCart() {
        driver.findElement(ProductPage.SHOPPING_CART).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        // Cần .getText() cho logo và title
        Assert.assertEquals(driver.findElement(YourCartPage.LOGO).getText(), "Swag Labs");
        Assert.assertEquals(driver.findElement(YourCartPage.TITLE).getText(), "Your Cart");
    }

    @Test
    public void testRemoveAllProductAndClickShoppingCart() {
        page.addThreeProduct();
        page.removeThreeProduct();
        page.clickShoppingCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    }
}