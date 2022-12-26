package demoOpenCard.PageObjects.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WriteAReview {
    WebDriver driver;
    public WriteAReview(WebDriver driver) {
        this.driver = driver;
    }
    private final By text = By.id("input-text");
    private final By rating = By.xpath("//input[@type=\"radio\"]");
    private final By saveReviewBtn = By.id("button-review");

    public void setText(String text1) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(text)).sendKeys(text1);
    }
    public List<WebElement> getRating() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(rating));
    }
    public WebElement saveReview() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(saveReviewBtn));
    }
}
