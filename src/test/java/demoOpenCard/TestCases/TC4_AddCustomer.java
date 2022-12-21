package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Admin.CustomerCreationPage;
import demoOpenCard.PageObjects.Admin.Customers;
import demoOpenCard.PageObjects.Admin.LoginPage;
import demoOpenCard.PageObjects.Admin.SideBar;
import demoOpenCard.Tools.BaseClass;
import org.testng.annotations.Test;

public class TC4_AddCustomer extends BaseClass {
    @Test
    public void AddCustomerViaAdministrator() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.BaseLogin();
        SideBar sideBar = new SideBar(driver);
        sideBar.openCustomersDropDown();
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

}
