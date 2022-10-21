package PSS_Pages.PSS_Geography_Page;

public class AdminGeographyPageMethods extends AdminGeographyPageObjects{

    public void clickAirportCodeFieldLocator (String airportCode) {
        explicitWaitElementVisible(airportCodeFieldLocator);
        airportCodeFieldLocator.sendKeys(airportCode);
    }

    public void clickAirportSearchButtonLocator () {
        explicitWaitElementClickable(airportSearchButtonLocator);
        airportSearchButtonLocator.click();
    }

    public void clickAirportLocator () {
        explicitWaitElementVisible(airportLocator);
        doubleClick(airportLocator);
    }
}
