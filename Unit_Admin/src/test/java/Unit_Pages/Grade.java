package Unit_Pages;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.DriverPage;

public class Grade extends DriverPage {

	@BeforeTest
	public void Browser_Login() throws Exception {
		browsers();
		validLogin();
	}
	
	@Test
	public void Standards() throws Exception {
		setScreen75();
		waitForFiveSeconds();
		setScreen75();
	    waitForFiveSeconds();
	    driver.findElement(By.xpath("//*[text()=\"Masters\"]")).click();
	    System.out.println("Master");
	    dragPageToBottom();
	    waitForFiveSeconds();
	    dragPageToBottom();
	    waitForFiveSeconds();
	    driver.findElement(By.xpath("//*[text()=\"Products\"]")).click();
	    dragPageToBottom();
	    System.out.println("Product");
	    waitForFiveSeconds();
	    driver.findElement(By.xpath("//*[text()=\"Standard/Grade\"]")).click();
	    System.out.println("Standard/Grade");
	    waitForFiveSeconds();
	    System.out.println(driver.getCurrentUrl());
	    waitForFiveSeconds();
	    driver.findElement(By.xpath("//*[text()=\"Grade\"]")).click();
		System.out.println("Grade");
		waitForFiveSeconds();
		System.out.println(driver.getCurrentUrl());

		driver.findElement(By.xpath("//*[text()=\"Add New \"]")).click();
		waitForFiveSeconds();
		System.out.println("Add New Grade");
		waitForFiveSeconds();
		System.out.println(driver.getCurrentUrl());
		waitForFiveSeconds();


	}
		
}
