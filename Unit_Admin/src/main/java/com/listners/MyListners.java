package com.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.DriverPage;
import com.utility.DriverUtils;

public class MyListners extends DriverPage implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test Start Running.......");
		test = report.createTest(result.getName()+"login page testing...");
		

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Testcase sucess with name:" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Testcase fail with name:"+result.getName());		
		String path=DriverUtils.captureScreenshot(result.getName());
		test.addScreenCaptureFromPath(path);	
		System.out.println("test case fails and screenshort taken........");
			
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Testcase skip with name:" + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		System.out.println("execution started....");

	}

	public void onFinish(ITestContext context) {
		report.flush();
		// TO SAVE DATA IN EXTENT REPORT

	}

}
