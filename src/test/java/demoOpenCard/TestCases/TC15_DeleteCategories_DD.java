package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Admin.Categories;
import demoOpenCard.PageObjects.Admin.LoginPage;
import demoOpenCard.PageObjects.Admin.SideBar;
import demoOpenCard.Tools.BaseClass;
import demoOpenCard.Tools.ElementClickIntercepted;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class TC15_DeleteCategories_DD extends BaseClass {

    @Test
    public void deleteCategoriesTest() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.BaseLogin();

        SideBar sideBar = new SideBar(driver);
        sideBar.openCatalogDropDown();
        Thread.sleep(1000);
        sideBar.getCategories().click();
        String[] cats = getData();
        Categories categories = new Categories(driver);
        deleteCats(categories, cats);
        categories.getSuccessMessage();
    }
    public void deleteCats(Categories categories, String[] cats) {
        for (int i =0;i<cats.length;i++) {
            checkCategory(cats[i],categories);
        }
        deleteSelected();
        driver.switchTo().alert().accept();
    }

    public void deleteSelected() {
        By deleteBtn = By.xpath("//i[@class=\"fa-regular fa-trash-can\"]");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(deleteBtn));
        ElementClickIntercepted elementClickIntercepted = new ElementClickIntercepted();
        elementClickIntercepted.clickRecursively(element,5);
    }
    public void checkCategory(String name, Categories categories) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        ElementClickIntercepted elementClickIntercepted = new ElementClickIntercepted();
        By locator = By.xpath("//td[text()=\""+name+"\"]/parent::tr/td[@class=\"text-center\"]/input");
        try {
            WebElement element= wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            elementClickIntercepted.clickRecursively(element,5);
        }
        catch (Exception ex) {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
            By locator1 =By.xpath("//a[text()=\">\"]");
            try {
                WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(locator1));
                elementClickIntercepted.clickRecursively(element1,5);
                checkCategory(name,categories);
            }
            catch (Exception exception) {
                Assert.assertTrue(false);
            }
        }

    }
    public String[] getData() throws IOException {
        File file = new File("C:\\Users\\Dima\\Desktop\\OpenCard\\src\\test\\java\\demoOpenCard\\TestData\\Categories.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet");
        String[] data = new String[sheet.getLastRowNum()];
        int l =0;
        for (int i =1;i<= sheet.getLastRowNum();i++) {
            Row row = sheet.getRow(i);
            data[l] = row.getCell(0).getStringCellValue();
            l++;
        }
        return data;

    }
}
