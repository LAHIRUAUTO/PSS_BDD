package Utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestNGDataProvider extends Utils {
    String FilePath = "/home/user/Desktop/Udemy/Test/Test Data/PSStestdata.xls";
    FileInputStream fs = new FileInputStream(FilePath);
    Workbook wb = Workbook.getWorkbook(fs);
    Sheet DataFeed  = wb.getSheet("DataFeed");
    Sheet DataFeed2  = wb.getSheet("DataFeed2");

    Sheet PSSAdminLogginSh = wb.getSheet("PssAdminLoggin");
    Sheet PSSAdminHomaPageSh = wb.getSheet("PssAdminHomePage");

    public TestNGDataProvider() throws IOException, BiffException {


    }


    @org.testng.annotations.DataProvider (name="SearchProvider")
    public Object[][] getDataFromDataprovider (Method methodName) throws Exception {

        if (methodName.getName().equalsIgnoreCase("LogInToThePSSAdmin")) {

            return new Object[][] {
                    {PSSAdminLogginSh.getCell("A2").getContents(),PSSAdminLogginSh.getCell("B2").getContents()}
            };

        } else if (methodName.getName().equalsIgnoreCase("SearchForRoles")) {
            return new Object[][] {
                    {PSSAdminHomaPageSh.getCell("A2").getContents()}

            };

        } else if (methodName.getName().equalsIgnoreCase("SearchForAirports")) {
            return new Object[][] {
                    {PSSAdminHomaPageSh.getCell("A3").getContents()}

            };
        } else {
            throw new Exception("Incorrect Method name identified");
        }



    }





}
