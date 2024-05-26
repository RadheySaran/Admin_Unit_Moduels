package Unit_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.DriverPage;

public class UPC extends DriverPage {
	
	@BeforeTest
	public void Browser_Login() throws Exception {
		browsers();
		validLogin();
	}
	
	@Test
	public void Create_UPC() throws Exception {
		
		waitForFiveSeconds();
		driver.findElement(By.xpath("//*[text()=\"Masters\"]")).click();
		System.out.println("==Masters==");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000);");
		 Thread.sleep(3000);
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		
//		waitForFiveSeconds();
//		WebElement product = driver.findElement(By.xpath("//*[text()=\"Products\"]"));
//		mouseHover(product);
//		product.click();
//		System.out.println("==Products==");
//		waitForFiveSeconds();
//		
//		
//		driver.findElement(By.xpath("//*[text()=\"UPC\"]")).click();
	}

}
