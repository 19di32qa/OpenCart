package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Admin.AdminDashboard;
import demoOpenCard.PageObjects.Admin.LoginPage;
import demoOpenCard.Tools.BaseClass;
import demoOpenCard.Tools.SnapShot;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TC3_AdminLogin extends BaseClass {
    // There is a bug , the system doesn't see difference between admin and Admin , the system is case-insensitive
    @Test(dataProvider = "logins")
    public void loginAsAdmin(String userName, String password) throws Exception {
        String screensPath = "C:\\Users\\Dima\\Desktop\\OpenCard\\src\\test\\java\\demoOpenCard\\Screens\\test.png";
        SnapShot snapShot = new SnapShot();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getPage();
        String validUserName = "admin";
        String validPassword = "12345678";
        if (userName.equals(validUserName) && password.equals(validPassword)) {
            loginPage.setPassword(password);
            loginPage.setUsername(userName);
            loginPage.Login();
            AdminDashboard adminDashboard = new AdminDashboard(driver);
            Thread.sleep(1000);
            Assert.assertTrue(adminDashboard.getTitle().equals("Dashboard"));

        }
        else {
            loginPage.setPassword(password);
            loginPage.setUsername(userName);
            loginPage.Login();
            Assert.assertTrue(loginPage.getInvalidMessage().isDisplayed());
        }
    }
    @DataProvider(name = "logins")
    public Object[][] getAdminCredentials() throws IOException {
        File file = new File("C:\\Users\\Dima\\Desktop\\OpenCard\\src\\test\\java\\demoOpenCard\\TestData\\adminLogin.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet");
        String logins[][] = new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        int l =0;
        for (int i =1;i<=logins.length;i++) {
            Row row = sheet.getRow(i);
            for (int j =0;j<row.getLastCellNum();j++) {
                Cell cell = row.getCell(j);
                if (cell.getCellType() == CellType.STRING) {
                    logins[l][j] = cell.getStringCellValue();
                }
                else {
                    int value = (int) Math.round(cell.getNumericCellValue());
                    logins[l][j] = String.valueOf(value);
                }
            }
            l++;
        }
        return logins;
    }
}
