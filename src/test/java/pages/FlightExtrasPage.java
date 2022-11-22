package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utils.GenericUtils;

public class FlightExtrasPage extends GenericUtils {


    public FlightExtrasPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Flight extras']")


    @CacheLookup
    private WebElement flightExtrasBreadcrum;

    public void clickFlightExtrasBreadcrum () {
        explicitWaitElementVisible(flightExtrasBreadcrum);
        flightExtrasBreadcrum.click();
    }

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    @CacheLookup
    private WebElement continueButtonFromFlightExtrasPage;

    public void clickContinueButtonFromFlightExtrasPage () throws InterruptedException {
        pageEnd();
        sleeping(1000);
        explicitWaitElementVisible(continueButtonFromFlightExtrasPage);
        continueButtonFromFlightExtrasPage.click();
    }

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    @CacheLookup
    private WebElement continueButtonFromFlightExtrasPage2;

    public void clickContinueButtonFromFlightExtrasPage2 () throws InterruptedException {
        pageEnd();
        sleeping(2000);
        explicitWaitElementVisible(continueButtonFromFlightExtrasPage2);
        continueButtonFromFlightExtrasPage2.click();
    }
}
