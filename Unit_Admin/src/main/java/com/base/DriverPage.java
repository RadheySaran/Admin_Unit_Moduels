package com.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverPage {

	public static WebDriver driver;
	public static ExtentTest test = null;
	public static ExtentReports report = null;
	public static ExtentSparkReporter spakr = null;
	Logger log = Logger.getLogger(DriverPage.class);

	public void browsers() throws Exception {
		System.out.println("Reading property file for browser");
		log.info("Reading property file for browser");
		String browserName = PropertyUtils.readProperty("browser");

		// IF THERE IS CHROME
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		// IF THERE IS FIREFOX
		if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// IF THERE IS EDGE
		if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		

	}
	public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("WebDriver quit.");
        }
    }
}
