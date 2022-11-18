package Pages;

import Utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class IBEHomePage extends Utils {


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

    public void clickAcceptCookieButton () {

        try {
            cookieAcceptButton.click();
        }
        catch (Exception e) {

        }

    }



    public void clickAcceptCookieButton2 () {

        try {
            cookieAcceptButton2.click();
        }
        catch (Exception e) {

        }

    }



    public void clickLoginButton () throws InterruptedException {
        sleeping(2000);

        try {
            loginButton.click();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }



    public void clickLoginWithGmail () throws InterruptedException {
        sleeping(5000);

        try {
            loginWithGmail.click();
        }
        catch (Exception e) {
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
        sleeping(2000);
        explicitWaitElementClickable(tripType);
        tripType.click();

    }



    public void enterDestinationAirport (String destinationAirportName) throws InterruptedException {
            sleeping(3000);
            explicitWaitElementClickable(destinationAirport);
            destinationAirport.sendKeys("");
            destinationAirport.sendKeys(destinationAirportName);


    }




    public void selectDestinationAirport () throws InterruptedException {
        if (destinationToolTip.isEnabled()) {
            sleeping(1000);
            explicitWaitElementVisible(destinationAirportSelect);
            destinationAirportSelect.click();
        }
    }



    public void selectDepartureMonth () throws InterruptedException {
        sleeping(1000);
        departureMonth.click();

    }



    public void selectDepartureDate () throws InterruptedException {
        sleeping(1000);
        explicitWaitElementClickable(departureDate);
        departureDate.click();

    }



    public void selectAddNumberOfADT () throws InterruptedException {
        sleeping(1000);
        explicitWaitElementClickable(addNumberOfADT);
        addNumberOfADT.click();

    }



    public void selectAddNumberOfCHD () throws InterruptedException {
        sleeping(1000);
        explicitWaitElementClickable(addNumberOfADT);
        addNumberOfCHD.click();

    }



    public void clickDoneButtonOnPaxSelection () throws InterruptedException {
        sleeping(1000);
        explicitWaitElementClickable(doneButtonOnPaxSelection);
        doneButtonOnPaxSelection.click();

    }

    @FindBy(xpath="//button[@aria-label='Search']")
    @CacheLookup
    private WebElement searchButton;

    public void clickSearchButton () throws InterruptedException {
        sleeping(1000);
        explicitWaitElementClickable(searchButton);
        searchButton.click();

    }







    public IBEHomePage() throws IOException {
    }
}
