package com.goibibo.qa.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.util.TestUtil;

public class HotelSearchPage extends TestBase {
	TestUtil testUtil;
	String parent;

	@FindBy(xpath = "//h4[contains(text(), 'India')]")
	WebElement selectIndia;

	@FindBy(xpath = "//h4[contains(text(), 'International')]")
	WebElement selectInternational;

	@FindBy(id = "downshift-1-input")
	WebElement enterAreaOrHotelName;

	@FindBy(xpath = "(//span[@class = 'SearchBlockUIstyles__AutoSuggestLabelText-fity7j-10 ikcRoN'])[2]")
	WebElement guestCount;

	@FindBy(xpath = "(//span[@class='PaxWidgetstyles__ContentActionIconWrapperSpan-gv3w6r-8 gxLEEg'])[3]")
	WebElement reduceAdultCount;

	@FindBy(xpath = "//button[contains(text(), 'Done')]")
	WebElement doneButton;

	@FindBy(xpath = "//button[@data-testid= 'searchHotelBtn']")
	WebElement searchHotelsButton;

	@FindBy(xpath = "//i[@class= 'wewidgeticon we_close icon-large']")
	WebElement closePopUp;

	@FindBy(xpath = "(//h4[@itemprop = 'name'])[10]")
	WebElement scrollHotels;
	
	@FindBy(xpath = "(//div[@class='HotelCardstyles__HotelNameWrapperDiv-sc-1s80tyk-12 biniNQ'])[1]")
	WebElement firstHotel;
	
	@FindBy(xpath = "(//span[@class='ToggleButtonListstyles__FilterToggleCircularSwitch-sc-148wx03-7 cPBHpu'])[2]")
	WebElement payAtHotelFilter;
	
	@FindBy(xpath = "(//span[@class='Filtersstyles__StarRatingWrapperSpan-bkjigy-6 iudVMC'])[2]")
	WebElement fourStarRating;
	
	@FindBy(xpath = "(//span[@class='CheckBoxList__CheckBoxListText-sc-5k7440-6 fNzzGJ'])[1]")
	WebElement firstPriceRange;
	
	public HotelSearchPage() {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}

	public void searchHotels() {
		try {
			selectIndia.click();
			enterAreaOrHotelName.sendKeys(prop.getProperty("place"));
			Thread.sleep(2000);
			testUtil.clickDownArrow(prop.getProperty("place"));
			guestCount.click();
			reduceAdultCount.click();
			doneButton.click();
			searchHotelsButton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void displayHotelsName() {
		List<WebElement> elements = driver.findElements(By.xpath("//h4[@itemprop = 'name']"));
		for (WebElement ele : elements) 
			System.out.println(ele.getText());
		System.out.println("TotalCount Hotel Count :"+elements.size());
	}

	public HotelPage selectHotel(String hotelName) {
		driver.findElement(By.xpath("//h4[contains(text(), '" + hotelName + "')]")).click();
		testUtil.switchWindows();
		return new HotelPage();
	}
	
	public HotelPage selectFirstHotel() {
		firstHotel.click();
		return new HotelPage();
	}
	
	public void closeAllWindows() {
		driver.switchTo().window(TestUtil.parent);
		driver.close();
	}
	
	public void applyFilter() {
		payAtHotelFilter.click();
		TestUtil.sleepAction(3000);
		fourStarRating.click();
		TestUtil.sleepAction(3000);
		firstPriceRange.click();
		TestUtil.sleepAction(3000);
	}
}
