package demoOpenCard.PageObjects.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerGroupCreationPage {
    WebDriver driver;
    public CustomerGroupCreationPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By customerGroupName = By.id("input-name-1");
    private final By saveBtn = By.xpath("//i[@class=\"fa-solid fa-floppy-disk\"]");

    public void setCustomerGroupName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(customerGroupName)).sendKeys(name);
    }
    public void saveGroup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(saveBtn)).click();
    }
}
