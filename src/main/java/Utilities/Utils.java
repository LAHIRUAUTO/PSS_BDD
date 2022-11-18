package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;


public class Utils extends Browser_Base{

    //Implicit Wait start
    @BeforeMethod
    public static void implicitwait () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    //Implicit Wait end

    //Explicit Wait ElementVisible
    public void explicitWaitElementVisible(WebElement element) {
        WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitwait.until(ExpectedConditions.visibilityOf(element ));

    }

    //Explicit Wait ElementClickable
    public void explicitWaitElementClickable(WebElement element) {
        WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(20));
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

    public void sleeping (int miliSeconds) throws InterruptedException {
        Thread.sleep(miliSeconds);
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

    public void selectByTextVisible (WebElement stationCodeLocator, String stationCode) {
        Select selectstationCode = new Select(stationCodeLocator);
        selectstationCode.selectByVisibleText(stationCode);
    }

    public void scrollDown ( ) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
    }

    public void scrollUp ( ) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)", "");
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

    public static void sendKeysThroughJS(String keysToSend, WebElement element) {

        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].value='"+ keysToSend +"';", element);
    }

    public void switchToFrameWithIndex(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public void switchToFrameWithName(String frameName) {
        driver.switchTo().frame(frameName);
    }

    public void switchToFrameWithWebElement(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }





    public void appPropertyAccess () throws IOException {
        //Load Property File
        File src = new File(System.getProperty("user.dir") + "/App.properties");
        FileInputStream objfile = new FileInputStream(src);
        Properties obj = new Properties();
        obj.load(objfile);
        String setProjectPath = obj.getProperty("ProjectPath");

    }



    /*Get Screen shot start*/
    public String getScreenshot (String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"/Screen_Capture_Result/"+testCaseName+".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir")+"/Screen_Capture_Result/"+testCaseName+".png";
    }
    /*Get Screen shot end*/


    @Parameters ({"buildNumber", "Module", "TestReportSenderMailAddress", "TestReportSenderMailPassword", "TestReportReceiverMailAddress"})
    @AfterSuite
    public static void endSuite(String buildNumber, String module, String TestReportSenderMailAddress, String TestReportSenderMailPassword, String TestReportReceiverMailAddress) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm/");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        ZipUtils.creatZipFile();
        TestReportSender.sendPDFReportByGMail(TestReportSenderMailAddress, TestReportSenderMailPassword, TestReportReceiverMailAddress, "Test Result at " + dtf.format(now)+ " On "+ module +" "+ buildNumber, "Dear Mr Vikasitha,");
    }
    //1Slite0614









}
