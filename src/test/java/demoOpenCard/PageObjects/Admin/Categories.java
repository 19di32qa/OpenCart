package demoOpenCard.PageObjects.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Categories {
    WebDriver driver;
    public Categories(WebDriver driver) {
        this.driver = driver;
    }
    private final By addNewBtn = By.xpath("//div[@class=\"float-end\"]//a[@class=\"btn btn-primary\"]");
    private final By seoLink = By.xpath("//a[text()=\"SEO\"]");
    private final By saveBtn = By.xpath("//button[@type=\"submit\"]");
    private final By successMessage = By.xpath("//div[@class = \"alert alert-success alert-dismissible\"]");
    private final By categories = By.xpath("//a[text()=\"Categories\"]");

    public WebElement getCategoriesLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(categories));
    }

    public WebElement getAddNewBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addNewBtn));
    }
    public WebElement getSEOLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(seoLink));
    }
    public WebElement getSaveBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn));
    }
    public WebElement getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(successMessage));
    }


}
