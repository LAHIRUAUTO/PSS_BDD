package Utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestNGDataProvider extends Utils {
    String FilePath = System.getProperty("user.dir") + "/Test Data/testdata.xls";
    FileInputStream fs = new FileInputStream(FilePath);
    Workbook wb = Workbook.getWorkbook(fs);
    Sheet createBooking2ADT1CHD = wb.getSheet("createBooking2ADT1CHD");
    public TestNGDataProvider() throws IOException, BiffException {


    }


    @org.testng.annotations.DataProvider (name="SearchProvider")
    public Object[][] getDataFromDataprovider (Method methodName) throws Exception {

        if (methodName.getName().equalsIgnoreCase("createBooking2ADT1CHD")) {

            return new Object[][] {

                    {
                            createBooking2ADT1CHD.getCell("C3").getContents(),
                            createBooking2ADT1CHD.getCell("C4").getContents(),
                            createBooking2ADT1CHD.getCell("C5").getContents(),
                            createBooking2ADT1CHD.getCell("C6").getContents(),
                            createBooking2ADT1CHD.getCell("C7").getContents(),
                            createBooking2ADT1CHD.getCell("C8").getContents(),
                            createBooking2ADT1CHD.getCell("C9").getContents(),
                            createBooking2ADT1CHD.getCell("C10").getContents(),
                            createBooking2ADT1CHD.getCell("C11").getContents(),
                            createBooking2ADT1CHD.getCell("C12").getContents(),
                            createBooking2ADT1CHD.getCell("C13").getContents(),
                            createBooking2ADT1CHD.getCell("C14").getContents(),
                            createBooking2ADT1CHD.getCell("C15").getContents(),
                            createBooking2ADT1CHD.getCell("C16").getContents(),
                            createBooking2ADT1CHD.getCell("C17").getContents(),
                            createBooking2ADT1CHD.getCell("C18").getContents(),
                            createBooking2ADT1CHD.getCell("C19").getContents(),

                    },

            };

        }  else {
            throw new Exception("Incorrect Test case name identified");
        }



    }





}
