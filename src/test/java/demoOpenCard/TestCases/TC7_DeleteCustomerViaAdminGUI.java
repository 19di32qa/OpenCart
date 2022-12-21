package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Admin.LoginPage;
import demoOpenCard.PageObjects.Admin.SideBar;
import demoOpenCard.Tools.BaseClass;
import demoOpenCard.Tools.DataBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TC7_DeleteCustomerViaAdminGUI extends BaseClass {

    @Test
    public void deleteCustomer() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.BaseLogin();
        SideBar sideBar = new SideBar(driver);
        sideBar.openCustomersDropDown();
        Thread.sleep(1000);
        sideBar.getCustomers().click();
        String customers[] = {"customer1@example.com","customer2@example.com","customer3@example.com"};
        for (int i =0;i<customers.length;i++) {
            selectCustomer(customers[i]);
        }
        deleteSelectedCustomers();

    }
    public void deleteSelectedCustomers() {
        driver.findElement(By.xpath("//i[@class=\"fa-regular fa-trash-can\"]")).click();
        driver.switchTo().alert().accept();
    }

    public void selectCustomer(String customer) {
        driver.findElement(By.xpath("//*[text()=\""+customer+"\"]/parent::tr//td[@class=\"text-center\"]/input")).click();
    }
    @Test
    public void CheckDataBase() throws SQLException {
        DataBase dataBase = new DataBase();
        String customers[] = {"customer1@example.com","customer2@example.com","customer3@example.com"};
        for (int i =0;i<customers.length;i++) {
            ResultSet resultSet = dataBase.executeStatement("Select * from oc_customer where " +
                    "email=\""+customers[i]+"\"");
            checkResultSet(resultSet);
        }
    }

    public void checkResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            Assert.assertEquals(resultSet.getString("email"),null);
        }
    }

}
