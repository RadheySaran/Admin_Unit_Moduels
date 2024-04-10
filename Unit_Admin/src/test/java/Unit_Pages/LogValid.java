package Unit_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.DriverPage;

public class LogValid extends DriverPage{
	


	@Test
	public void Login() throws Exception {
		browsers();

		driver.get("https://staging-admin.avighnasteel.in/");

		driver.findElement(By.name("email")).sendKeys("Admin@abainfotech.com");
		driver.findElement(By.name("password")).sendKeys("Admin@1234");
		driver.findElement(By.xpath("//*[text()=\"Sign in\"]")).click();

//		String Actual_url = driver.getCurrentUrl();
//		String Expcted_url = "https://staging-admin.avighnasteel.in/";
//		Assert.assertEquals(Actual_url, Expcted_url);
//
//		WebElement img = driver.findElement(By.xpath("//img"));
//		System.out.println(img.isDisplayed() + " = Logo is displaying");

	}

	
	

	 @Test
	public void Velidate() {
		String Actual_url = driver.getCurrentUrl();
		String Expcted_url = "https://staging-admin.avighnasteel.in/";
		Assert.assertEquals(Actual_url, Expcted_url);

		WebElement img = driver.findElement(By.xpath("//img"));
		System.out.println(img.isDisplayed() + " = Logo is displaying");
		
		//After login user should on the customer Managenet Page
		//String Exp_CustmrURL = "https://staging-admin.avighnasteel.in/customer-management";
	   System.out.println( driver.getCurrentUrl()+" url");
		
	}

}

