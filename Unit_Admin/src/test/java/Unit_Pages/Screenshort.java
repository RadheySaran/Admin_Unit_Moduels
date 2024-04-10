package Unit_Pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshort {

	WebDriver driver;

	@Test
	public void Driver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}

	@AfterTest
	public void login_page() throws Exception {

		Thread.sleep(3000);

		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File("C:\\Users\\radhe\\git\\Admin_Unit_Moduels\\Unit_Admin\\ScreenShorts\\google.png"));

		System.out.println("Test Fail and ScreenSort Taken.......");

		
	}

}
