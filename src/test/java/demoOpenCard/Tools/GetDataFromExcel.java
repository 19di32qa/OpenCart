package demoOpenCard.Tools;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GetDataFromExcel {
    String path = "";
    String sheet = "";
    public GetDataFromExcel(String path, String sheet) {
        this.path = path;
        this.sheet = sheet;
    }

    public Object[][] getData() throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(this.sheet);
        Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        int l =0;
        for (int i =1;i<=data.length;i++) {
            Row row = sheet.getRow(i);
            for (int j =0;j<row.getLastCellNum();j++) {
                Cell cell = row.getCell(j);
                if (cell.getCellType() == CellType.STRING) {
                    String value = cell.getStringCellValue();
                    data[l][j] = value;
                }
                else {
                    int value = (int) Math.round(cell.getNumericCellValue());
                    data[l][j] = value;
                }
            }
            l++;
        }
        return data;
    }
}
