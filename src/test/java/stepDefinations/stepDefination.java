package stepDefinations;

import Pages.*;
import Utilities.Browser_Base;
import Utilities.Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class stepDefination extends Utils {

    @Given("^I make a booking from origin to destination on 22/02/2023 for 2 adults and 1 child$")
    public void i_make_a_booking_from_origin_to_destination_on_22022023_for_2_adults_and_1_child(DataTable data) throws Throwable {
        Browser_Base.Intialize("chrome", "https://www.ryanair.com/ie/en");
        List<List<String>> dataList =  data.asLists();

        try {
            IBEHomePage newIBEHomePage = PageFactory.initElements(driver, IBEHomePage.class);

            newIBEHomePage.clickAcceptCookieButton();
            newIBEHomePage.clickLoginButton();
            newIBEHomePage.clickLoginWithGmail();
            newIBEHomePage.clickAcceptCookieButton2();
            newIBEHomePage.selectOWType();
            newIBEHomePage.enterDestinationAirport(dataList.get(0).get(0));
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
            newFlightAvailabilityResultPage.enterPassengerDetails(dataList.get(0).get(1),dataList.get(0).get(2),dataList.get(0).get(3),dataList.get(0).get(4),dataList.get(0).get(5),dataList.get(0).get(6));
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


        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;

        }

    }

    @When("^I pay for booking with card details card number, expiry date and cvv$")
    public void i_pay_for_booking_with_card_details_card_number_expiry_date_and_cvv(DataTable data) throws Throwable {
        List<List<String>> dataList =  data.asLists();

        try {
        PaymentConfirmationPage newPaymentConfirmationPage = PageFactory.initElements(driver, PaymentConfirmationPage.class);
        newPaymentConfirmationPage.clickNoInsurance();
        newPaymentConfirmationPage.enterMobileNumber(dataList.get(0).get(0));
        pageEnd();
        newPaymentConfirmationPage.enterCardDetails(dataList.get(0).get(1), dataList.get(0).get(2), dataList.get(0).get(3), dataList.get(0).get(4)  );
        newPaymentConfirmationPage.enterbillingAddress(dataList.get(0).get(5), dataList.get(0).get(6), dataList.get(0).get(7), dataList.get(0).get(8), dataList.get(0).get(9));
        newPaymentConfirmationPage.clickTermsAndConditions();
        pageUp();
        pageUp();
        newPaymentConfirmationPage.makeJSCharacterRecognaized();
        newPaymentConfirmationPage.selectCurrency();
        newPaymentConfirmationPage.clickPayNowButton();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;

        }

    }

    @Then("^I should get payment declined message$")
    public void i_should_get_payment_declined_message() throws Throwable {

        try {
        PaymentConfirmationPage newPaymentConfirmationPage = PageFactory.initElements(driver, PaymentConfirmationPage.class);
        newPaymentConfirmationPage.finalizeTestCase();
        sleeping(30000);
        Utils.endSuite("100", "IBE", "dcs.selenium.report@gmail.com", "lmsbruovggrocqxk", "vikasithasouth@gmail.com");

        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }




}
