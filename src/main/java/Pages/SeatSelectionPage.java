package Pages;

import Utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SeatSelectionPage extends Utils {

    @FindBy(xpath = "//button[normalize-space()='Okay, got it.']")
    @CacheLookup
    private WebElement seatSelectionWarningMessage;

    public void acceptSeatSelectionWarningMessage () throws InterruptedException {
        sleeping(5000);
        explicitWaitElementVisible(seatSelectionWarningMessage);
        explicitWaitElementClickable(seatSelectionWarningMessage);
        seatSelectionWarningMessage.click();

    }

    @FindBy(xpath = "//div[@class='seatmap']")
    @CacheLookup
    private WebElement seatMap;

    String pax0Seat;
    @FindBy(xpath = "//button[@id='seat-11A']")
    @CacheLookup
    private WebElement seatForPax0;

    @FindBy(xpath = "//button[@id='seat-11B']")
    @CacheLookup
    private WebElement seatForPax1;

    @FindBy(xpath = "//button[@id='seat-11C']")
    @CacheLookup
    private WebElement seatForPax2;

    public void selectSeats () throws InterruptedException {
        sleeping(1000);
        explicitWaitElementVisible(seatMap);
        seatForPax0.click();
        seatForPax1.click();
        seatForPax2.click();

    }

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    @CacheLookup
    private WebElement continueButtonFromSeatSelectionPage;

    public void clickContinueButtonFromSeatSelectionPage () throws InterruptedException {
        sleeping(1000);
        explicitWaitElementVisible(continueButtonFromSeatSelectionPage);
        continueButtonFromSeatSelectionPage.click();
    }

    @FindBy(xpath = "//button[normalize-space()='No, thanks']")
    @CacheLookup
    private WebElement declineFastTrackButton;

    public void clickDeclineFastTrackButton () throws InterruptedException {
        sleeping(1000);
        try {
            explicitWaitElementVisible(declineFastTrackButton);
            declineFastTrackButton.click();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
