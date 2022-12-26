package demoOpenCard.PageObjects.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerLoginPage {
    WebDriver driver;
    public CustomerLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By email = By.id("input-email");
    private final By password = By.id("input-password");
    private final By loginBtn = By.xpath("//button[@type = \"submit\"]");
    private final By invalidLoginWarning = By.xpath("//*[text()=\" Warning: No match for E-Mail Address and/or Password. \"]");

    public void BaseLogin() {
        getEmail().sendKeys("AlexiosGor+1@example.com");
        getPassword().sendKeys("12345678");
        getLoginBtn().click();
    }
    public WebElement getEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(email));
    }
    public WebElement getPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(password));
    }
    public WebElement getLoginBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn));
    }
    public WebElement getInvalidMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(invalidLoginWarning));
    }
    public WebElement validLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()=\"My Account\"]")));
    }
}
