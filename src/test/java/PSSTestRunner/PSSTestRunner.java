package PSSTestRunner;


import PSS_Pages.PSS_Geography_Page.AdminGeographyPageMethods;
import PSS_Pages.PSS_Home_Page.AdminHomePageMethods;
import PSS_Pages.PSS_Login_Page.AdminLoginPageMethods;
import PSS_Pages.PSS_Security_Page.AdminSecurityPageMethods;
import Utilities.TestNGDataProvider;
import Utilities.Utils;
import com.sun.net.httpserver.Authenticator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PSSTestRunner extends Utils {

    @Parameters({"url", "browser"})
    @BeforeTest
    public void validateCurrentURL (String url, String browser){

        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(url), "Incorrect URL");
    }

    @Parameters({"title"})
    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class)
    public void logInToThePSSAdmin(String username, String password){

        AdminLoginPageMethods newadminloginpage = PageFactory.initElements(driver, AdminLoginPageMethods.class);
        AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
        newadminloginpage.enterUsername(username);
        newadminloginpage.enterPassword(password);
        newadminloginpage.clickLoginbutton();
        newadminhomepage.mouseHoweDashBooard();
        driver.navigate().refresh();

    }


    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class, dependsOnMethods = {"logInToThePSSAdmin"})
    public void searchForRoles(String rolename) throws InterruptedException {

        AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
        AdminSecurityPageMethods newadminrolepage = PageFactory.initElements(driver, AdminSecurityPageMethods.class);
        newadminhomepage.clickToogleMenu();
        newadminhomepage.mouseHoweMaintenance();
        newadminhomepage.mouseHoweSecurity();
        newadminhomepage.clickrole();
        newadminhomepage.swithToIframe();
        newadminrolepage.enterRoleName(rolename);
        newadminrolepage.clickRoleSearchButton();
        newadminrolepage.clickRoleName();
        newadminhomepage.swithToDefault();
        checkTheNotificationMessage();
        driver.navigate().refresh();


    }

    @Test (dependsOnMethods = {"logInToThePSSAdmin"})
    public void searchForFunctionalUsage() throws InterruptedException {

        AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
        AdminSecurityPageMethods newadminsecuritypage = PageFactory.initElements(driver, AdminSecurityPageMethods.class);
        newadminhomepage.clickToogleMenu();
        newadminhomepage.mouseHoweMaintenance();
        newadminhomepage.mouseHoweSecurity();
        newadminhomepage.clickFunctionUsage();
        newadminhomepage.swithToIframe();
        newadminsecuritypage.clickUnAssignedFunctionRadioButton();
        newadminsecuritypage.clickFunctionalSearchButton();
        newadminhomepage.swithToDefault();
        checkTheNotificationMessage();
        driver.navigate().refresh();


    }

    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class, dependsOnMethods = {"logInToThePSSAdmin"})
    public void searchForAirports(String airportCode) throws InterruptedException {

        AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
        AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
        newadminhomepage.clickToogleMenu();
        newadminhomepage.mouseHoweMaintenance();
        newadminhomepage.mouseHoweGeography();
        newadminhomepage.clickAirport();
        newadminhomepage.swithToIframe();
        newadmingeographypage.clickAirportCodeFieldLocator(airportCode);
        newadmingeographypage.clickAirportSearchButtonLocator();
        newadmingeographypage.clickAirportLocator();
        newadminhomepage.swithToDefault();
        checkTheNotificationMessage();
        driver.navigate().refresh();


    }

    @Test ( dependsOnMethods = {"logInToThePSSAdmin"})
    public void addAirports () throws InterruptedException {

        AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
        AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
        newadminhomepage.clickToogleMenu();
        newadminhomepage.mouseHoweMaintenance();
        newadminhomepage.mouseHoweGeography();
        newadminhomepage.clickAirport();
        newadminhomepage.swithToIframe();
        newadmingeographypage.clickAddAirportDSTButtonLocator();
        newadminhomepage.swithToDefault();
        checkTheNotificationMessage();
        driver.navigate().refresh();


    }

    @Test (dependsOnMethods = {"logInToThePSSAdmin"})
    public void searchForAirportsDST() throws InterruptedException {

        AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
        AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
        newadminhomepage.clickToogleMenu();
        newadminhomepage.mouseHoweMaintenance();
        newadminhomepage.mouseHoweGeography();
        newadminhomepage.clickAirportDST();
        newadminhomepage.swithToIframe();
        newadmingeographypage.clickAirportDSTSearchButtonLocator();
        newadminhomepage.swithToDefault();
        checkTheNotificationMessage();
        driver.navigate().refresh();


    }

    @Test (dependsOnMethods = {"logInToThePSSAdmin"})
    public void addAirportsDST () throws InterruptedException {

        AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
        AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
        newadminhomepage.clickToogleMenu();
        newadminhomepage.mouseHoweMaintenance();
        newadminhomepage.mouseHoweGeography();
        newadminhomepage.clickAirportDST();
        newadminhomepage.swithToIframe();
        newadmingeographypage.clickAirportDSTSearchButtonLocator();
        newadminhomepage.swithToDefault();
        checkTheNotificationMessage();
        driver.navigate().refresh();


    }

    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class, dependsOnMethods = {"logInToThePSSAdmin"})
    public void searchForCity(String countryName) throws InterruptedException {

        AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
        AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
        newadminhomepage.clickToogleMenu();
        newadminhomepage.mouseHoweMaintenance();
        newadminhomepage.mouseHoweGeography();
        newadminhomepage.clickCity  ();
        newadminhomepage.swithToIframe();
        newadmingeographypage.selectcountry(countryName);
        newadmingeographypage.clickCitySearchButtonLocator();
        newadmingeographypage.clickCityLocator();
        newadminhomepage.swithToDefault();
        checkTheNotificationMessage();
        driver.navigate().refresh();


    }

    @Test (dependsOnMethods = {"logInToThePSSAdmin"}, retryAnalyzer = Authenticator.Retry.class, description = "PSS Log out test case")
    public void logOutFromThePSSAdmin(){

        AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
        newadminhomepage.gotologgedInUserinfor();
        newadminhomepage.clickLogoutButton();


    }




}
