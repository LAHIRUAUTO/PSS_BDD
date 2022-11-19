package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinations",
        plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"  },
        monochrome = true,
        tags = ("@SmokeTest")

)
public class BDDTestRunner extends AbstractTestNGCucumberTests {

}
