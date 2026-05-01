package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By userNameFile = By.id("user-name");
    private By passWordFile = By.id("password");
    private By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUserName(String userName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameFile)).clear();
        driver.findElement(userNameFile).sendKeys(userName);
    }

    public  void enterPassWord (String passWord){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passWordFile)).clear();
        driver.findElement(passWordFile).sendKeys(passWord);
    }

    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }

    public  void fillLoginForm (String userName, String passWord){
        enterUserName(userName);
        enterPassWord(passWord);
    }

    public void performLogin(String userName, String passWord){
        fillLoginForm(userName, passWord);
        clickLogin();
    }

    public ProductPage login (String user, String pass){
        driver.findElement(userNameFile).sendKeys(user);
        driver.findElement(passWordFile).sendKeys(pass);
        driver.findElement(loginBtn).click();
        return  new ProductPage(driver);
    }


}
