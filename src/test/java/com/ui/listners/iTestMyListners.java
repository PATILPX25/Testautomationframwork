package com.ui.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.pages.HomePage;
import com.utility.ExtentReportUtility;

public class iTestMyListners implements ITestListener {
//	ExtentSparkReporter sparkReport;
//	ExtentReports extent;
//	ExtentTest test;
	HomePage hp;

	public void onTestStart(ITestResult result) {


		ExtentReportUtility.initReports();
		ExtentReportUtility.createExtentTest(result.getMethod().toString());

	}

	public void onTestSuccess(ITestResult result) {

		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().toString() + " " + "Failed");
	}

	public void onTestFailure(ITestResult result) {
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().toString() + " " + "Failed");
	}

	public void onFinish(ITestContext context) {
		ExtentReportUtility.flushReport();
	}

}
