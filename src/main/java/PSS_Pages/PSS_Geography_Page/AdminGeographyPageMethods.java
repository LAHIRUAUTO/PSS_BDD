package PSS_Pages.PSS_Geography_Page;

import org.openqa.selenium.support.ui.Select;

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

    public void clickAddAirportButtonLocator () {
        explicitWaitElementVisible(addAirportButtonLocator);
    }

    public void clickAirportDSTSearchButtonLocator () {
        explicitWaitElementClickable(airportDSTSearchButtonLocator);
        airportDSTSearchButtonLocator.click();
    }

    public void clickAddAirportDSTButtonLocator () {
        explicitWaitElementClickable(addAirportDSTButtonLocator);
        addAirportDSTButtonLocator.click();
    }

    public void selectcountry (String country) {
        Select selectCountry = new Select(countryField);
        selectCountry.selectByVisibleText(country);
    }

    public void clickCitySearchButtonLocator () {
        explicitWaitElementClickable(searchCityButtonLocator);
        searchCityButtonLocator.click();
    }

    public void clickCityLocator () {
        explicitWaitElementVisible(cityLocator);
        doubleClick(cityLocator);
    }
}
