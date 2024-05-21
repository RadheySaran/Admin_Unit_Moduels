package Unit_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.DriverPage;
import com.utility.PropertyUtils;

public class Login_Page extends DriverPage {

	WebElement Email_Error = null;
	WebElement Password_Error = null;
	WebElement Invalid_Email = null;
	private static boolean isTextPrinted = false;
	
//	@BeforeTest
	public void Standards() throws Exception 
	{
		browsers();
		driver.get(PropertyUtils.readProperty("urlAdmin"));

	}

	@Test(dataProvider = "TestData")
	public void Login(String username, String password) throws Exception {
		browsers();
		driver.get(PropertyUtils.readProperty("urlAdmin"));

		// TEXT OF SIGN-IN PAGE AND PRINT ONLY ONCE
		if (!isTextPrinted) {
			WebElement Header = driver.findElement(By.xpath("//*[text()=\"Start your journey with us.\"]"));
			System.out.println(Header.getText());
			System.out.println("===========");

			WebElement Welcome_Msg = driver
					.findElement(By.xpath("//*[@class=\"md:text-base xlg:text-lg font-normal mb-4\"]"));
			System.out.println(Welcome_Msg.getText());
			System.out.println("===========");

			WebElement text = driver
					.findElement(By.xpath("//*[@class=\"auth-right-child-container p-10 flex flex-col h-full\"]"));
			System.out.println(text.getText());
			isTextPrinted = true; // Update flag to indicate text has been printed
		}
		
		System.out.println(driver.getCurrentUrl()+" url of Admin Portal");

		WebElement img = driver.findElement(By.xpath("//img"));
		System.err.println(img.isDisplayed() + " = Logo is displaying on SignIn Page");

		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);	
		driver.findElement(By.xpath("//*[text()=\"Sign in\"]")).click();

		try {
			Email_Error = driver.findElement(By.xpath("//*[text()=\"Email is required\"]"));// when email is not entered
		} catch (Exception e) {
			System.out.println("Email Entered.");
		}

		try {
			Invalid_Email = driver.findElement(By.xpath("//*[text()='Invalid email address']"));// entered but not valid
			System.err.println(driver.findElement(By.xpath("//*[text()='Invalid email address']")).getText());
		} catch (Exception e) {
			System.err.println("Entered Email is Valid");
		}

		try {
			Password_Error = driver.findElement(By.xpath("//*[text()=\"Password is required\"]"));// when password is not entered
		    
		} catch (Exception e) {
			System.out.println("Password Entered.");
		}

		if (Email_Error != null) {
			System.out.println("[" + Email_Error.getText() + "]");// Email is required error msg
		}
		if (Password_Error != null) {
			System.out.println("[" + Password_Error.getText() + "]");// Password is required error msg
		}

		// CUSTOMER MANAGEMENT TEXT
		try {
			driver.findElement(By.xpath("//*[text()=\"Customer Management\"]"));
			System.err.println(" ===User Is Sucessefully on Customer Management Page=== ");
		} catch (Exception e) {
			System.err.println(" ===LOGIN UNSECCESSFUL=== ");

		}

	}

	@Test
	public void Velidate() {

		// FOR VALIDATE URL
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://staging-admin.avighnasteel.in/customer-management"; // Expected URL after login
		Assert.assertEquals(actualURL, expectedURL, "Login successful.");
		System.err.println("=========LOGIN SUCCESSFUL========");

		// FOR VALIDATE CUSOMER MANAGEMENT TEXT
		WebElement Actual_Cstmr_Header = driver.findElement(By.xpath("//*[text()=\"Customer Management\"]"));
		String Actua_Header = Actual_Cstmr_Header.getText();
		System.out.println("[" + Actua_Header + "]");
		String Expcted_Header = "Customer Management";
		Assert.assertEquals(Actua_Header, Expcted_Header);

		// AVIGHNA LOGO ON CUSTOMER PAGE
		WebElement logo = driver.findElement(By.xpath("//img"));
		System.err.println(logo.isDisplayed() + " = Logo is displaying customer page logo");

	}

	@DataProvider(parallel = false)
	public Object[][] TestData() {
		Object[][] data = new Object[][] {
//			    { "Admin@abainfotech.com", "Admin@1234" }, // valid
				{ "Admin@abainfotech.com", "admin" },
//				{ "Admin", "Admin@1234" },
//				{ "", "Admin@1234" },
//				{ "Admin@abainfotech.com", "" }, 
//				{ "", "" }, 
//				{ "Admin@abainfotech.com", "" }

		};
		return data;
	}

}
