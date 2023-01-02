package demoOpenCard.PageObjects.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AllLaptopPage {
    WebDriver driver;
    public AllLaptopPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddToComparePage(String name) {
        By locator = By.xpath("//*[text()=\""+name+"\"]/ancestor::div[@class=\"content\"]//i[@class=\"fa-solid fa-arrow-right-arrow-left\"]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public WebElement SuccessMessage() {
        By locator = By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
