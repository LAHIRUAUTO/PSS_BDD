package Pages;

import Utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FlightAvailabilityResultPage extends Utils {

    @FindBy(xpath = "//button[@class='card-price__button ng-tns-c163-11 ry-button--gradient-blue ng-star-inserted']")
    @CacheLookup
    private WebElement selectFlightButton;

    public void selectFlight () throws InterruptedException {
        sleeping(11000);
        explicitWaitElementClickable(selectFlightButton);
        selectFlightButton.click();
    }

    @FindBy(xpath = "//span[@class='_container icon-50']//*[name()='svg']//*[name()='path' and contains(@d,'M32 8C18.7')]")
    @CacheLookup
    private WebElement checkMark;

    public void waitForCheckMark () throws InterruptedException {
        sleeping(3000);
        explicitWaitElementVisible(checkMark);
        checkMark.click();
        checkMark.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Continue for']")
    @CacheLookup
    private WebElement fareCategory;

    public void selectfareCategory () throws InterruptedException {
        sleeping(3000);
            explicitWaitElementVisible(fareCategory);
        fareCategory.click();
    }

    @FindBy(xpath = "//div[@class='login-touchpoint__inner']")
    @CacheLookup
    private WebElement loginPoint;

    public void waitForLoginPoint () {
        explicitWaitElementVisible(loginPoint);
        loginPoint.click();
    }

    @FindBy(xpath = "//span[@class='login-touchpoint__login-later h3']")
    @CacheLookup
    private WebElement loginLater;

    public void clickLoginLater () {
        explicitWaitElementVisible(loginLater);
        loginLater.click();
    }

    @FindBy(xpath = "//pax-passenger-container[1]//pax-passenger[1]//div[1]//pax-passenger-details-container[1]//pax-passenger-details[1]//pax-passenger-details-form-container[1]//pax-details-form[1]//ry-dropdown[1]//div[2]//button[1]")
    @CacheLookup
    private WebElement pax0TitleButton;



    @FindBy(xpath = "//div[@class='dropdown-item__label b2'][normalize-space()='Mr']")
    @CacheLookup
    private WebElement pax0TitleSelection;



    @FindBy(xpath = "//input[@id='form.passengers.ADT-0.name']")
    @CacheLookup
    private WebElement pax0FirstName;

    @FindBy(xpath = "//input[@id='form.passengers.ADT-0.surname']")
    @CacheLookup
    private WebElement pax0LastName;



    @FindBy(xpath = "//pax-passenger-container[2]//pax-passenger[1]//div[1]//pax-passenger-details-container[1]//pax-passenger-details[1]//pax-passenger-details-form-container[1]//pax-details-form[1]//ry-dropdown[1]//div[2]//button[1]//icon[1]//span[1]//*[name()='svg']")
    @CacheLookup
    private WebElement pax1TitleButton;

    @FindBy(xpath = "//div[@class='dropdown-item__label b2'][normalize-space()='Mr']")

    @CacheLookup
    private WebElement pax1TitleSelection;

    @FindBy(xpath = "//input[@id='form.passengers.ADT-1.name']")
    @CacheLookup
    private WebElement pax1FirstName;

    @FindBy(xpath = "//input[@id='form.passengers.ADT-1.surname']")
    @CacheLookup
    private WebElement pax1LastName;



    @FindBy(xpath = "//input[@id='form.passengers.CHD-0.name']")
    @CacheLookup
    private WebElement pax2FirstName;

    @FindBy(xpath = "//input[@id='form.passengers.CHD-0.surname']")
    @CacheLookup
    private WebElement pax2LastName;


    public void enterPassengerDetails (String pax0Firstname, String pax0Lastname, String pax1Firstname, String pax1Lastname, String pax2Firstname, String pax2Lastname ) throws InterruptedException {
        sleeping(1000);
        pax0TitleButton.click();
        pax0TitleSelection.click();
        sleeping(1000);


        pax0FirstName.clear();
        pax0FirstName.sendKeys("");
        pax0FirstName.sendKeys(pax0Firstname);
        pax0LastName.sendKeys(pax0Lastname);


        sleeping(1000);
        pax1TitleButton.click();
        sleeping(1000);
        pax1TitleSelection.click();
        sleeping(1000);
        pax1FirstName.sendKeys(pax1Firstname);
        pax1LastName.sendKeys(pax1Lastname);

        sleeping(1000);
        pax2FirstName.sendKeys(pax2Firstname);
        pax2LastName.sendKeys(pax2Lastname);

    }

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    @CacheLookup
    private WebElement continueButtonOnPassengerDetailsPage;

    public void clickContinueButtonOnPassengerDetailsPage () throws InterruptedException {
        sleeping(1000);
        explicitWaitElementClickable(continueButtonOnPassengerDetailsPage);
        continueButtonOnPassengerDetailsPage.click();
    }




}
