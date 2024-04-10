package com.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Class_Listners implements IRetryAnalyzer{
	
	int count =1;
	int maxCount =3;

	public boolean retry(ITestResult result) {
		if(count<=maxCount) {
			count++;
			return true;
		}
		
		return false;
	}

}
