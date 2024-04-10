package com.moduels;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class OTP_1 extends BaseClass {

	// wait for 5 second
//	@Override
//	public void waitForFiveSeconds() {
//		super.waitForFiveSeconds();
//	}

	public OTP_1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[text()='Guest'])[1]")
	WebElement newUser;

	@FindBy(xpath = "//*[@id=\":rl:\"]")
	WebElement mobileNo;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement getOTP;

	@FindBy(xpath = "//*[@type=\"submit\"]")
	WebElement submit;

	@FindBy(xpath = "(//*[@class =\"searchIcon-0-2-4 flex items-center cursor-pointer border p-2 rounded\"])[1]")
	WebElement userName;

	public Email_Login_2 enterOTPManually(String num) {
 
		waitForFiveSeconds();
		newUser.click();
		waitForFiveSeconds();
		mobileNo.sendKeys(num);
		waitForFiveSeconds();
		getOTP.click();

		// Adding an implicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the first textbox to be present
		WebElement firstTextBox = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text' and @maxlength='1'])")));

		Scanner sc = new Scanner(System.in);
		System.out.println("===PLEASE Enter OTP===");

		// for (int i = 1; i <= 4; i++) {
		// String xpathExpression = "(//input[@type='text' and @maxlength='1'])[" + i +
		// "]";
		String xpathExpression = "(//input[@type='text' and @maxlength='1'])";

		// Wait for the textbox to be clickable
		WebElement textBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));

		int entereOTP = sc.nextInt();
		textBox.sendKeys(String.valueOf(entereOTP));
		System.out.println("===ENTERED OTP ==" + entereOTP);
		submit.click();

		// }
		return new Email_Login_2(driver);

	}
}
