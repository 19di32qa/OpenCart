package demoOpenCard.PageObjects.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Customers {
    public WebDriver driver;
    public Customers(WebDriver driver) {
        this.driver = driver;
    }
    private final By filter_name = By.name("filter_name");
    private final By filterBTN = By.xpath("//button[@id=\"button-filter\"]");
    private final By addNewBtn = By.xpath("//div[@class=\"float-end\"]//a[@class=\"btn btn-primary\"]");
    private final By selectAll = By.xpath("//td//*[text()=\"Customer Name\"]/ancestor::tr//input");
    private final By deleteBtn = By.xpath("//i[@class=\"fa-regular fa-trash-can\"]");

    public WebElement getDeleteIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteBtn));
    }

    public void selectAllCustomers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(selectAll)).click();
    }

    public WebElement getAddNewCustomer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addNewBtn));
    }

    public WebElement filter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(filterBTN));
    }
    public void setFilter_name(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(filter_name)).sendKeys(name);
    }


}
