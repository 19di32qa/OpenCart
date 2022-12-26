package demoOpenCard.PageObjects.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product {
    WebDriver driver;
    public Product(WebDriver driver) {
        this.driver = driver;
    }
    private final By addToCartBtn = By.id("button-cart");
    public WebElement getAddBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addToCartBtn));
    }

}
