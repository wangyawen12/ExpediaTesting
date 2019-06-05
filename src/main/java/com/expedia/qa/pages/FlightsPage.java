package com.expedia.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.qa.base.TestBase;

public class FlightsPage extends TestBase{

	@FindBy(xpath = "//*[@id=\"tab-flight-tab-flp\"]")
	WebElement flightOnlyLink;
	
	

	@FindBy(xpath = "//*[@id=\"tab-flight-tab-flp\"]")
	WebElement flightHotelLink;
	

	@FindBy(xpath = "//*[@id=\"tab-flight-tab-flp\"]")
	WebElement flightHotelCarLink;
	

	@FindBy(xpath = "//*[@id=\"tab-flight-tab-flp\"]")
	WebElement flightCarLink;
	
	@FindBy(xpath = "//*[@id=\"flight-type-roundtrip-label-flp\"]")
	WebElement roundTripLink;
	
	
	@FindBy(xpath = "//*[@id=\"flight-origin-flp\"]")
	WebElement flightFrom;
	
	
	@FindBy(xpath = "//*[@id=\"flight-destination-flp\"]")
	WebElement flightTo;
	
	@FindBy(xpath = "//*[@id=\"flight-departing-flp\"]")
	WebElement departDate;
	
	
	@FindBy(xpath = "//*[@id=\"flight-returning-flp\"]")
	WebElement returnDate;
	
	@FindBy(xpath = "//*[@id=\"traveler-selector-flp\"]")
	WebElement travelers;
	
	
	
	@FindBy(xpath = "//*[contains(@class,'gcw-submi')]")
	WebElement searchButton;
	
//	gcw-submit
//	Xpath=//*[contains(@name,'btn')]
	
	public FlightsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnFlightOnlyButton(){
		flightOnlyLink.click();
	}
	

	public void clickOnRoundTrip(){
		roundTripLink.click();
	}
	
	public void enterFlightFrom(String start){
		flightFrom.sendKeys(start);
	}
	public void enterFlightTo(String destination){
		flightTo.sendKeys(destination);
	}
	
	
	public void enterDepartDate(String departing){
		departDate.sendKeys(departing);
	}
	
	public void enterReturnDate(String returning){
		returnDate.clear();
		returnDate.sendKeys(returning);
	}
	
	
	
	
	public void clickOnSrearchButton(){
		searchButton.click();
		
	}
	
	
	
}
