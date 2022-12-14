package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinations",
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:failure_cases.txt",
                "html:reporting/cucumber.html",
                "json:reporting/cucumber.json"
        },
        monochrome = true,
        dryRun = false,
        tags = ("@SmokeTest")
)

public class TestRunner extends AbstractTestNGCucumberTests {


}
