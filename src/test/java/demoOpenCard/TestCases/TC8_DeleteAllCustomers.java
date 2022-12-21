package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Admin.Customers;
import demoOpenCard.PageObjects.Admin.LoginPage;
import demoOpenCard.PageObjects.Admin.SideBar;
import demoOpenCard.Tools.BaseClass;
import demoOpenCard.Tools.DataBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TC8_DeleteAllCustomers extends BaseClass {
    // don't use this test i created it to reset customers
    @Test(priority = 1,enabled = false)
    public void deleteAllCustomers() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.BaseLogin();

        SideBar sideBar = new SideBar(driver);
        sideBar.openCustomersDropDown();

        sideBar.getCustomers().click();

        Customers customers = new Customers(driver);
        customers.selectAllCustomers();
        customers.getDeleteIcon().click();
        driver.switchTo().alert().accept();
    }
    @Test(priority = 2, enabled = false)
    public void CheckDataBase() throws SQLException {
        DataBase dataBase = new DataBase();
        String statement = "Select * from oc_customer";
        ResultSet resultSet = dataBase.executeStatement(statement);
        while (resultSet.next()) {
            Assert.assertEquals(resultSet.getString(1),null);
        }
    }
}
