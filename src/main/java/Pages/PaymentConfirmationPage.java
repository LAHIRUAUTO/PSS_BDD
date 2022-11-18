package Pages;

import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class PaymentConfirmationPage extends Utils {

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
        sleeping(1000);
        noInsurance.click();
    }


    public void enterMobileNumber(String mobileNumber) throws InterruptedException, AWTException {
        sleeping(2000);
        sendKeysThroughJS( mobileNumber, this.mobileNumber);
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

        sleeping(3000);
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

    //span[@class='reactive-complete__search-value ng-star-inserted']

    @FindBy(xpath = "//input[@name='postcode']")
    @CacheLookup
    private WebElement zipCode;

    public void enterbillingAddress (String addressline1, String addressline2, String ciTy, String CounTry, String ziPcode) throws AWTException, InterruptedException {
        sleeping(1000);
        explicitWaitElementVisible(addressLine1);
        explicitWaitElementVisible(addressLine2);
        explicitWaitElementVisible(city);
        explicitWaitElementVisible(country);
        sleeping(1000);
        addressLine1.sendKeys("");
        addressLine1.sendKeys(addressline1);
        sleeping(1000);
        addressLine2.sendKeys(addressline2);
        city.sendKeys(ciTy);
        country.sendKeys(CounTry);
        sleeping(1000);
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
        sleeping(3000);
        explicitWaitElementClickable(currencyDropdown);
        currencyDropdown.click();
        clickCurrency.click();
    }

    @FindBy(xpath = "//label[@for='termsAndConditions']//div[@class='_background']")
    @CacheLookup
    private WebElement termsAndConditions;

    public void clickTermsAndConditions () throws InterruptedException {
        sleeping(1000);
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
        sleeping(1000);
        explicitWaitElementClickable(payNowButton);
        payNowButton.click();
    }

    public void makeJSCharacterRecognaized () throws AWTException, InterruptedException {
        sleeping(1000);
        mobileNumber.click();
        pressEnter();

        sleeping(1000);
        switchToFrameWithIndex(0);
        cardNumber.click();
        pressEnter();

        sleeping(1000);
        switchToDefaultContent();
        expiryDate.click();
        pressEnter();

        sleeping(1000);
        securityCode.click();
        pressEnter();

        sleeping(1000);
        cardHolderName.click();
        pressEnter();

    }

    @FindBy(xpath = "//div[@class='b2 ng-star-inserted']")
    @CacheLookup
    private WebElement paymentFailureMessage;

    public void finalizeTestCase () throws InterruptedException {
        sleeping(2000);
        explicitWaitElementVisible(paymentFailureMessage);

        try {
            if (paymentFailureMessage.isDisplayed()) {
                System.out.println(paymentFailureMessage.getText());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }


}
