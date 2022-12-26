package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Admin.*;
import demoOpenCard.Tools.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC10_AdminAddCustomerGroup extends BaseClass {
    @Test
    public void addCustomerGroupTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.BaseLogin();

        SideBar sideBar = new SideBar(driver);
        sideBar.openCustomersDropDown();
        Thread.sleep(1000);
        sideBar.getCustomerGroups().click();
        CustomerGroups customerGroups = new CustomerGroups(driver);
        customerGroups.getAddNewBtn().click();

        CustomerGroupCreationPage groupCreationPage = new CustomerGroupCreationPage(driver);
        groupCreationPage.setCustomerGroupName("test group");
        groupCreationPage.saveGroup();
        successMessage();
    }
    public void successMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")));
        Assert.assertTrue(element.isDisplayed());

    }
}
