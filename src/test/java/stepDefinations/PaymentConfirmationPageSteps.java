package stepDefinations;

import pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import utils.TestContextSetup;

import java.util.List;

public class PaymentConfirmationPageSteps {

    TestContextSetup testContextSetup;
    PaymentConfirmationPage paymentConfirmationPage;

    public PaymentConfirmationPageSteps(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
        this.paymentConfirmationPage = testContextSetup.pageObjectManager.getPaymentConfirmationPageObjects();
    }


    @When("^I pay for booking with card details card number, expiry date and cvv$")
    public void i_pay_for_booking_with_card_details_card_number_expiry_date_and_cvv(DataTable data) throws Throwable {
        List<List<String>> dataList =  data.asLists();

        try {
            paymentConfirmationPage.clickNoInsurance();
            paymentConfirmationPage.enterMobileNumber(dataList.get(0).get(0));
            paymentConfirmationPage.enterCardDetails(dataList.get(0).get(1), dataList.get(0).get(2), dataList.get(0).get(3), dataList.get(0).get(4)  );
            paymentConfirmationPage.enterbillingAddress(dataList.get(0).get(5), dataList.get(0).get(6), dataList.get(0).get(7), dataList.get(0).get(8), dataList.get(0).get(9));
            paymentConfirmationPage.clickTermsAndConditions();
            paymentConfirmationPage.makeJSCharacterRecognaized();
            paymentConfirmationPage.selectCurrency();
            paymentConfirmationPage.clickPayNowButton();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;

        }

    }

    @Then("^I should get payment declined message$")
    public void i_should_get_payment_declined_message() throws Throwable {

        try {
            paymentConfirmationPage.finalizeTestCase();

        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;

        }
    }




}
