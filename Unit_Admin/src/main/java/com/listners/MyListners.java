package com.listners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.base.DriverPage;

public class MyListners extends DriverPage implements ITestListener  {

	public void onTestStart(ITestResult result) {
		test= report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
	test.log(Status.PASS, "Testcase sucess with name:"+result.getName());	
		
	}

	public void onTestFailure(ITestResult result) {
	

		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,new File("C:\\Users\\radhe\\git\\Admin_Unit_Moduels\\Unit_Admin\\ScreenShorts\\google.png"));
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Test Fail and ScreenSort Taken.......");

	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Testcase skip with name:"+result.getName());		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {

		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		//TO SAVE DATA IN EXTENT REPORT
		
		
		
	}

}
