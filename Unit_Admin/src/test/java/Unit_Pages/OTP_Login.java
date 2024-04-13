package Unit_Pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.base.DriverPage;
import com.utility.PropertyUtils;

public class OTP_Login extends DriverPage {
	
	
	@Test
	public void OTP() throws Exception
	{
		browsers();
		driver.get(PropertyUtils.readProperty("urlAdmin"));
		
		driver.findElement(By.xpath("//*[text()=\"Or Login via \"]")).click();
		driver.findElement(By.xpath("//*[text()=\"Or Login via \"]")).sendKeys(PropertyUtils.readProperty("number"));
		driver.findElement(By.xpath("//*[text()=\"Get OTP\"]")).click();
		
		
	}

}
