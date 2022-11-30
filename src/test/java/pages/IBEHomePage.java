package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import utils.GenericUtils;

public class IBEHomePage extends GenericUtils {

    private static org.apache.log4j.Logger log = Logger.getLogger(IBEHomePage.class);



    public IBEHomePage(WebDriver driver) {
        super(driver);
    }


    //Accept cookie button
    @FindBy(className="cookie-popup-with-overlay__button")
    @CacheLookup
    private WebElement cookieAcceptButton;

    @FindBy(className="cookie-popup-with-overlay__button")
    @CacheLookup
    private WebElement cookieAcceptButton2;

    @FindBy(xpath = "//span[normalize-space()='Log In']")
    @CacheLookup
    private WebElement loginButton;

    @FindBy(xpath = "//span[normalize-space()='Continue with Google']")
    @CacheLookup
    private WebElement loginWithGmail;

    @FindBy(xpath = "//div[@class='header-modal__title header-modal__title--desktop']")
    @CacheLookup
    private WebElement loginWithGmailPopUp;



    @FindBy(xpath = "//ry-auth-popup[@class='auth-popup']")
    @CacheLookup
    private WebElement loginPopUp;

    @FindBy(xpath = "//input[@placeholder='email@email.com']")
    @CacheLookup
    private WebElement fillEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    @CacheLookup
    private WebElement fillPassword;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    @CacheLookup
    private WebElement logingButton2;

    //Select trip type
    @FindBy(xpath="//label[normalize-space()='One way']")
    @CacheLookup
    private WebElement tripType;

    @FindBy(xpath="//ry-tooltip[@id='ry-tooltip-3']")
    @CacheLookup
    private WebElement destinationToolTip;

    @FindBy(xpath="//input[@id='input-button__destination']")
    @CacheLookup
    private WebElement destinationAirport;

    @FindBy(xpath="//span[contains(text(),'Berlin')]")
    @CacheLookup
    private WebElement destinationAirportSelect;

    @FindBy(xpath="//div[contains(text(),'Jan')]")
    @CacheLookup
    private WebElement departureMonth;

    @FindBy(xpath="//div[@class='calendar-body__cell'][normalize-space()='22']")
    @CacheLookup
    private WebElement departureDate;

    @FindBy(xpath="//ry-counter[@data-ref='passengers-picker__adults']//div[@class='counter__button-wrapper--enabled']")
    @CacheLookup
    private WebElement addNumberOfADT;

    @FindBy(xpath="//ry-counter[@data-ref='passengers-picker__children']//div[@class='counter__button-wrapper--enabled']")
    @CacheLookup
    private WebElement addNumberOfCHD;

    @FindBy(xpath="//button[@aria-label='Done']")
    @CacheLookup
    private WebElement doneButtonOnPaxSelection;

    @FindBy(xpath="//button[@aria-label='Search']")
    @CacheLookup
    private WebElement searchButton;

    public void clickAcceptCookieButton () {
        try {
            cookieAcceptButton.click();
        }
        catch (Exception e) {
            log.error("An exception! Oops!", e);
        }
    }

    public void clickAcceptCookieButton2 () {
        try {
            cookieAcceptButton2.click();
        }
        catch (Exception e) {
            log.error("An exception! Oops!", e);
        }
    }

    public void clickLoginButton () throws InterruptedException {



            try {

                explicitWaitElementClickable(loginButton);
                loginButton.click();

            } catch (Exception e) {
                e.printStackTrace();
                log.error("An exception! Oops!", e);

        }
    }

    public void clickLoginWithGmail () throws InterruptedException {


            try {
                    explicitWaitElementVisible(loginWithGmailPopUp);
                    explicitWaitElementClickable(loginWithGmail);
                    sleeping(2000);
                    loginWithGmail.click();

            } catch (Exception e) {
                e.printStackTrace();
                log.error("An exception! Oops!", e);
            }


    }

    public void waitForDisappearLoginWithGmail () throws InterruptedException {


            try {
                explicitWaitElementInvisibilityOf(loginWithGmailPopUp);
            } catch (Exception e) {
                e.printStackTrace();

        }
    }



    public void loginToAccount () {

        explicitWaitElementVisible(loginPopUp);
        fillEmail.sendKeys("vikasithasouth@gmail.com");
        fillPassword.sendKeys("Ryanair@123");
        logingButton2.click();

    }

    public void selectOWType () throws InterruptedException {
        explicitWaitElementClickable(tripType);
        tripType.click();
    }

    public void enterDestinationAirport (String destinationAirportName) throws InterruptedException {
            explicitWaitElementClickable(destinationAirport);
            destinationAirport.sendKeys("");
            destinationAirport.sendKeys(destinationAirportName);
    }

    public void selectDestinationAirport () throws InterruptedException {
        if (destinationToolTip.isEnabled()) {
            explicitWaitElementVisible(destinationAirportSelect);
            destinationAirportSelect.click();
        }
    }


    public void selectDepartureMonth () throws InterruptedException {
        explicitWaitElementClickable(departureMonth);
        departureMonth.click();

    }


    public void selectDepartureDate () throws InterruptedException {
        explicitWaitElementClickable(departureDate);
        departureDate.click();

    }



    public void selectAddNumberOfADT () throws InterruptedException {
        explicitWaitElementClickable(addNumberOfADT);
        addNumberOfADT.click();

    }



    public void selectAddNumberOfCHD () throws InterruptedException {
        explicitWaitElementClickable(addNumberOfADT);
        addNumberOfCHD.click();

    }



    public void clickDoneButtonOnPaxSelection () throws InterruptedException {
        explicitWaitElementClickable(doneButtonOnPaxSelection);
        doneButtonOnPaxSelection.click();

    }



    public void clickSearchButton () throws InterruptedException {
        explicitWaitElementClickable(searchButton);
        searchButton.click();

    }





}
