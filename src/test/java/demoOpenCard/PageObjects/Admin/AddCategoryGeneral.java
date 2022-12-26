package demoOpenCard.PageObjects.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCategoryGeneral {
    WebDriver driver;
    public AddCategoryGeneral(WebDriver driver) {
        this.driver = driver;
    }
    private final By inputName = By.name("category_description[1][name]");
    private final By metaTag = By.name("category_description[1][meta_title]");


    public WebElement getInputName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(inputName));
    }
    public WebElement getMetaTag() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(metaTag));
    }
}
