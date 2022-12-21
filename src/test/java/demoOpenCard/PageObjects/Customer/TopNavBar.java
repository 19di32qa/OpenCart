package demoOpenCard.PageObjects.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopNavBar {
    WebDriver driver;
    public TopNavBar(WebDriver driver) {
        this.driver = driver;
    }
    private final By myAccount = By.xpath("//span[text()=\"My Account\"]");
    private final By registerOption = By.xpath("//*[text()=\"Register\"]");
    private final By loginOption = By.xpath("//div[@class = \"dropdown\"]//a[text() = \"Login\"]");
    private final By logOut = By.xpath("//div[@class=\"dropdown\"]//a[text()=\"Logout\"]");

    public WebElement getLogOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(logOut));
    }
    public void BaseLogOut() {
        getMyAccount().click();
        getLogOut().click();
        //driver.manage().deleteAllCookies();
    }

    public WebElement getMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(myAccount));
    }
    public WebElement getRegisterOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(registerOption));
    }
    public WebElement getLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(loginOption));
    }

}
