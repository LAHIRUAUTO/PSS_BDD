package Utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Browser_Base {
    public static WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeTest
    public static void Intialize(String browser, String url) throws Exception {

        //Load Property File
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"/App.properties");
        Properties obj = new Properties();
        obj.load(objfile);

        if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/Drivers/chromedriver_linux64/chromedriver"));
            //create chrome instance
            driver = new ChromeDriver();


        }
        else if (browser.equalsIgnoreCase("firefox")){
            //set path to firefoxdriver
            System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir")+"/Drivers/geckodriver-v0.31.0-linux64/geckodriver"));
            //create chrome instance
            driver = new FirefoxDriver();
        }

        else if (browser.equalsIgnoreCase("edge")){
            //set path to edgedriver
            System.setProperty("webdriver.edge.driver", (System.getProperty("user.dir")+"/Drivers/edgedriver_linux64/msedgedriver"));
            //create chrome instance
            driver = new EdgeDriver();
        }

        else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }

        driver.get(url);
        driver.manage().window().maximize();


    }

    @AfterTest
    public static void close() {

        driver.close();
    }
}
