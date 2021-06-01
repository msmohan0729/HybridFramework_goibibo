package com.goibibo.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.pages.HomePage;
import com.goibibo.qa.pages.HotelSearchPage;
import com.goibibo.qa.util.TestUtil;

public class Scenario4_SearchAHotelInOotyAndApplyFilter extends TestBase{
	TestUtil testUtil;
	Scenario4_SearchAHotelInOotyAndApplyFilter searchAHotelInOotyAndApplyFilter;
	HomePage homePage;
	HotelSearchPage hotelSearchPage;
	
	public Scenario4_SearchAHotelInOotyAndApplyFilter() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		searchAHotelInOotyAndApplyFilter = new Scenario4_SearchAHotelInOotyAndApplyFilter();
		homePage = new HomePage();
	}
	
	@Test
	public void testCases() {
		hotelSearchPage = homePage.clickForHotelBooking();
		hotelSearchPage.searchHotels();
		hotelSearchPage.applyFilter();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
