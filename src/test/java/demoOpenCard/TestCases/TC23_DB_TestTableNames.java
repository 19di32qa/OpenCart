package demoOpenCard.TestCases;

import demoOpenCard.Tools.DataBase;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TC23_DB_TestTableNames extends DataBase {

    @Test
    public void testTables() throws IOException, SQLException {
        ArrayList<String>expectedArr = getNames();
        String query = "SHOW TABLES;";
        ResultSet resultSet = executeStatement(query);
        ArrayList<String> actualTables = getDataBaseTables(resultSet);
        Assert.assertEquals(expectedArr.stream().sorted().collect(Collectors.toList()),
                actualTables.stream().sorted().collect(Collectors.toList()));
    }
    public ArrayList<String> getDataBaseTables(ResultSet resultSet) throws SQLException {
        ArrayList<String> arr = new ArrayList<>();
        while (resultSet.next()) {
            arr.add(resultSet.getString("Tables_in_opencard"));
        }
        System.out.println(arr);
        return arr;
    }
    public ArrayList<String> getNames() throws IOException {
        File file = new File("C:\\Users\\Dima\\Desktop\\OpenCard\\src\\test\\java\\demoOpenCard\\TestData\\TABLES.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet");
        ArrayList<String> arr = new ArrayList<>();
        for (int i =1;i<=sheet.getLastRowNum();i++) {
            Row row = sheet.getRow(i);
            arr.add(row.getCell(0).getStringCellValue());
        }
        System.out.println(arr);
        return arr;

    }
}
