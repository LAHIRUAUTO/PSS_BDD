package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import stepDefinations.IBEHomePageSteps;

public class TestBase {


    public WebDriver driver;
    public TestBase () {

    }


    public WebDriver webDriverManager () throws Exception {


        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            String chromeProfilePath = "/home/user/.config/google-chrome/Default";
            option.addArguments("chrome.switches", "--disable-extensions");
            option.addArguments("user-data-dir=" + chromeProfilePath);
            option.addArguments("--start-maximized");
            driver = new ChromeDriver(option);
            driver.get(FileReaderManager.getInstance().getConfigReader().getUrl());
            driver.manage().window().maximize();

    }

        return driver;

    }
}
