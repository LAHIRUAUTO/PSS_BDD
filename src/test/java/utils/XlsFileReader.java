package utils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;

public class XlsFileReader {


    public String getCellData (String  sheetName, String cellID) throws IOException, BiffException {
        String FilePath = System.getProperty("user.dir") + "/Test Data/Testdata.xls";
        FileInputStream fs = new FileInputStream(FilePath);
        Workbook wb = Workbook.getWorkbook(fs);
        Sheet dataSheet = wb.getSheet(sheetName);
        return dataSheet.getCell(cellID).getContents();
    }
}
