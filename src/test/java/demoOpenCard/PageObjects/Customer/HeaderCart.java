package demoOpenCard.PageObjects.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderCart {
    WebDriver driver;
    public HeaderCart(WebDriver driver) {
        this.driver = driver;
    }
    public void openHeadCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//div[@id=\"header-cart\"]//button"))).click();
    }
    public void clickCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right show\"]//i[@class=\"fa-solid fa-share\"]"))).click();
    }
}
