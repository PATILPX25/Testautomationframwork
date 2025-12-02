package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	

    public static void initReports() {
        if (extentReports == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/extent-report.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }
    }

	
	public static void setUpSparkReport(String reportName) {
		ExtentSparkReporter sparkReport = new ExtentSparkReporter((System.getProperty("user.dir")) + "/reports/"+ reportName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReport);
	}
	
	public static void createExtentTest(String testName)
	{
		ExtentTest test = extentReports.createTest(testName);
		extentTest.set(test);
		
	}
	
	public static ExtentTest getTest() {
		return extentTest.get();
	}
	
	public static void flushReport()
	{
		extentReports.flush();
	}

}
