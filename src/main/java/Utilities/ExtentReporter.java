package Utilities;

import Base.Browser_Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReporter extends Browser_Base {

    public static ExtentReports getReportObj() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm/");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now) + ": Test suite started ");

        String path = System.getProperty("user.dir") + "/Extent_Reports/Test_Result.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("RyanAir Test Result");
        reporter.config().setDocumentTitle("RyanAir Test Result");
        reporter.config().setProtocol(Protocol.HTTPS);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.getStats();
        return extent;

    }

}
