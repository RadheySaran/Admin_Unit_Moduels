package com.moduels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Lead_5 extends BaseClass{
	
//	@Override
//	public void waitForFiveSeconds() {
//		super.waitForFiveSeconds();
//	}
	
	public Lead_5(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//*[text()='Lead Management'])[1]")
	WebElement LeadManagement;
	
	@FindBy(xpath = "(//*[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeMedium text-secondary cursor-pointer css-i4bv87-MuiSvgIcon-root\"])[1]")
	WebElement eyeIcon;
	
	@FindBy(xpath = "//*[text()=\"Quotation\"]")
	WebElement quotation;
	
	@FindBy(xpath = "//*[text()=\"Create Quotation\"]")
	WebElement CretQuotation;
	
	
	
	public void Quotation()
	{
		waitForFiveSeconds();
		LeadManagement.click();
		waitForFiveSeconds();
		eyeIcon.click();
		waitForFiveSeconds();
		quotation.click();
		waitForFiveSeconds();
		CretQuotation.click();
	}

}
