package Unit_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.DriverPage;

import java.util.List;

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

		//Click on Master

	    driver.findElement(By.xpath("//*[text()=\"Masters\"]")).click();
	    System.out.println("Master");
	    dragPageToBottom();
	    dragPageToBottom();
	    waitForFiveSeconds();

		// Click On Product On Master

	    driver.findElement(By.xpath("//*[text()=\"Products\"]")).click();
	    dragPageToBottom();
	    System.out.println("Product");
	    waitForFiveSeconds();

		// Click on Standard/Grade on Product(Side Bar)

	    driver.findElement(By.xpath("//*[text()=\"Standard/Grade\"]")).click();
	    System.out.println("Standard/Grade");
	    waitForFiveSeconds();
	    System.out.println(driver.getCurrentUrl());
	    waitForFiveSeconds();

		//Click on the Grade

	    driver.findElement(By.xpath("//*[text()=\"Grade\"]")).click();
		System.out.println("Grade");
		waitForFiveSeconds();
		System.out.println(driver.getCurrentUrl());
		dragPageToBottom();
		waitForFiveSeconds();
		Pagination25();

		List<WebElement> Header = driver.findElements(By.xpath("//*[@class=\"h-12 text-center\"]"));

		for (WebElement tableData : Header) {
			System.out.println(tableData.getText());
		}


		//print all the data in the list

		List<WebElement> Element = driver.findElements(By.xpath("//*[@class=\"catalogue-details self-stretch flex flex-row p-[0.75rem] items-center justify-start gap-[0.75rem] border-b border-gray-300 \"]"));
		int rowCount = 0;
		for (WebElement listdata : Element) {
			System.out.println(listdata.getText() + "\t");
			rowCount++;
		}
		System.err.println("Total number of rows: " + rowCount);
	}

	}
		

