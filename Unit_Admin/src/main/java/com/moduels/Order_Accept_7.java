package com.moduels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Order_Accept_7 extends BaseClass{
	
	public Order_Accept_7(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//*[@class=\"searchIcon-0-2-4 flex items-center cursor-pointer border p-2 rounded\"])[1]")
	WebElement custName;
	
	@FindBy(xpath = "//*[text()=\"Request\"]")
	WebElement request;
	
//	@FindBy(xpath = "//*[text()=\"Standard\"]")
//	WebElement Standard;
	
	
	@FindBy(xpath = "(//*[text()=\"Quotations\"])[3]")
	WebElement quotations;
	
	@FindBy(xpath = "(//*[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeMedium text-secondary cursor-pointer m-auto css-i4bv87-MuiSvgIcon-root\"])[1]")
	WebElement eyeIcon;
	
	
	@FindBy(xpath = "(//*[text()=\"Accept\"])[1]")
	WebElement acceptQtsn;
	
	

	public void quotsnAccept() {
	    waitForFiveSeconds();
		custName.click();
		waitForFiveSeconds();
		request.click();
		waitForFiveSeconds();
		quotations.click();
		waitForFiveSeconds();
		eyeIcon.click();
		waitForFiveSeconds();
		acceptQtsn.clear();
		
	}
	

}
