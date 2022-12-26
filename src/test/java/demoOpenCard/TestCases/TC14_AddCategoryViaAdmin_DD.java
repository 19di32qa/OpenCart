package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Admin.*;
import demoOpenCard.Tools.BaseClass;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TC14_AddCategoryViaAdmin_DD extends BaseClass {

    @Test
    public void addCategoryTest() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.BaseLogin();

        SideBar sideBar = new SideBar(driver);
        sideBar.openCatalogDropDown();
        Thread.sleep(1000);
        sideBar.getCategories().click();

        Categories categories = new Categories(driver);
        Object[][] cats = getData();
        createCategory(categories, cats);

    }


    public Object[][] getData() throws IOException {
        File file = new File("C:\\Users\\Dima\\Desktop\\OpenCard\\src\\test\\java\\demoOpenCard\\TestData\\Categories.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet");
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        int l =0;
        for (int i =1;i<= sheet.getLastRowNum();i++) {
            Row row = sheet.getRow(i);
            for (int j =0;j<row.getLastCellNum();j++) {
                data[l][j] = row.getCell(j).getStringCellValue();
            }
            l++;
        }
        return data;

    }

    public void createCategory(Categories categories, Object[][] cats) {
        for (int i =0;i< cats.length;i++) {
            categories.getAddNewBtn().click();
            AddCategoryGeneral ad = new AddCategoryGeneral(driver);
            ad.getInputName().sendKeys((String) cats[i][0]);
            ad.getMetaTag().sendKeys((String) cats[i][1]);
            categories.getSEOLink().click();
            AddCategorySeo addCategorySeo = new AddCategorySeo(driver);
            addCategorySeo.getSeoInput().sendKeys((String) cats[i][2]);
            categories.getSaveBtn().click();
            WebElement element = categories.getSuccessMessage();
            Assert.assertTrue(element.isDisplayed());
            categories.getCategoriesLink().click();
        }

    }

}
