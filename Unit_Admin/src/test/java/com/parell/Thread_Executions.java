package com.parell;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Thread_Executions {
	
	@Test(dataProvider = "TestData")
	public void login(String username,String password) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
	   System.out.println( driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).isDisplayed());
	   driver.quit();
	}
	// to run the test parellel make it true
	
	@DataProvider(parallel = false)
	public Object[][] TestData() {
		Object[][]data = new Object[][] {
			{"Admin","admin123"},
			{"Admin","admin"},
			{"Admin","admin321"},
			{"Admin123","admin"},
			{"Admin","admin123"},
			{"Admin","admin"},
			{"Admin","admin321"},
			{"Admin123","admin"},
			{"Admin","admin123"},
			{"Admin","admin"},
			{"Admin","admin321"},
			{"Admin123","admin"}

			
		};
		return data;

}
}