package demoOpenCard.PageObjects.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductComparison {
    private final String url = "http://localhost/demoOpenCard/upload/index.php?route=product/compare&language=en-gb";
    WebDriver driver;
    public ProductComparison(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.navigate().to(url);
    }
    public void elementIsDisplayed(String name) {
        By locator = By.xpath("//*[text()=\""+name+"\"]/ancestor::div[@id=\"content\"]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Assert.assertTrue(element.isDisplayed());
    }

}
