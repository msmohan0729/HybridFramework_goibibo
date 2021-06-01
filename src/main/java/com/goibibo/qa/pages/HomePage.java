package com.goibibo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goibibo.qa.base.TestBase;

public class HomePage extends TestBase{
	@FindBy(xpath = "//a[@class='gi-header-logo__home']")
	WebElement goibiboLogo;
	
	@FindBy(linkText = "Flights")
	WebElement flightsMenu;
	
	@FindBy(linkText = "Hotels")
	WebElement hotelsMenu;
	
	@FindBy(className = "login__tab gotrible")
	WebElement loginButton;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public HotelSearchPage clickForHotelBooking() {
		hotelsMenu.click();
		return new HotelSearchPage();	
	}
	
}
