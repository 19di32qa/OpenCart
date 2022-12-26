package demoOpenCard.PageObjects.Admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerGroups {
    WebDriver driver;
    public CustomerGroups(WebDriver driver) {
        this.driver = driver;
    }
    private final By addNewBtn = By.xpath("//i[@class=\"fa-solid fa-plus\"]");
    private final By deleteBtn = By.xpath("//i[@class=\"fa-regular fa-trash-can\"]");
    public WebElement getAddNewBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(addNewBtn));
    }
    public WebElement getDeleteBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(deleteBtn));
    }
    public WebElement selectGroup(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//td[text()=\""+name+"\"]/parent::tr//input")));
    }
}
