package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	// methods
		public static Robot re = null;
		public static Alert al = null;
		public static Actions ac = null;
		public static Select se = null;

	
	
	Logger log = Logger.getLogger(DriverPage.class);
	
	private static boolean isBrowserPropertyLogged = false; // Flag to track if browser property has been logged

	public void browsers() throws Exception {
		
		 if (!isBrowserPropertyLogged) { // Check if browser property has been logged
	            System.out.println("Reading property file for browser");
	            log.info("Reading property file for browser");
	            isBrowserPropertyLogged = true; // Update flag to indicate browser property has been logged
	        }
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
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		

	}
	
	public void clickElementWithWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		clickableElement.click();
	}
	
	public void validLogin() throws Exception {
		driver.get(PropertyUtils.readProperty("urlAdmin"));
		driver.findElement(By.name("email")).sendKeys("Admin@abainfotech.com");
		driver.findElement(By.name("password")).sendKeys("Admin@1234");	
		driver.findElement(By.xpath("//*[text()=\"Sign in\"]")).click();

	}
	
	// Generate Reports
		public void reportInit() {
			report = new ExtentReports();
			spakr = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/ExtentReports.html");
			report.attachReporter(spakr);
			
		}
		
		//STE SCREEN RESULULATION TO 75%
		public void setScreen75() throws Exception{
			re = new Robot();
			re.keyPress(KeyEvent.VK_CONTROL);
			re.keyPress(KeyEvent.VK_SUBTRACT);
			re.keyRelease(KeyEvent.VK_SUBTRACT);
			re.keyRelease(KeyEvent.VK_CONTROL);
		}
		
		public void printAllData() {
			List<WebElement> Element = driver.findElements(By.tagName("tr"));
			int rowCount = 0;
			for (WebElement listdata : Element) {
				System.out.println(listdata.getText() + "\t");
				rowCount++;
			}
			System.err.println("Total number of rows: " + rowCount);
		}

		// Set Pagination to 25

	 public void Pagination25(){
		 WebElement pagination = driver.findElement(By.xpath("//*[@name='pageSize']"));
		 Select dropdown = new Select(pagination);
		 dropdown.selectByVisibleText("25");
	 }

			
		
		/* To Mouse Hover */
		public void mouseHover(WebElement element) {
			ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		}

		// scrollTo Element and Click
		public void scrollToElementAndClick(WebElement element) {
			scrollToElementAndClick(element);
			element.click();
			log.info(element);
		}
		
		// Navigate to other URL
		public void navigateRefresh() {
			driver.navigate().refresh();;
		}
		
		// To move the page down
		public void dragPageToBottom() {
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.ARROW_DOWN);
			actions.keyDown(Keys.ARROW_DOWN);
			actions.keyDown(Keys.ARROW_DOWN);
			actions.keyDown(Keys.ARROW_DOWN);
			actions.keyDown(Keys.ARROW_DOWN).build().perform();
			actions.keyUp(Keys.ARROW_DOWN).build().perform();

		}
		
		public void waitForFiveSeconds() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
		
	public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("WebDriver quit.");
        }
    }
}
