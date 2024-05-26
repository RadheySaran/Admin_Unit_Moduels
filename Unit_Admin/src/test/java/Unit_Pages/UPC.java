package Unit_Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.DriverPage;

public class UPC extends DriverPage {

	@BeforeTest
	public void Browser_Login() throws Exception {
		browsers();
		validLogin();
		setScreen75();
		setScreen75();
	}

	@Test
	public void Create_UPC() throws Exception {

		waitForFiveSeconds();
		driver.findElement(By.xpath("//*[text()=\"Masters\"]")).click();
		System.out.println("==Masters==");

		driver.findElement(By.xpath("//*[text()=\"Products\"]")).click();
		System.out.println("clicked");

		//waitForFiveSeconds();
		driver.findElement(By.xpath("//*[text()=\"UPC\"]")).click();

		driver.findElement(By.xpath("//*[text()=\"Add UPC\"]")).click();

		
		// Select Super		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement element = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.id("Select Super Category")));
//
//		// Scroll the element into view
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//
//		// Use JavaScript to click the element
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		
            
//
		
            WebElement element = driver.findElement(By.id("Select Super Category"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", element);
      //      js.executeScript("arguments[1].value='Carbon Flat Hot Rolled';",element);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement inputElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Select Super Category")));
            js.executeScript("arguments[0].value='Carbon Flat Hot Rolledddddddddddd';", inputElement);
            
           
          
//
//       
	}

}
