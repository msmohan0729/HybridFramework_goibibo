package com.goibibo.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.goibibo.qa.base.TestBase;
import com.goibibo.qa.util.TestUtil;

public class HotelPage extends TestBase {
	TestUtil testUtil;
	JavascriptExecutor js;

	@FindBy(xpath = "//button[@class= 'dwebCommonstyles__ButtonBase-sc-112ty3f-10 BookingWidgetstyles__ViewRoomOptionsButton-sc-1tsb1-10 KETBj iiLDmi']")
	WebElement view1RoomOptionsButton;

	@FindBy(xpath = "//button[@class= 'dwebCommonstyles__ButtonBase-sc-112ty3f-10 RoomFlavorstyles__ButtonWrapper-sc-1btnl3r-15 KETBj bIgcAI']")
	WebElement selectRoomButton;

	@FindBy(xpath = "(//input[@class= 'PersonalProfile__NameEnterInput-sc-1r9ak8b-6 hEgRgJ'])[1]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@class= 'PersonalProfile__NameEnterInput-sc-1r9ak8b-6 hEgRgJ'])[2]")
	WebElement lastName;

	@FindBy(xpath = "//input[@data-guestdetailsinnerwrapid= 'guest-details-email']")
	WebElement email;

	@FindBy(xpath = "//input[@placeholder= 'Enter Phone Number']")
	WebElement phoneNo;

	@FindBy(xpath = "//span[contains(text(), 'Proceed To Payment Options')]")
	WebElement proceedToPaymentOptionsButton;

	@FindBy(xpath = "(//input[@name = 'cardnumber'])[1]")
	WebElement cardNumber;

	@FindBy(xpath = "(//input[@class= 'form-control inputMedium cr_crd_name'])[1]")
	WebElement cardName;

	@FindBy(xpath = "(//input[@class= 'form-control inputMedium cr_crd_exp'])[1]")
	WebElement expiryDate;

	@FindBy(xpath = "(//input[@class= 'gpayformFeildWrap inputMedium marginT5 cr_cvv_no'])[1]")
	WebElement enterCVV;

	@FindBy(xpath = "(//button[@class='button green large citipatBtn btn payNowBtn'])[1]")
	WebElement payButton;

	@FindBy(xpath = "//p[contains(text(), 'Please Enter Valid Card Number')]")
	WebElement cardNumberErrorMessage;

	@FindBy(xpath = "//p[contains(text(), 'Please Enter Valid Expiry Date (MM/YY)')]")
	WebElement expiryDateErrorMessage;

	@FindBy(xpath = "//p[contains(text(), 'Please Enter Valid CVV Number')]")
	WebElement cvvNumberErrorMessage;

	@FindBy(xpath = "//h1[@itemprop='name']")
	WebElement hotelName;

	@FindBy(xpath = "//span[@itemprop='streetAddress']")
	WebElement hotelAddress;

	@FindBy(xpath = "//div[@class='Policystyles__PolicyHeaderTextStyled-sc-1vd94lq-2 duMtah']")
	WebElement hotelPolicyHeader;
	
	@FindBy(xpath = "(//a[@class='ContentContainerstyles__ViewMoreTextStyled-jinyls-1 ialKVS'])[1]")
	WebElement viewMorelink;

	@FindBy(xpath = "//ul[@class='Policystyles__PolicyListBlock-sc-1vd94lq-3 hdPrep']")
	WebElement hotelPolicies;
	
	@FindBy(xpath = "//*[contains(text(), 'Question & Answer')]")
	WebElement questionAndAnswerHeader;

	public HotelPage() {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
		js = (JavascriptExecutor) driver;
	}

	public void selectRooms() {
		view1RoomOptionsButton.click();
		selectRoomButton.click();
	}

	public void enterPersonalDetails() {
		firstName.sendKeys(prop.getProperty("firstname"));
		lastName.sendKeys(prop.getProperty("lastname"));
		email.sendKeys(prop.getProperty("email"));
		phoneNo.sendKeys(prop.getProperty("phoneno"));
		proceedToPaymentOptionsButton.click();
	}

	public void enterCardDetails() {
		cardNumber.sendKeys(prop.getProperty("cardnumber"));
		cardName.sendKeys(prop.getProperty("cardname"));
		expiryDate.sendKeys(prop.getProperty("expiryDate"));
		enterCVV.sendKeys("cvvnumber");
		payButton.click();
	}

	public void verifyErrorMessage() {
		if (expiryDateErrorMessage.isDisplayed() || cvvNumberErrorMessage.isDisplayed())
			System.out.println("TestCase passed");
		else
			System.err.println("TestCase failed");
	}

	public void getRoomDetails() {
	
		System.out.println("Hotel Name      : " + hotelName.getText());
		System.out.println("Hotyel Address  : " + hotelAddress.getText());
		System.out.println();
		System.out.println("Room Details:");
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='Roomstyles__RoomContainer-sc-1ivl7fs-1 ZTwTx']"));
		int i = 1;
		for (WebElement element : rows) {
			System.out.println("Room " + i + " : " + element.getText());
			i++;
			System.out.println();
		}
		System.out.println();

		System.out.println("Guest Reviews:");
		TestUtil.printWebElements(
				"//div[@class='Layouts__Row-sc-1yzlivq-0 UserReviewstyles__WrapperDiv-sc-1y05l7z-0 iwUOtq fFSKeI']");

		TestUtil.scrollToVisibleOfElement(hotelPolicyHeader);
		TestUtil.sleepAction(2000);
		viewMorelink.click();
		
		System.out.println("Hotel Policies:");
		TestUtil.printWebElements("//span[@class='Policystyles__PolicyTextStyled-sc-1vd94lq-7 eEjiXn']");

		js.executeScript("window.scrollBy(0,1000)");
		TestUtil.sleepAction(2000);
		System.out.println("Question & Answers:");
		TestUtil.printWebElements("//div[@class='UserAnswerstyles__ContentWrapperDiv-sc-1c5jue4-1 pRwGs']");
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
