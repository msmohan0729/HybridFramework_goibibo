package com.goibibo.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.pages.HomePage;
import com.goibibo.qa.pages.HotelPage;
import com.goibibo.qa.pages.HotelSearchPage;
import com.goibibo.qa.util.TestUtil;

public class Scenario3_SearchAHotelAndSelectFirstHotel extends TestBase{
	TestUtil testUtil;
	Scenario3_SearchAHotelAndSelectFirstHotel searchAHotelAndSelectFirstHotel;
	HomePage homePage;
	HotelSearchPage hotelSearchPage;
	HotelPage hotelPage;
	
	public Scenario3_SearchAHotelAndSelectFirstHotel() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		searchAHotelAndSelectFirstHotel = new Scenario3_SearchAHotelAndSelectFirstHotel();
		homePage = new HomePage();
		hotelPage = new HotelPage();
	}
	
	@Test
	public void testCases() {
		hotelSearchPage = homePage.clickForHotelBooking();
		hotelSearchPage.searchHotels();
		hotelSearchPage.selectFirstHotel();
		testUtil.switchWindows();
		hotelPage.getRoomDetails();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		hotelSearchPage.closeAllWindows();
	}
}
