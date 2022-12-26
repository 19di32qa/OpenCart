package demoOpenCard.PageObjects.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopBarForProducts {
    WebDriver driver;
    public TopBarForProducts(WebDriver driver) {
        this.driver = driver;
    }
    private final By laptopAndNotebooks = By.xpath("//li//a[text()=\"Laptops & Notebooks\"]");
    private final By AllLaptops = By.xpath("//a[text()=\"Show All Laptops & Notebooks\"]");

    public void goToLaptopsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(laptopAndNotebooks)).click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.presenceOfElementLocated(AllLaptops)).click();
    }
}
