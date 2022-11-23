package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@failure_cases.txt",
        glue = "stepDefinations",
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:reporting/cucumber.html",
                "json:reporting/cucumber.json"
        },
        monochrome = true,
        tags = ("@SmokeTest")

)
public class FailureReRunner extends AbstractTestNGCucumberTests {


}
