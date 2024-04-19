package Unit_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.DriverPage;

public class Standard extends DriverPage {

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
		setScreen75();
		waitForFiveSeconds();
		driver.findElement(By.xpath("//*[text()=\"Masters\"]")).click();
		System.out.println("==Masters==");
		dragPageToBottom();
		waitForFiveSeconds();
		dragPageToBottom();
		WebElement product = driver.findElement(By.xpath("//*[text()=\"Products\"]"));
		mouseHover(product);
		product.click();
		System.out.println("==Products==");
		waitForFiveSeconds();
		dragPageToBottom();
		waitForFiveSeconds();
		driver.findElement(By.xpath("//*[text()=\"Standard/Grade\"]")).click();
		System.out.println("==Standard/Grade==");
		System.out.println(driver.getCurrentUrl());
		WebElement header = driver.findElement(By.xpath("//*[text()=\"Standard\"]"));
		System.err.println("=======" + header.getText() + "=====");

		driver.findElement(By.xpath(
				"//*[@class=\"MuiSelect-select MuiTablePagination-select MuiSelect-standard MuiInputBase-input css-1cccqvr\"]"))
				.click();
		driver.findElement(By.xpath("//*[text()=\"25\"]")).click();
		waitForFiveSeconds();

		List<WebElement> Header = driver.findElements(By.xpath("//*[@class=\"h-12 text-center\"]"));
		for (WebElement tableData : Header) {
			System.out.println(tableData.getText());
		}


		//print all the data in the list
		printAllData();
		

		// STATUS FILTERS
		WebElement filters = driver.findElement(By.xpath("//*[text()=\"All\"]"));
		filters.click();
		WebElement allFilters = driver
				.findElement(By.xpath("//*[@class=\"MuiList-root MuiList-padding MuiMenu-list css-r8u8y9\"]"));
		
		System.err.println(allFilters.getText());
		
		//ONLY ACTIVE STATUS
		WebElement ACTIVE =driver.findElement(By.xpath("//*[text()=\"ACTIVE\"]"));
		ACTIVE.click();
		System.out.println("ONLY ACTIVE STANDARDS");
		waitForFiveSeconds();
		printAllData();
		waitForFiveSeconds();
		
		
		//ONLY INACTIVE STATUS
		filters.click();
		waitForFiveSeconds();
		WebElement InACTIVE =driver.findElement(By.xpath("//*[text()=\"INACTIVE\"]"));
		InACTIVE.click();
		System.out.println("ONLY InACTIVE STANDARDS");
		waitForFiveSeconds();
		printAllData();
		navigateRefresh();
		waitForFiveSeconds();
		
		//Sort Filter
		WebElement DateDesc =driver.findElement(By.xpath("//*[@id=\"select-Sort\"]"));
		DateDesc.click();
		System.out.println("ONLY Descending Date");
		waitForFiveSeconds();
		printAllData();
		waitForFiveSeconds();
		//
		
	}

}
