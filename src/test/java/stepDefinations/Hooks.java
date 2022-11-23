package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.GenericUtils;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks{

    TestContextSetup testContextSetup;

    public Hooks (TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;

    }

    @Before
    public void beforeScenario() throws Exception {


    }



    @After
    public void afterScenario() throws Exception {
        testContextSetup.testBase.webDriverManager().quit();
        System.out.println("Extent report is emailing.... !!! do not interrupt !!!");
        testContextSetup.genericUtils.sleeping(10000);
        GenericUtils.endSuiteBDD("100", "IBE", "dcs.selenium.report@gmail.com", "lmsbruovggrocqxk", "vikasithasouth@gmail.com");
        testContextSetup.genericUtils.sleeping(10000);
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws Exception {
        testContextSetup.genericUtils.addScreenshot(scenario);
    }
}
