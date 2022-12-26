package demoOpenCard.PageObjects.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Featured {
    WebDriver driver;
    public Featured(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getElement(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\""+name+"\"]/ancestor::form")));
    }
}
