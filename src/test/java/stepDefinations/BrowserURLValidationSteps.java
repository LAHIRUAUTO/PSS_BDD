package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.FileReaderManager;
import utils.TestContextSetup;

public class BrowserURLValidationSteps {

    TestContextSetup testContextSetup;

    public BrowserURLValidationSteps(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("^Validate the browser$")
    public void validate_the_browser() throws Throwable {

        System.out.println("Browser :" + FileReaderManager.getInstance().getConfigReader().getBrowser());
        assert "chrome".equals(FileReaderManager.getInstance().getConfigReader().getBrowser()) : "Expected browser is chrome";

    }

    @When("^Browser is triggered$")
    public void browser_is_triggered() throws Throwable {

        System.out.println("URL :" + FileReaderManager.getInstance().getConfigReader().getUrl() );
        assert "https://www.ryanair.com/ie/en".equals(FileReaderManager.getInstance().getConfigReader().getUrl()) : "Expected URL is https://www.ryanair.com/ie/en";
    }

    @Then("^Check if the URL is correct$")
    public void check_if_the_url_is_correct() throws Throwable {
        System.out.println("URL and Browser is correct");
    }
}
