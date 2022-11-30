package utils;


import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element ));
    }

    public void explicitWaitFrameVisible (int frameIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
    }

    public void sleeping (int miliSeconds) throws InterruptedException {
        Thread.sleep(miliSeconds);
    }



    //Explicit Wait ElementClickable
    public void explicitWaitElementClickable(WebElement element) {
        WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitwait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void explicitWaitElementInvisibilityOf(WebElement element) {
        WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitwait.until(ExpectedConditions.invisibilityOf(element));

    }

    //Fluent Wait ElementVisible
    public void fluentWaitElementClickable(WebElement element) {
        Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void fluentWaitElementInvisibilityOf(WebElement element) {
        Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(element));
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
        sleeping(2000);
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        sleeping(2000);
    }

    public void pageUp( ) throws AWTException, InterruptedException {
        sleeping(2000);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_PAGE_UP);
        rb.keyRelease(KeyEvent.VK_PAGE_UP);
        sleeping(2000);

    }


    public void pageScroll(int wheelAmt ) throws AWTException, InterruptedException {
        sleeping(2000);
        Robot rb = new Robot();
        rb.mouseWheel(wheelAmt);
        sleeping(2000);

    }

    public void pressTab( ) throws AWTException, InterruptedException {
        sleeping(2000);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        sleeping(2000);


    }

    public void pressEnter( ) throws AWTException, InterruptedException {
        sleeping(2000);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        sleeping(2000);

    }


    /*Get Screen shot start*/

    public void addScreenshot(Scenario scenario) throws Exception {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", "screenshot");
    }
    /*Get Screen shot end*/

    public static void endSuiteBDD(String buildNumber, String module, String TestReportSenderMailAddress, String TestReportSenderMailPassword, String TestReportReceiverMailAddress) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm/");
        LocalDateTime now = LocalDateTime.now();
        ZipUtils.creatZipFile();
        TestReportSender.sendPDFReportByGMail(TestReportSenderMailAddress, TestReportSenderMailPassword, TestReportReceiverMailAddress, "Test Result at " + dtf.format(now)+ " On "+ module +" "+ buildNumber, "Dear Mr Vikasitha,");

    }

    public void eraseFileContent (String fileName) throws IOException {
        FileWriter fwOb = new FileWriter(fileName, false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }

}
