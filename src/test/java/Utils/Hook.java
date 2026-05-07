package Utils;

import UI.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Hook {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        LoginPage.performLogin(driver,"standard_user","secret_sauce");
    }

    @AfterMethod
    public void  afterMethod(){
        if (driver != null) {
            driver.quit();
        }
    }
}
