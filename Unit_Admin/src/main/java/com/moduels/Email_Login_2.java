
package com.moduels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.utility.PropertyUtils;

public class Email_Login_2 extends BaseClass {

//	@Override
//	public void waitForFiveSeconds() {
//		super.waitForFiveSeconds();
//	}

	public Email_Login_2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// customer name
	@FindBy(xpath = "(//*[@class=\"searchIcon-0-2-4 flex items-center cursor-pointer border p-2 rounded\"])[1]")
	WebElement custName;

	// lououtButton
	@FindBy(xpath = "//*[text()=\"Logout\"]")
	WebElement logoutButton;

	// GUEST
	@FindBy(xpath = "(//*[text()='Guest'])[1]")
	WebElement newUser;

	// Login Via Email
	@FindBy(xpath = "//*[text()=\"Or Login via \"]")
	WebElement emailLogin;

	// Email
	@FindBy(xpath = "//*[@id=\":rr:\"]")
	WebElement email;

	// password
	@FindBy(xpath = "//*[@id=\":rt:\"]")
	WebElement password;

	// login Button
	@FindBy(xpath = "//*[@type=\"submit\"]")
	WebElement login;

	public void validLogin(String nam, String pass) {
		waitForFiveSeconds();
		custName.click();
		waitForFiveSeconds();
		logoutButton.click();
		waitForFiveSeconds();
		newUser.click();
		waitForFiveSeconds();
		emailLogin.click();
		waitForFiveSeconds();
		email.sendKeys(nam);
		password.sendKeys(pass);
		waitForFiveSeconds();
		login.click();
	}

}
