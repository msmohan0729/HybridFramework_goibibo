package com.goibibo.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.pages.HomePage;
import com.goibibo.qa.pages.HotelSearchPage;
import com.goibibo.qa.util.TestUtil;

public class Scenario1_SearchAHotelForOneAdult extends TestBase{
	TestUtil testUtil;
	Scenario1_SearchAHotelForOneAdult searchAHotelForOneAdult;
	HomePage homePage;
	HotelSearchPage hotelSearchPage;
	
	public Scenario1_SearchAHotelForOneAdult() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		searchAHotelForOneAdult = new Scenario1_SearchAHotelForOneAdult();
		homePage = new HomePage();
	}
	
	@Test
	public void testCases() {
		hotelSearchPage = homePage.clickForHotelBooking();
		hotelSearchPage.searchHotels();
		hotelSearchPage.displayHotelsName();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
