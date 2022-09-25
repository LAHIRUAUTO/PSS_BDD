package PSSTestRunner;


import PSS_Pages.PSS_Home_Page.AdminHomePageMethods;
import PSS_Pages.PSS_Login_Page.AdminLoginPageMethods;
import Utilities.Utils;
import com.sun.net.httpserver.Authenticator;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class PSSTestRunner extends Utils {

    String FilePath = "/home/user/Desktop/Udemy/Test/Test Data/PSStestdata.xls";
    FileInputStream fs = new FileInputStream(FilePath);
    Workbook wb = Workbook.getWorkbook(fs);
    Sheet PSSAdminLogginSh = wb.getSheet("PssAdminLoggin");

    public PSSTestRunner() throws IOException, BiffException {
    }
    @Parameters({"url", "browser"})
    @BeforeTest
    public void validateCurrentURL (String url, String browser){
        if (driver.getCurrentUrl().equals(url)){
            System.out.println("Correct URL hit on "+ browser);
        }
        else  {
            System.out.println("Incorrect URL hit on " + browser);
            driver.close();

        }
    }

    @Test (priority = 1, retryAnalyzer = Authenticator.Retry.class, description = "PSS Log in test case")
    public void LogInToThePSSAdmin (){
        String username = PSSAdminLogginSh.getCell("A2").getContents();
        String password = PSSAdminLogginSh.getCell("B2").getContents();

        AdminLoginPageMethods newadminloginpage = PageFactory.initElements(driver, AdminLoginPageMethods.class);
        newadminloginpage.enterUsername(username);
        newadminloginpage.enterPassword(password);
        newadminloginpage.clickLoginbutton();


    }

    @Test (dependsOnMethods = {"LogInToThePSSAdmin"}, priority = 2, retryAnalyzer = Authenticator.Retry.class, description = "PSS Log out test case")
    public void LogOutFromThePSSAdmin (){

        AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
        newadminhomepage.gotologgedInUserinfor();
        newadminhomepage.clickLogoutButton();


    }


}
