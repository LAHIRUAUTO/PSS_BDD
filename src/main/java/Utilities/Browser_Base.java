package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
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

                WebDriverManager.chromedriver().setup();
                ChromeOptions option = new ChromeOptions();
                String chromeProfilePath = "/home/user/.config/google-chrome/Default";
                option.addArguments("chrome.switches", "--disable-extensions");
                option.addArguments("user-data-dir=" + chromeProfilePath);
                option.addArguments("--start-maximized");
                driver = new ChromeDriver(option);
                driver.get(url);
                driver.manage().window().maximize();

    }

    @AfterTest
    public static void close() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
