package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Admin.Customers;
import demoOpenCard.PageObjects.Admin.LoginPage;
import demoOpenCard.PageObjects.Admin.SideBar;
import demoOpenCard.PageObjects.Customer.Dashboard;
import demoOpenCard.PageObjects.Customer.RegisterAccount;
import demoOpenCard.PageObjects.Customer.TopNavBar;
import demoOpenCard.Tools.BaseClass;
import demoOpenCard.Tools.DataBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TC1_Register extends BaseClass {
    @Test(priority = 1)
    public void registerTest() throws InterruptedException {
        Dashboard dashboard = new Dashboard(driver);
        getPage(dashboard.url);
        TopNavBar topNavBar = new TopNavBar(driver);
        topNavBar.getMyAccount().click();
        topNavBar.getRegisterOption().click();
        setCustomer("Alex","Gordon","AlexiosGor+1@example.com","12345678");
    }
    public void setCustomer(String name, String lastName, String email, String password) throws InterruptedException {
        RegisterAccount registerAccount = new RegisterAccount(driver);
        registerAccount.getFirstName().sendKeys(name);
        registerAccount.getLastName().sendKeys(lastName);
        registerAccount.getEmail().sendKeys(email);
        registerAccount.getPassword().sendKeys(password);
        registerAccount.clickAgreeCheckbox();
        registerAccount.getContinueBtn().submit();
        Thread.sleep(1000);
        registerAccount.SuccessMessageIsDisplayed();
    }

    @Test (priority = 2)
    public void checkDataBase() throws SQLException {
        String string = "SELECT * FROM oc_customer where firstname = \"Alex\"";
        DataBase dataBase = new DataBase();
        ResultSet resultSet = dataBase.executeStatement(string);
        while (resultSet.next()) {
            Assert.assertEquals(resultSet.getString("firstname"),"Alex");
        }

    }
    @Test(priority = 3)
    public void checkAdminPage() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.getPage();
        lp.setUsername("admin");
        lp.setPassword("12345678");
        lp.Login();

        SideBar sideBar = new SideBar(driver);
        sideBar.openCustomersDropDown();
        sideBar.getCustomers().click();

        Customers customers = new Customers(driver);
        customers.setFilter_name("Alex Gordon");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,250)", "");
        clickRecursively(customers.filter());
        checkCustomer("Alex Gordon","AlexiosGor+1@example.com","Enabled");

    }
    public void clickRecursively(WebElement element) {
        try
        {
            element.click();
        }
        catch (Exception InvalidOperationException)
        {
            clickRecursively(element);
        }

    }

    public void checkCustomer(String name,String email,String status) {
        String customerName = driver.findElement(By.xpath("//td[text()=\""+name+"\"]")).getText();
        System.out.println(customerName);
        String customerEmail = driver.findElement(By.xpath("//td[text()=\""+email+"\"]")).getText();
        String customerStatus = driver.findElement(By.xpath("//td[text()=\""+status+"\"]")).getText();
        Assert.assertEquals(customerName, name);
        Assert.assertEquals(customerEmail, email);
        Assert.assertEquals(customerStatus, status);
    }


}
