package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Admin.LoginPage;
import demoOpenCard.PageObjects.Customer.CustomerLoginPage;
import demoOpenCard.PageObjects.Customer.Dashboard;
import demoOpenCard.PageObjects.Customer.TopNavBar;
import demoOpenCard.Tools.BaseClass;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TC2_Login_DD extends BaseClass {
    @Test(dataProvider = "logins")
    public void LoginDDTest(String email, String password) {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.getPage();

        TopNavBar topNavBar = new TopNavBar(driver);
        topNavBar.getMyAccount().click();
        topNavBar.getLoginPage().click();

        String validPassword = "12345678";
        String validEmail = "AlexiosGor+1@example.com";
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        if (email.equals(validEmail) && password.equals(validPassword)) {
            setEmail(email, customerLoginPage);
            setPassword(password, customerLoginPage);
            customerLoginPage.getLoginBtn().click();
            Assert.assertTrue(customerLoginPage.validLogin().isDisplayed());
        }
        else {
            setPassword(password, customerLoginPage);
            setEmail(email,customerLoginPage);
            customerLoginPage.getLoginBtn().click();
            Assert.assertTrue(customerLoginPage.getInvalidMessage().isDisplayed());
        }

    }
    public void setPassword(String password, CustomerLoginPage customerLoginPage) {
        WebElement element = customerLoginPage.getPassword();
        Actions action  = new Actions(driver);
        action.moveToElement(element).doubleClick().sendKeys(Keys.DELETE).build().perform();
        element.sendKeys(password);
    }
    public void setEmail(String email, CustomerLoginPage customerLoginPage) {
        WebElement element = customerLoginPage.getEmail();
        Actions action  = new Actions(driver);
        action.moveToElement(element).doubleClick().sendKeys(Keys.DELETE).build().perform();
        element.sendKeys(email);
    }
    @DataProvider(name = "logins")
    public Object[][] getLoginCredentials() throws IOException {
        File file = new File("C:\\Users\\Dima\\Desktop\\OpenCard\\src\\test\\java\\demoOpenCard\\TestData\\Login.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet");
        String[][] logins = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        int l =0;
        for (int i =1;i<=logins.length;i++) {
            Row row = sheet.getRow(i);
            for (int j =0;j<row.getLastCellNum();j++) {

                Cell cell = row.getCell(j);
                if (cell.getCellType() == CellType.STRING) {
                    String value;
                    value = cell.getStringCellValue();
                    logins[l][j] = value;
                }
                else {
                    int value = (int) Math.round(cell.getNumericCellValue());
                    logins[l][j] = String.valueOf(value);
                }
            }
            l++;
        }
        //System.out.println(logins);
        return logins;
    }
}
