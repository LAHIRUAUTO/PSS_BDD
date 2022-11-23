package utils;


import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

public class GenericUtils {

    public WebDriver driver;
    public GenericUtils (WebDriver driver) {

        this.driver = driver;
    }

    public void switchToIframe () {
        driver.switchTo().frame(0);
    }

    public void switchToDefaultContent () {
        driver.switchTo().defaultContent();
    }

    public void explicitWaitElementVisible (WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element ));
    }

    public void sleeping (int miliSeconds) throws InterruptedException {
        Thread.sleep(miliSeconds);
    }



    //Explicit Wait ElementClickable
    public void explicitWaitElementClickable(WebElement element) {
        WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitwait.until(ExpectedConditions.elementToBeClickable(element));

    }

    //Fluent Wait ElementVisible
    public void fluentWaitElementVisible(WebElement element) {
        Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void threadSleep () throws InterruptedException {
        Thread.sleep(5000);
    }

    public void isEnabled (WebElement element) {
        element.isEnabled();
    }

    public void isDisplayed (WebElement element) {
        element.isDisplayed();
    }

    public void isSelected (WebElement element) {
        element.isSelected();
    }


    //On mouse Hover
    public void mouseHover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    //Click
    public void click(WebElement element) {
        Actions action = new Actions(driver);
        action.click(element).perform();
    }

    public void doubleClick (WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void rightClick (WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void copyText () throws AWTException {
        Robot myRobot = new Robot();
        myRobot.keyPress(KeyEvent.VK_CONTROL);
        myRobot.keyPress(KeyEvent.VK_C);
        myRobot.keyRelease(KeyEvent.VK_CONTROL);
        myRobot.keyRelease(KeyEvent.VK_C);
    }
    public void doubleClickOnCoordinates () throws AWTException {

        Actions newact = new Actions(driver);
        //newact.moveByOffset();
    }

    public void selectByTextVisible (WebElement stationCodeLocator, String stationCode) {
        Select selectstationCode = new Select(stationCodeLocator);
        selectstationCode.selectByVisibleText(stationCode);
    }

    public void sendKeysThroughJS(String keysToSend, WebElement element) {

        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].value='"+ keysToSend +"';", element);
    }

    public void switchToFrameWithIndex(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public void pageEnd( ) throws InterruptedException {
        sleeping(1500);
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
    }

    public void pageUp( ) throws AWTException, InterruptedException {
        sleeping(2000);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_PAGE_UP);
        rb.keyRelease(KeyEvent.VK_PAGE_UP);

    }


    public void pageScroll(int wheelAmt ) throws AWTException, InterruptedException {
        sleeping(2000);
        Robot rb = new Robot();
        rb.mouseWheel(wheelAmt);

    }

    public void pressTab( ) throws AWTException {
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);

    }

    public void pressEnter( ) throws AWTException {
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }









    public void checkTheNotificationMessage () {

        try {
            WebElement notificationMessage = driver.findElement(By.className("ui-pnotify-text"));
            // check visibility with isDisplayed()
            if (notificationMessage.isDisplayed()){
                Date currentDate = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat();
                System.out.println("Notification message is displayed");
                System.out.println(notificationMessage.getText());
                String message = notificationMessage.getText().replace(" ", "_" );
                String screenCaptureName = message.concat("_" + dateFormat.format(currentDate));
                getScreenshot(screenCaptureName);

            }

        } catch (Exception NoSuchElementException) {
            //System.out.println("No Error Message Displayed");
            //throw new NoSuchElementException("No Error Message Displayed");
        }

    }

    /*Get Screen shot start*/
    public String getScreenshot (String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"/Screen_Capture_Result/"+testCaseName+".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir")+"/Screen_Capture_Result/"+testCaseName+".png";
    }

    public void addScreenshot(Scenario scenario) throws Exception {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", "screenshot");



    }
    /*Get Screen shot end*/



    public String getPropertyValue (String propertyKey) throws IOException {
        File src = new File(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        FileInputStream objfile = new FileInputStream(src);
        Properties obj = new Properties();
        obj.load(objfile);
        String propertyValue = obj.getProperty(propertyKey);
        return propertyValue;
    }
    public static void endSuiteBDD(String buildNumber, String module, String TestReportSenderMailAddress, String TestReportSenderMailPassword, String TestReportReceiverMailAddress) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm/");
        LocalDateTime now = LocalDateTime.now();
        ZipUtils.creatZipFile();
        TestReportSender.sendPDFReportByGMail(TestReportSenderMailAddress, TestReportSenderMailPassword, TestReportReceiverMailAddress, "Test Result at " + dtf.format(now)+ " On "+ module +" "+ buildNumber, "Dear Mr Vikasitha,");

    }

}
