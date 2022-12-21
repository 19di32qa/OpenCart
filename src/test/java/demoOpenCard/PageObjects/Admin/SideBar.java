package demoOpenCard.PageObjects.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SideBar {
    WebDriver driver;
    public SideBar(WebDriver driver) {
        this.driver = driver;
    }
    private final By customersDropDown = By.cssSelector("#menu-customer a");
    private final By customers = By.xpath("//li[@id=\"menu-customer\"]//a[text()=\"Customers\"]");

    public void openCustomersDropDown() {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(customersDropDown)).click();
    }
    public WebElement getCustomers() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(customers));
    }
}
