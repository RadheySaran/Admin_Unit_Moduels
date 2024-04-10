package Unit_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.DriverPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Page extends DriverPage {

	
	@Test(dataProvider = "TestData")
	public void Login(String username,String password) throws Exception
	{
		browsers();

		driver.get("https://staging-admin.avighnasteel.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[text()=\"Sign in\"]")).click();

	}
	
	@DataProvider(parallel = false)
	public Object[][] TestData() {
		Object[][]data = new Object[][] {
			{"Admin@abainfotech.com","Admin@1234"}, //valid
			{"Admin@abainfotech.com","admin"},
			{"Admin","Admin@1234"},
			{"","Admin@1234"},
			{"Admin@abainfotech.com",""}
			
		};
		return data;
	}
	
   //@Test
	public void Velidate()
	{
		String Actual_url = driver.getCurrentUrl();
		//System.out.println(Actual_url);
		String Expcted_url ="https://staging-admin.avighnasteel.in/";
		Assert.assertEquals(Actual_url, Expcted_url);
		
		WebElement img= driver.findElement(By.xpath("//img"));
		System.out.println(img.isDisplayed()+" = Logo is displaying");
	}

}
