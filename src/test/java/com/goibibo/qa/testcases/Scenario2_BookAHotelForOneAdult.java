package com.goibibo.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.pages.HomePage;
import com.goibibo.qa.pages.HotelPage;
import com.goibibo.qa.pages.HotelSearchPage;
import com.goibibo.qa.util.TestUtil;

public class Scenario2_BookAHotelForOneAdult extends TestBase{
	TestUtil testUtil;
	Scenario2_BookAHotelForOneAdult bookAHotelForOneAdult;
	HomePage homePage;
	HotelSearchPage hotelSearchPage;
	HotelPage hotelPage;
	
	public Scenario2_BookAHotelForOneAdult() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		bookAHotelForOneAdult = new Scenario2_BookAHotelForOneAdult();
		homePage = new HomePage();
	}
	
	@Test
	public void testCases() {
		hotelSearchPage = homePage.clickForHotelBooking();
		hotelSearchPage.searchHotels();
		hotelSearchPage.displayHotelsName();
		hotelPage = hotelSearchPage.selectHotel(prop.getProperty("hotelname"));
		
		if((hotelPage.getPageTitle()).contains(prop.getProperty("hotelname"))) {
			hotelPage.selectRooms();
			hotelPage.enterPersonalDetails();
			hotelPage.enterCardDetails();
			hotelPage.verifyErrorMessage();
		}
		else System.out.println("Testcase failed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		hotelSearchPage.closeAllWindows();
	}
}
