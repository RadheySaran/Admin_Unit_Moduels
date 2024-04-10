package com.moduels;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class Email_Login_Cust extends BaseClass {

	@Override
	public void waitForFiveSeconds() {
		super.waitForFiveSeconds();
	}

	public Email_Login_Cust(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// customer name
	@FindBy(xpath = "(//*[@class=\"searchIcon-0-2-4 flex items-center cursor-pointer border p-2 rounded\"])[1]")
	WebElement custName;

	// Login Via Email
	@FindBy(xpath = "//*[text()=\"Or Login via \"]")
	WebElement emailLogin;

	@FindBy(xpath = "//*[@id=\":rn:\"]")
	WebElement email;

	// password
	@FindBy(xpath = "//*[@id=\":rp:\"]")
	WebElement password;

	// login Button
	@FindBy(xpath = "//*[@type=\"submit\"]")
	WebElement login;

	public void Login(String mail, String pswrd) {
		custName.click();
		waitForFiveSeconds();
		emailLogin.click();
		waitForFiveSeconds();
		email.sendKeys(mail);
		password.sendKeys(pswrd);
		waitForFiveSeconds();
		login.click();
		
		
		
	}

}
