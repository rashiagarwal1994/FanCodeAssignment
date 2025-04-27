package com.fancode.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath= "./target/ExtentReport.html";
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
            htmlReporter.config().setDocumentTitle("FanCode API Automation");
            htmlReporter.config().setReportName("FanCode ToDo Validation");
            htmlReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Execution Type", "Test");
            extent.setSystemInfo("Environment", "Demo");
            extent.setSystemInfo("Framework", "RestAssured + TestNG");
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        return getInstance().createTest(testName);
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
