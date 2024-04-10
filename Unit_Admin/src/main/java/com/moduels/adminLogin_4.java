package com.moduels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class adminLogin_4 extends BaseClass {

//	@Override
//	public void waitForFiveSeconds() {
//		super.waitForFiveSeconds();
//	}
	

	public adminLogin_4(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement email;

	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement pas;

	@FindBy(xpath = "//*[text()=\"Sign in\"]")
	WebElement SignIn;

	public void adminLogin(String emailUser, String passw) {
		waitForFiveSeconds();
		email.sendKeys(emailUser);
		pas.sendKeys(passw);
		waitForFiveSeconds();
		SignIn.click();
	}

}
