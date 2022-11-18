package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinations",
        plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"  },
        monochrome = true,
        stepNotifications = true,
        tags = ("@SmokeTest")

)
public class BDDTestRunner {

}
