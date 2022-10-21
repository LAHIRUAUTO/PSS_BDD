package PSS_Pages.PSS_Geography_Page;

import Utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminGeographyPageObjects extends Utils {

    @FindBy (xpath = "//input[@name='airportCode']")
    WebElement airportCodeFieldLocator;

    @FindBy (xpath = "//span[@class='spn-action search-btn']")
    WebElement airportSearchButtonLocator;

    @FindBy (xpath = "//td[normalize-space()='HMB']")
    WebElement airportLocator;
}
