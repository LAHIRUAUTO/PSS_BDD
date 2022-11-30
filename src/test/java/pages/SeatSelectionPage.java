package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utils.GenericUtils;

public class SeatSelectionPage extends GenericUtils {

    private static org.apache.log4j.Logger log = Logger.getLogger(SeatSelectionPage.class);

    public SeatSelectionPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//button[normalize-space()='Okay, got it.']")
    @CacheLookup
    private WebElement seatSelectionWarningMessage;

    public void acceptSeatSelectionWarningMessage () throws InterruptedException {
        try {
            explicitWaitElementClickable(seatSelectionWarningMessage);
            seatSelectionWarningMessage.click();
        }
        catch (Exception e) {
            acceptSeatSelectionWarningMessage();
            log.error("An exception! Oops!", e);
        }

    }

    @FindBy(xpath = "//div[@class='seatmap']")
    @CacheLookup
    private WebElement seatMap;


    public void selectSeats (String pax0seat,String pax1seat,String pax2seat) throws InterruptedException {
        explicitWaitElementVisible(seatMap);
        driver.findElement(By.xpath("//button[@id='seat-"+pax0seat+"']")).click();
        driver.findElement(By.xpath("//button[@id='seat-"+pax1seat+"']")).click();
        driver.findElement(By.xpath("//button[@id='seat-"+pax2seat+"']")).click();


    }

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    @CacheLookup
    private WebElement continueButtonFromSeatSelectionPage;

    public void clickContinueButtonFromSeatSelectionPage () throws InterruptedException {
        explicitWaitElementVisible(continueButtonFromSeatSelectionPage);
        continueButtonFromSeatSelectionPage.click();
    }

    @FindBy(xpath = "//button[normalize-space()='No, thanks']")
    @CacheLookup
    private WebElement declineFastTrackButton;

    public void clickDeclineFastTrackButton () throws InterruptedException {
        try {
            explicitWaitElementVisible(declineFastTrackButton);
            declineFastTrackButton.click();
        }
        catch (Exception e) {

            e.printStackTrace();
            log.error("An exception! Oops!", e);

        }
    }

}
