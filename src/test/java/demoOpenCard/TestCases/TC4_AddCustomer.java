package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Admin.CustomerCreationPage;
import demoOpenCard.PageObjects.Admin.Customers;
import demoOpenCard.PageObjects.Admin.LoginPage;
import demoOpenCard.PageObjects.Admin.SideBar;
import demoOpenCard.PageObjects.Customer.CustomerLoginPage;
import demoOpenCard.PageObjects.Customer.Dashboard;
import demoOpenCard.PageObjects.Customer.TopNavBar;
import demoOpenCard.Tools.BaseClass;
import org.testng.annotations.Test;

public class TC4_AddCustomer extends BaseClass {
    @Test(priority = 1)
    public void AddCustomerViaAdministrator() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.BaseLogin();
        SideBar sideBar = new SideBar(driver);
        sideBar.openCustomersDropDown();
        Thread.sleep(1000);
        sideBar.getCustomers().click();
        Customers customers = new Customers(driver);
        customers.getAddNewCustomer().click();

        CustomerCreationPage customerCreationPage = new CustomerCreationPage(driver);
        customerCreationPage.getFirstNameInput().sendKeys("John");
        customerCreationPage.getLastNameInput().sendKeys("Snow");
        customerCreationPage.getEmailInput().sendKeys("JohnSnow+1@example.com");
        customerCreationPage.getPasswordInput().sendKeys("12345678");
        customerCreationPage.getConfirmInput().sendKeys("12345678");
        customerCreationPage.getSaveBtn().click();
        customerCreationPage.getSuccessMessage();

    }
    @Test(priority = 2)
    public void loginAsNewCustomer() {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.getPage();

        TopNavBar topNavBar = new TopNavBar(driver);
        topNavBar.getMyAccount().click();
        topNavBar.getLoginPage().click();
        String email = "JohnSnow+1@example.com";
        String password = "12345678";
        CustomerLoginPage loginPage = new CustomerLoginPage(driver);
        loginPage.getEmail().sendKeys(email);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLoginBtn().click();
        loginPage.validLogin();
    }

}
