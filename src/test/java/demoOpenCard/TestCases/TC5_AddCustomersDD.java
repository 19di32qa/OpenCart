package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Admin.CustomerCreationPage;
import demoOpenCard.PageObjects.Admin.Customers;
import demoOpenCard.PageObjects.Admin.LoginPage;
import demoOpenCard.PageObjects.Admin.SideBar;
import demoOpenCard.PageObjects.Customer.CustomerLoginPage;
import demoOpenCard.PageObjects.Customer.Dashboard;
import demoOpenCard.PageObjects.Customer.TopNavBar;
import demoOpenCard.Tools.BaseClass;
import demoOpenCard.Tools.GetDataFromExcel;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC5_AddCustomersDD extends BaseClass {
    @Test(dataProvider = "customers")
    public void AddCustomers(String firstName, String lastName, String password, String confirm, String email,
                             String phone, String newsLetter) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.BaseLogin();
        SideBar sideBar = new SideBar(driver);
        sideBar.openCustomersDropDown();
        Thread.sleep(1000);
        sideBar.getCustomers().click();
        Customers customers = new Customers(driver);
        customers.getAddNewCustomer().click();
        CustomerCreationPage customerCreationPage = new CustomerCreationPage(driver);
        customerCreationPage.getFirstNameInput().sendKeys(firstName);
        customerCreationPage.getLastNameInput().sendKeys(lastName);
        customerCreationPage.getEmailInput().sendKeys(email);
        customerCreationPage.getPasswordInput().sendKeys(password);
        customerCreationPage.getConfirmInput().sendKeys(confirm);
        if(!phone.equals("no")) {
            customerCreationPage.getTelephone().sendKeys(phone);
        }
        if (newsLetter.equals("Yes")) {
            clickRecursively(customerCreationPage.getNewsLetter());
        }
        clickRecursively(customerCreationPage.getSaveBtn());
        customerCreationPage.getSuccessMessage();
        LoginAsCreatedCustomer(email,password);
    }
    public void LoginAsCreatedCustomer(String email, String password) {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.getPage();

        TopNavBar topNavBar = new TopNavBar(driver);
        topNavBar.getMyAccount().click();
        topNavBar.getLoginPage().click();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.getPassword().sendKeys(password);
        customerLoginPage.getEmail().sendKeys(email);
        customerLoginPage.getLoginBtn().click();
        customerLoginPage.validLogin();
        topNavBar.BaseLogOut();
        //driver.manage().deleteAllCookies();
    }

    public void CheckDataBaseForCreatedCustomers() {

    }
    @DataProvider(name = "customers")
    public Object[][] getCustomers() throws IOException {
        String path = "C:\\Users\\Dima\\Desktop\\OpenCard\\src\\test\\java\\demoOpenCard\\TestData\\Customers.xlsx";
        String sheet = "Sheet";
        GetDataFromExcel getDataFromExcel = new GetDataFromExcel(path,sheet);
        Object[][] customers = getDataFromExcel.getData();
        return customers;
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
}
