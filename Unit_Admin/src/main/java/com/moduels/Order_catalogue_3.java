package com.moduels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Order_catalogue_3 extends BaseClass {
//
//	@Override
//	public void waitForFiveSeconds() {
//		super.waitForFiveSeconds();
//	}

	public Order_catalogue_3(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//*[text()=\"View All\"])[1]")
	WebElement viewAll;

	
	@FindBy(xpath = "(//*[@class=\"grid gap-y-3 pb-2 cursor-pointer\"])[3]")
	WebElement PPGI;

	@FindBy(xpath = "(//*[text()=\"Get a best price\"])[1]")
	WebElement getPrice;
	
	@FindBy(xpath = "(//button[text()=\"Add to Cart\"])[1]")
	WebElement AddToCart;
	
	@FindBy(xpath = "(//*[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-78trlr-MuiButtonBase-root-MuiIconButton-root\"])[1]")
	WebElement CartButton;
	
	@FindBy(xpath = "(//*[text()=\"Request a quotation\"])[1]")
	WebElement ReqstQuotation;

	public void order()  {
		waitForFiveSeconds();
		viewAll.click();
		System.out.println("viewAll");
		waitForFiveSeconds();
		PPGI.click();
		dragPageToBottom();
		waitForFiveSeconds();
		System.out.println("ppgi");
		waitForFiveSeconds();
		getPrice.click();
		waitForFiveSeconds();
		System.out.println("getprice");
		dragPageToBottom();
		waitForFiveSeconds();
		AddToCart.click();
		waitForFiveSeconds();
		System.out.println("addTo Cart");
		CartButton.click();
		waitForFiveSeconds();
		System.out.println("cartbutton");
		waitForFiveSeconds();
		ReqstQuotation.click();
		System.out.println("reqstQuotations");
	}

}
