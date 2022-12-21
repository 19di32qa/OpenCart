package demoOpenCard.PageObjects.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By LoginBtn = By.xpath("//button[@type=\"submit\"]");
    private final String url ="http://localhost/demoOpenCard/upload/OpenCardAdmin/";
    private final By invalidMessage = By.xpath("//div[@class = \"alert alert-danger alert-dismissible\"]");

    public WebElement getInvalidMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(invalidMessage));
    }

    public void getPage() {
        driver.navigate().to(url);
    }
    public void setUsername(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(username)).sendKeys(name);
    }
    public void setPassword(String pas) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(password)).sendKeys(pas);
    }
    public void Login() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginBtn)).submit();
    }
    public void BaseLogin() {
        getPage();
        setUsername("admin");
        setPassword("12345678");
        Login();
    }

}
