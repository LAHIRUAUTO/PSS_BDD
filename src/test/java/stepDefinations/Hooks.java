package stepDefinations;

import Base.Browser_Base;
import Utilities.Utils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks extends Utils{

    @Before
    public void beforeScenario() throws Exception {
        String browser = getPropertyValue("browser");
        String url = getPropertyValue("url");
        Browser_Base.Intialize(browser, url);
    }

    @After
    public void afterScenario() throws InterruptedException {
        driver.quit();
        System.out.println("Extent report is emailing.... !!! do not interrupt !!!");
        sleeping(30000);
        Utils.endSuiteBDD("100", "IBE", "dcs.selenium.report@gmail.com", "lmsbruovggrocqxk", "vikasithasouth@gmail.com");

    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", "screenshot");



    }
}
