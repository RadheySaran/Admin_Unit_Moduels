package com.parell;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parell_Excection {
	
	@Test(dataProvider = "TestData")
	public void login(String username,String password) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://staging-admin.avighnasteel.in/");
		Thread.sleep(4000);
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[text()=\"Sign in\"]")).click();
//		Thread.sleep(4000);
//	   System.out.println( driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).isDisplayed());
//	   driver.quit();
	}
	
	@DataProvider(parallel = true)
	public Object[][] TestData() {
		Object[][]data = new Object[][] {
			{ "Admin@abainfotech.com", "Admin@1234" }, // valid
			{ "Admin@abainfotech.com", "admin" },
			{ "Admin", "Admin@1234" },
			{ "", "Admin@1234" },
			{ "Admin@abainfotech.com", "" }, 
			{ "", "" }, 
			{ "Admin@abainfotech.com", "" }
		};
		return data;
		}
	}

