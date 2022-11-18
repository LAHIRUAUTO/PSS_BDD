package TestRunner;



//import PSS_Pages.PSS_Login_Page.AdminLoginPageMethods;
import Pages.*;
import Utilities.TestNGDataProvider;
import Utilities.Utils;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class TestRunner extends Utils {

    @Parameters({"url"})
    @BeforeTest
    public void validateCurrentURL (String url){
        System.out.println("Page Title : "+driver.getTitle());
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(url), "Incorrect URL");
    }

    @Parameters({"title"})
    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class)
    public void createBooking2ADT1CHD(String destinationAirportName,
                                      String pax0Firstname,
                                      String pax0Lastname,
                                      String pax1Firstname,
                                      String pax1Lastname,
                                      String pax2Firstname,
                                      String pax2Lastname,
                                      String mobileNumber,
                                      String creditCardNumber,
                                      String creditCardExpiryDate,
                                      String creditCardSecurityCode,
                                      String creditCardHolderName,
                                      String addressline1,
                                      String addressline2,
                                      String ciTy,
                                      String CounTry,
                                      String ziPcode
    ) throws InterruptedException, AWTException {


        try {
            IBEHomePage newIBEHomePage = PageFactory.initElements(driver, IBEHomePage.class);

            newIBEHomePage.clickAcceptCookieButton();
            newIBEHomePage.clickLoginButton();
            newIBEHomePage.clickLoginWithGmail();
            newIBEHomePage.clickAcceptCookieButton2();
            newIBEHomePage.selectOWType();
            newIBEHomePage.enterDestinationAirport(destinationAirportName);
            newIBEHomePage.selectDestinationAirport();
            newIBEHomePage.selectDepartureMonth();
            newIBEHomePage.selectDepartureDate();
            newIBEHomePage.selectAddNumberOfADT();
            newIBEHomePage.selectAddNumberOfCHD();
            newIBEHomePage.clickDoneButtonOnPaxSelection();
            newIBEHomePage.clickSearchButton();

            FlightAvailabilityResultPage newFlightAvailabilityResultPage = PageFactory.initElements(driver, FlightAvailabilityResultPage.class);
            newFlightAvailabilityResultPage.selectFlight();
            newFlightAvailabilityResultPage.waitForCheckMark();
            pageEnd();
            newFlightAvailabilityResultPage.selectfareCategory();
            newFlightAvailabilityResultPage.waitForCheckMark();
            pageScroll(10);
            newFlightAvailabilityResultPage.enterPassengerDetails(pax0Firstname,pax0Lastname,pax1Firstname,pax1Lastname,pax2Firstname,pax2Lastname);
            newFlightAvailabilityResultPage.clickContinueButtonOnPassengerDetailsPage();


            SeatSelectionPage newSeatSelectionPage = PageFactory.initElements(driver, SeatSelectionPage.class);
            newSeatSelectionPage.acceptSeatSelectionWarningMessage();
            newSeatSelectionPage.selectSeats();
            newSeatSelectionPage.clickContinueButtonFromSeatSelectionPage();
            newSeatSelectionPage.clickDeclineFastTrackButton();

            BaggageSelectionPage newBaggageSelectionPage = PageFactory.initElements(driver, BaggageSelectionPage.class);
            newBaggageSelectionPage.clickSmallCabinBaggageButton();
            pageEnd();
            newBaggageSelectionPage.clickContinueButtonFromBaggageSelectionPage();


            FlightExtrasPage newFlightExtrasPage = PageFactory.initElements(driver, FlightExtrasPage.class);
            pageEnd();
            newFlightExtrasPage.clickContinueButtonFromFlightExtrasPage();
            pageEnd();
            newFlightExtrasPage.clickContinueButtonFromFlightExtrasPage2();


            PaymentConfirmationPage newPaymentConfirmationPage = PageFactory.initElements(driver, PaymentConfirmationPage.class);
            newPaymentConfirmationPage.clickNoInsurance();
            newPaymentConfirmationPage.enterMobileNumber(mobileNumber);
            pageEnd();
            newPaymentConfirmationPage.enterCardDetails(creditCardNumber, creditCardExpiryDate, creditCardSecurityCode, creditCardHolderName  );
            newPaymentConfirmationPage.enterbillingAddress(addressline1, addressline2, ciTy, CounTry, ziPcode);
            newPaymentConfirmationPage.clickTermsAndConditions();
            pageUp();
            pageUp();
            newPaymentConfirmationPage.makeJSCharacterRecognaized();
            newPaymentConfirmationPage.selectCurrency();
            newPaymentConfirmationPage.clickPayNowButton();
            newPaymentConfirmationPage.finalizeTestCase();


        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }





}
