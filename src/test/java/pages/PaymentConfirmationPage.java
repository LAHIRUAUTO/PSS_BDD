package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utils.GenericUtils;

import java.awt.*;
import java.util.List;

public class PaymentConfirmationPage extends GenericUtils {

    private static org.apache.log4j.Logger log = Logger.getLogger(PaymentConfirmationPage   .class);

    public PaymentConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='b2 date-placeholder']")
    @CacheLookup
    private WebElement mobileNumber;

    @FindBy(xpath = "//div[@class='body-l-lg body-l-sm']")
    @CacheLookup
    private WebElement loggedInEmail;

    @FindBy(xpath = "//label[@for='insurance-opt-out']//div[@class='_background']")
    @CacheLookup
    private WebElement noInsurance;

    public void clickNoInsurance () throws InterruptedException {


        try {
            explicitWaitElementClickable(noInsurance);
            noInsurance.click();
        }
        catch (Exception e) {
            e.printStackTrace();
            clickNoInsurance();
            log.error("An exception! Oops!", e);
        }
    }


    public void enterMobileNumber(String mobileNumber) throws InterruptedException, AWTException {

        try {
            explicitWaitElementClickable(this.mobileNumber);
            sendKeysThroughJS( mobileNumber, this.mobileNumber);
        } catch (Exception e) {
            e.printStackTrace();
            enterMobileNumber(mobileNumber);
            log.error("An exception! Oops!", e);
        }
    }

    @FindBy(xpath = "//input[@name='cardNumber']")
    @CacheLookup
    private WebElement cardNumber;

    @FindBy(xpath = "//input[@placeholder='MM/YY']")
    @CacheLookup
    private WebElement expiryDate;

    @FindBy(xpath = "//input[@placeholder='CVV']")
    @CacheLookup
    private WebElement securityCode;

    @FindBy(xpath = "//input[@name='ccname']")
    @CacheLookup
    private WebElement cardHolderName;

    public void enterCardDetails (String creditCardNumber, String creditCardExpiryDate, String creditCardSecurityCode, String creditCardHolderName) throws InterruptedException {
        pageEnd();
        //explicitWaitFrameVisible(0);
        switchToFrameWithIndex(0);
        explicitWaitElementVisible(cardNumber);
        sendKeysThroughJS(creditCardNumber, cardNumber);
        switchToDefaultContent();
        sendKeysThroughJS(creditCardExpiryDate, expiryDate);
        sendKeysThroughJS(creditCardSecurityCode, securityCode);
        sendKeysThroughJS(creditCardHolderName, cardHolderName);
    }

    @FindBy(xpath = "//input[@name='address-line1']")
    @CacheLookup
    private WebElement addressLine1;

    @FindBy(xpath = "//input[@name='address-line2']")
    @CacheLookup
    private WebElement addressLine2;

    @FindBy(xpath = "//input[@name='city']")
    @CacheLookup
    private WebElement city;

    @FindBy(xpath = "//input[@name='country']")
    @CacheLookup
    private WebElement country;


    @FindBy(xpath = "//input[@name='postcode']")
    @CacheLookup
    private WebElement zipCode;

    public void enterbillingAddress (String addressline1, String addressline2, String ciTy, String CounTry, String ziPcode) throws AWTException, InterruptedException {
        explicitWaitElementVisible(addressLine1);
        explicitWaitElementVisible(addressLine2);
        explicitWaitElementVisible(city);
        explicitWaitElementVisible(country);
        addressLine1.sendKeys("");
        addressLine1.sendKeys(addressline1);
        addressLine2.sendKeys(addressline2);
        city.sendKeys(ciTy);
        country.sendKeys(CounTry);
        pressTab();
        pressTab();
        pressTab();
        pressTab();
        explicitWaitElementVisible(zipCode);
        zipCode.sendKeys(ziPcode);

    }

    @FindBy(xpath = "//span[@class='dropdown__toggle-text ng-star-inserted']")
    @CacheLookup
    private WebElement currencyDropdown;

    @FindBy(xpath = "//ry-dropdown-item[1]//button[1]//div[1]//div[1]")
    @CacheLookup
    private WebElement clickCurrency;

    public void selectCurrency () throws InterruptedException {
        explicitWaitElementClickable(currencyDropdown);
        currencyDropdown.click();
        clickCurrency.click();
    }

    @FindBy(xpath = "//label[@for='termsAndConditions']//div[@class='_background']")
    @CacheLookup
    private WebElement termsAndConditions;

    public void clickTermsAndConditions () throws InterruptedException {
        explicitWaitElementClickable(termsAndConditions);
        termsAndConditions.click();
    }

    public void numberOfFrames () {
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        List<WebElement> elem = driver.findElements(By.tagName("iframe"));
        System.out.println(elem);
    }

    @FindBy(xpath = "//button[normalize-space()='Pay now']")
    @CacheLookup
    private WebElement payNowButton;

    public void clickPayNowButton () throws InterruptedException {
        explicitWaitElementClickable(payNowButton);
        payNowButton.click();
    }

    public void makeJSCharacterRecognaized () throws AWTException, InterruptedException {
        pageUp();
        pageUp();
        explicitWaitElementClickable(mobileNumber);
        mobileNumber.click();
        pressEnter();

        //explicitWaitFrameVisible(0);
        switchToFrameWithIndex(0);
        explicitWaitElementClickable(cardNumber);
        cardNumber.click();
        pressEnter();

        switchToDefaultContent();
        explicitWaitElementClickable(expiryDate);
        expiryDate.click();
        pressEnter();

        explicitWaitElementClickable(securityCode);
        securityCode.click();
        pressEnter();

        explicitWaitElementClickable(cardHolderName);
        cardHolderName.click();
        pressEnter();

    }

    @FindBy(xpath = "//div[@class='b2 ng-star-inserted']")
    @CacheLookup
    private WebElement paymentFailureMessage;

    @FindBy(xpath = "//button[@class='tooltip-button']")
    @CacheLookup
    private WebElement loggedInUser;

    @FindBy(xpath = "//button[@class='log-out ry-button--anchor-blue log-out--left ry-button--anchor']")
    @CacheLookup
    private WebElement logOutButton;

    @FindBy(xpath = "//div[@class='header-modal__title header-modal__title--desktop']")
    @CacheLookup
    private WebElement loginWithGmailPopUp;




    public void finalizeTestCase () throws InterruptedException {
        explicitWaitElementVisible(paymentFailureMessage);

        try {
            if (paymentFailureMessage.isDisplayed()) {
                System.out.println(paymentFailureMessage.getText());
                explicitWaitElementClickable(loggedInUser);
                loggedInUser.click();
                explicitWaitElementClickable(logOutButton);
                logOutButton.click();
                explicitWaitElementVisible(loginWithGmailPopUp);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("An exception! Oops!", e);
            throw e;

        }

    }


}
