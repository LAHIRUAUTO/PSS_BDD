package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utils.GenericUtils;

public class BaggageSelectionPage extends GenericUtils {

    private static org.apache.log4j.Logger log = Logger.getLogger(BaggageSelectionPage.class);


    public BaggageSelectionPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//label[@for='ry-radio-button--0']")
    @CacheLookup
    private WebElement smallCabinBaggageButton;

    public void clickSmallCabinBaggageButton () throws InterruptedException {
        sleeping(1000);
        explicitWaitElementVisible(smallCabinBaggageButton);
        smallCabinBaggageButton.click();
    }

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    @CacheLookup
    private WebElement continueButtonFromBaggageSelectionPage;

    public void clickContinueButtonFromBaggageSelectionPage () throws InterruptedException {
        pageEnd();
        sleeping(1000);
        explicitWaitElementVisible(continueButtonFromBaggageSelectionPage);
        continueButtonFromBaggageSelectionPage.click();
    }
}
