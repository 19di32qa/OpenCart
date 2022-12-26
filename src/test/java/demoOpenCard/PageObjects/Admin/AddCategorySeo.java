package demoOpenCard.PageObjects.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCategorySeo {
    WebDriver driver;
    public AddCategorySeo(WebDriver driver) {
        this.driver = driver;
    }
    private final By seo = By.name("category_seo_url[0][1]");

    public WebElement getSeoInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(seo));
    }
}
