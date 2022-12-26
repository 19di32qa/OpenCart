package demoOpenCard.TestCases;

import demoOpenCard.PageObjects.Customer.Dashboard;
import demoOpenCard.PageObjects.Customer.TopBarForProducts;
import demoOpenCard.Tools.BaseClass;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TC12_TopNavBarLaptops extends BaseClass {

    @Test
    public void CheckLaptops() throws IOException {
        Dashboard dashboard = new Dashboard(driver);
        dashboard.getPage();

        TopBarForProducts topBarForProducts = new TopBarForProducts(driver);
        topBarForProducts.goToLaptopsPage();
        Assert.assertEquals("Laptops & Notebooks", driver.getTitle());
        String[] products = getData();
        checkPresenceOfProductOnThePage(products);
    }
    public String[] getData() throws IOException {
        File file = new File("C:\\Users\\Dima\\Desktop\\OpenCard\\src\\test\\java\\demoOpenCard\\TestData\\Products.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet");
        String[] products = new String[sheet.getLastRowNum()];
        int j =0;
        for (int i =1;i<= products.length;i++) {
            Row row = sheet.getRow(i);
            System.out.println(row.getCell(0));
            products[j] = row.getCell(0).getStringCellValue();
            j++;
        }
        return products;

    }
    public void checkPresenceOfProductOnThePage(String[] products) {
        String s = "//h4//*[text()=\"HP LP3065\"]";
        for (int i =0;i<products.length;i++) {
            //String product = products[i];
            By product = By.xpath("//h4//*[text()=\""+products[i]+"\"]");
            Assert.assertTrue(driver.findElement(product).isDisplayed());
        }
    }
}
