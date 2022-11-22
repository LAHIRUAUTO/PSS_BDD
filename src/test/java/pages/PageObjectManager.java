package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

    public IBEHomePage ibeHomePage;
    public FlightAvailabilityResultPage flightAvailabilityResultPage;
    public SeatSelectionPage seatSelectionPage;
    public BaggageSelectionPage baggageSelectionPage;
    public FlightExtrasPage flightExtrasPage;
    public PaymentConfirmationPage paymentConfirmationPage;
    public WebDriver driver;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;

    }

    public IBEHomePage getIBEHomePageObjects () {
        ibeHomePage = PageFactory.initElements(driver, IBEHomePage.class);
        return ibeHomePage;

    }

    public FlightAvailabilityResultPage getFlightAvailabilityResultPageObjects () {
        flightAvailabilityResultPage = PageFactory.initElements(driver, FlightAvailabilityResultPage.class);
        return flightAvailabilityResultPage;
    }

    public SeatSelectionPage getSeatSelectionPageObjects () {
        seatSelectionPage = PageFactory.initElements(driver, SeatSelectionPage.class);
        return seatSelectionPage;
    }

    public BaggageSelectionPage getBaggageSelectionPageObjects () {
        baggageSelectionPage = PageFactory.initElements(driver, BaggageSelectionPage.class);
        return baggageSelectionPage;
    }

    public FlightExtrasPage getFlightExtrasPageObjects () {
        flightExtrasPage = PageFactory.initElements(driver, FlightExtrasPage.class);
        return flightExtrasPage;
    }

    public PaymentConfirmationPage getPaymentConfirmationPageObjects () {
        paymentConfirmationPage = PageFactory.initElements(driver, PaymentConfirmationPage.class);
        return paymentConfirmationPage;
    }



}
