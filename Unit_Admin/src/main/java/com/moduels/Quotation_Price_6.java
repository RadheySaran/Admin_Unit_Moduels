package com.moduels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Quotation_Price_6 extends BaseClass {


	public Quotation_Price_6(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()=\"Choose SKU\"]")
	WebElement ChooseSKU;

	@FindBy(xpath = "(//*[@type=\"checkbox\"])[1]")
	WebElement SKU;

	@FindBy(xpath = "//*[text()=\"Close SKU\"]")
	WebElement CloseSKU;

	@FindBy(xpath = "(//input[@id=\"outlined-basic\"])[1]")
	WebElement quantity;

	@FindBy(xpath = "(//input[@id=\"outlined-basic\"])[2]")
	WebElement Sprice;

	@FindBy(xpath = "//*[@id=\"select\"]")
	WebElement packaging;

	@FindBy(xpath = "(//*[text()=\"Metal Packaging\"])[2]")
	WebElement packagingType;

	@FindBy(xpath = "(//*[@id=\"outlined-basic\"])[4]")
	WebElement WarehusPrice;

	@FindBy(xpath = "(//*[@id=\"outlined-basic\"])[5]")
	WebElement HndlngPrice;

	@FindBy(xpath = "(//*[@id=\"outlined-basic\"])[6]")
	WebElement PackChrge;

	@FindBy(xpath = "(//*[@id=\"outlined-basic\"])[7]")
	WebElement OthrChrge;

	@FindBy(xpath = "(//*[@id=\"outlined-basic\"])[8]")
	WebElement GST;

	@FindBy(xpath = "(//*[@id=\"outlined-basic\"])[9]")
	WebElement TCS;

	@FindBy(xpath = "//*[text()=\"Publish\"]")
	WebElement publs;

	public void setPrice(String a, String price, String wcharge, String Hprice, String packgCrge, String otCrge,
			String gst, String tcs) {
		waitForFiveSeconds();
		// dragPageToBottom();
		ChooseSKU.click();
		waitForFiveSeconds();
		SKU.click();
		waitForFiveSeconds();
		CloseSKU.click();
		waitForFiveSeconds();
		quantity.sendKeys(a);

		Sprice.sendKeys(price);
		waitForFiveSeconds();
		packaging.click();
		packagingType.click();
		waitForFiveSeconds();
		WarehusPrice.sendKeys(wcharge);
		HndlngPrice.sendKeys(Hprice);
		PackChrge.sendKeys(packgCrge);
		OthrChrge.sendKeys(otCrge);
		GST.sendKeys(gst);
		TCS.sendKeys(tcs);
		waitForFiveSeconds();
		System.out.println("==tcs==");
		dragPageToBottom();
		System.out.println("==down==");
		mouseHover(publs);
		publs.click();
		System.out.println("not clicked");
		

	}

}
