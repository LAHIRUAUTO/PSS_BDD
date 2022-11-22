package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utils.GenericUtils;

public class SeatSelectionPage extends GenericUtils {


    public SeatSelectionPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//button[normalize-space()='Okay, got it.']")
    @CacheLookup
    private WebElement seatSelectionWarningMessage;

    public void acceptSeatSelectionWarningMessage () throws InterruptedException {
        try {
            sleeping(5000);
            explicitWaitElementClickable(seatSelectionWarningMessage);
            seatSelectionWarningMessage.click();
        }
        catch (Exception e) {
            acceptSeatSelectionWarningMessage();
        }

    }

    @FindBy(xpath = "//div[@class='seatmap']")
    @CacheLookup
    private WebElement seatMap;

    String pax0Seat;
    @FindBy(xpath = "//button[@id='seat-12A']")
    @CacheLookup
    private WebElement seatForPax0;

    @FindBy(xpath = "//button[@id='seat-12B']")
    @CacheLookup
    private WebElement seatForPax1;

    @FindBy(xpath = "//button[@id='seat-12C']")
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
