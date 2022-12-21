package demoOpenCard.PageObjects.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterAccount {
    WebDriver driver;
    public RegisterAccount(WebDriver driver) {
        this.driver = driver;
    }
    private final By firstname = By.name("firstname");
    private final By lastname = By.name("lastname");
    private final By email = By.name("email");
    private final By password = By.name("password");
    private final By agree = By.xpath("//input[@type=\"checkbox\"]");
    private final By continueBtn = By.xpath("//button[text()=\"Continue\"]");
    private final By successMessage = By.xpath("//h1[text()=\"Your Account Has Been Created!\"]");
    private final By continueLink = By.xpath("//a[text()=\"Continue\"]");

    public WebElement getContinueLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(continueLink));
    }

    public void SuccessMessageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        Assert.assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(successMessage)).isDisplayed());
    }
    public WebElement getFirstName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(firstname));
    }
    public WebElement getLastName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(lastname));
    }
    public WebElement getEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(email));
    }
    public WebElement getPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(password));
    }
    public void clickAgreeCheckbox() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(agree));
        WebElement element = driver.findElement(agree);
//        Actions action = new Actions(driver);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,250)", "");
//        int x = Integer.parseInt(element.getAttribute("offsetLeft"))+4;
//        int y = Integer.parseInt(element.getAttribute("offsetTop"))+4;
//        System.out.println(x);
//        System.out.println(y);
//        action.moveByOffset(x,y).click().build().perform(); still doesn't work looks like there are some problems with checkbox

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);


    }
    public WebElement getContinueBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
    }
}
