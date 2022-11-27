package stepDefinations;

import pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;
import utils.TestContextSetup;

import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class IBEHomePageSteps {

    TestContextSetup testContextSetup;
    IBEHomePage ibeHomePage;
    FlightAvailabilityResultPage flightAvailabilityResultPage;
    SeatSelectionPage seatSelectionPage;

    BaggageSelectionPage baggageSelectionPage;

    FlightExtrasPage flightExtrasPage;

    public IBEHomePageSteps(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
        this.ibeHomePage = testContextSetup.pageObjectManager.getIBEHomePageObjects();
        this.flightAvailabilityResultPage = testContextSetup.pageObjectManager.getFlightAvailabilityResultPageObjects();
        this.seatSelectionPage = testContextSetup.pageObjectManager.getSeatSelectionPageObjects();
        this.baggageSelectionPage = testContextSetup.pageObjectManager.getBaggageSelectionPageObjects();
        this.flightExtrasPage = testContextSetup.pageObjectManager.getFlightExtrasPageObjects();


    }

    @Given("^I make a booking from origin to destination on 22/02/2023 for 2 adults and 1 child$")
    public void i_make_a_booking_from_origin_to_destination_on_22022023_for_2_adults_and_1_child(DataTable data) throws Throwable {

        List<List<String>> dataList =  data.asLists();

        try {

            ibeHomePage.clickAcceptCookieButton();
            ibeHomePage.clickLoginButton();
            ibeHomePage.clickLoginWithGmail();
            ibeHomePage.clickAcceptCookieButton2();
            ibeHomePage.selectOWType();
            ibeHomePage.enterDestinationAirport(dataList.get(0).get(0));
            ibeHomePage.selectDestinationAirport();
            ibeHomePage.selectDepartureMonth();
            ibeHomePage.selectDepartureDate();
            ibeHomePage.selectAddNumberOfADT();
            ibeHomePage.selectAddNumberOfCHD();
            ibeHomePage.clickDoneButtonOnPaxSelection();
            ibeHomePage.clickSearchButton();

            flightAvailabilityResultPage.selectFlight();
            flightAvailabilityResultPage.waitForCheckMark();
            flightAvailabilityResultPage.selectfareCategory();
            flightAvailabilityResultPage.waitForCheckMark();
            flightAvailabilityResultPage.enterPassengerDetails(dataList.get(0).get(1),dataList.get(0).get(2),dataList.get(0).get(3),dataList.get(0).get(4),dataList.get(0).get(5),dataList.get(0).get(6));
            flightAvailabilityResultPage.clickContinueButtonOnPassengerDetailsPage();


            seatSelectionPage.acceptSeatSelectionWarningMessage();
            seatSelectionPage.selectSeats();
            seatSelectionPage.clickContinueButtonFromSeatSelectionPage();
            seatSelectionPage.clickDeclineFastTrackButton();

            baggageSelectionPage.clickSmallCabinBaggageButton();
            baggageSelectionPage.clickContinueButtonFromBaggageSelectionPage();



            flightExtrasPage.clickContinueButtonFromFlightExtrasPage();
            flightExtrasPage.clickContinueButtonFromFlightExtrasPage2();


        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;

        }

    }






}
