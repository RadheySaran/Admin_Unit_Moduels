package Unit_Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.DriverPage;

public class Login_Page extends DriverPage {

	WebElement Email_Error = null;
	WebElement Password_Error = null;
	private static boolean isTextPrinted = false;

	@Test(dataProvider = "TestData")
	public void Login(String username, String password) throws Exception {
		browsers();
		driver.get("https://staging-admin.avighnasteel.in/");

		// TEXT OF SIGN-IN PAGE
		// PRINT ONLY ONCE

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

		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);

		WebElement img = driver.findElement(By.xpath("//img"));
		System.err.println(img.isDisplayed() + " = Logo is displaying");

		driver.findElement(By.xpath("//*[text()=\"Sign in\"]")).click();

		try {
			Email_Error = driver.findElement(By.xpath("//*[text()=\"Email is required\"]"));
			// System.out.println("["+Email_Error.getText()+"]");
		} catch (Exception e) {
			System.out.println("Email Entered.");
		}

		try {
			Password_Error = driver.findElement(By.xpath("//*[text()=\"Password is required\"]"));
			// System.out.println(Password_Error.getText());
		} catch (Exception e) {
			System.out.println("Password Entered.");
		}

		if (Email_Error != null) {
			System.out.println("[" + Email_Error.getText() + "]");
		} else if (Password_Error != null) {
			System.out.println(Password_Error.getText());
		}

		// CUSTOMER MANAGEMENT TEXT
		try {
			driver.findElement(By.xpath("//*[text()=\"Customer Management\"]"));
			System.err.println(" ===User Is Sucessefully on Customer Management Page=== ");
		} catch (Exception e) {
			System.err.println(" ===User Is Not on Customer Management Page=== ");

		}

		WebElement Actual_Cstmr_Header = driver.findElement(By.xpath("//*[text()=\"Customer Management\"]"));
		String Actua_Header = Actual_Cstmr_Header.getText();
		System.out.println("[" + Actua_Header + "]");
		String Expcted_Header = "Customer Management";
		Assert.assertEquals(Actua_Header, Expcted_Header);

		// AVIGHNA LOGO ON CUSTOMER PAGE
		WebElement logo = driver.findElement(By.xpath("//img"));
		System.err.println(logo.isDisplayed() + " = Logo is displaying customer page logo");

	}

	@Test
	public void Velidate() {

		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://staging-admin.avighnasteel.in/customer-management"; // Expected URL after login
		Assert.assertEquals(actualURL, expectedURL, "Login successful.");
		System.err.println("=========LOGIN SUCCESSFUL========");

//	WebElement img = driver.findElement(By.xpath("//img"));
//	System.out.println(img.isDisplayed() + " = Logo is displaying");

	}

	@DataProvider(parallel = false)
	public Object[][] TestData() {
		Object[][] data = new Object[][] { 
//			    { "Admin@abainfotech.com", "Admin@1234" }, // valid
//				{ "Admin@abainfotech.com", "admin" },
//				{ "Admin", "Admin@1234" }, 
//				{ "", "Admin@1234" },
//				{ "Admin@abainfotech.com", "" }, 
				{ "", "" }, 
//				{ "Admin@abainfotech.com", "" }

		};
		return data;
	}

//	@Test
	public void ERROR_MSG() {
		try {
			WebElement Email_Error = driver.findElement(By.xpath("//*[text()=\"Email is required\"]"));
			System.out.println(Email_Error.getText());
		} catch (Exception e) {
			System.out.println("Email is required error message not found.");
		}

		try {
			WebElement Password_Error = driver.findElement(By.xpath("//*[text()=\"Password is required\"]"));
			System.out.println(Password_Error.getText());
		} catch (Exception e) {
			System.out.println("Password is  required error message not found.");
		}
	}

}
