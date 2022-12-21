package demoOpenCard.PageObjects.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerCreationPage {
    WebDriver driver;
    public CustomerCreationPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By firstName = By.xpath("//*[text()=\"First Name\"]/ancestor::div[@class=\"row mb-3 required\"]//input");
    private final By lastName = By.name("lastname");
    private final By email = By.name("email");
    private final By password = By.name("password");
    private final By confirm = By.name("confirm");
    private final By saveBtn = By.xpath("//button[@type=\"submit\"]");
    private final By successMessage = By.xpath("//div[@class = \"alert alert-success alert-dismissible\"]");

    public WebElement getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(successMessage));
    }

    public WebElement getFirstNameInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
    }
    public WebElement getLastNameInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(lastName));
    }
    public WebElement getEmailInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(email));
    }
    public WebElement getPasswordInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(password));
    }
    public WebElement getConfirmInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(confirm));
    }
    public WebElement getSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
    }

}
