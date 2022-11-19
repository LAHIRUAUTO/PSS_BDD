package stepDefinations;

import Utilities.Browser_Base;
import Utilities.Utils;
import Utilities.ZipUtilsBDD;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;

import static Utilities.Browser_Base.driver;

public class Hooks extends Utils{

    @Before
    public void beforeScenario() throws Exception {
        Browser_Base.Intialize("chrome", "https://www.ryanair.com/ie/en");
    }

    @After
    public void afterScenario() throws InterruptedException {
        System.out.println("Extent report is emailing.... !!! do not interrupt !!!");
        sleeping(30000);
        Utils.endSuiteBDD("100", "IBE", "dcs.selenium.report@gmail.com", "lmsbruovggrocqxk", "vikasithasouth@gmail.com");
        driver.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", "screenshot");



    }
}
