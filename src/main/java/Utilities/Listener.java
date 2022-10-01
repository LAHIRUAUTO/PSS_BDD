package Utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;


public class Listener extends TestListenerAdapter {
    static ExtentTest test;
    static ExtentReports report;

    public void onTestStart(ITestResult result) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm/");
        LocalDateTime now = LocalDateTime.now();
        Listener( result.getName()+ " Test Case Execution Started at: " + dtf.format(now));

    }



    public void onTestSuccess(ITestResult result) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm/");
        LocalDateTime now = LocalDateTime.now();
        Listener( result.getName()+ " Test Case Execution Succeed at: " + dtf.format(now));

    }

    public void onTestFailure(ITestResult result) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm/");
        LocalDateTime now = LocalDateTime.now();
        Listener( result.getName()+ " Test Case Execution Failed at: " + dtf.format(now));

    }

    public void onTestSkipped(ITestResult result) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm/");
        LocalDateTime now = LocalDateTime.now();
        Listener( result.getName()+ " Test Case Execution Skipped at: " + dtf.format(now));

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }


    public void onFinish(ITestContext context) {

    }

    private void Listener(String methodName) {
        System.out.println(methodName);
    }
}
