package com.expedia.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.qa.base.TestBase;
import com.expedia.qa.pages.HotelsPage;
import com.expedia.qa.pages.FlightsPage;


public class HomePage extends TestBase{
	
	
	
	
	
	@FindBy(xpath = "//*[@id=\"primary-header-flight\"]")
	WebElement flightsLink;
	

	@FindBy(xpath = "//*[@id=\"primary-header-hotel\"]")
	WebElement hotelsLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
//	public boolean verifyCorrectUserName(){
//		return userNameLabel.isDisplayed();
//	}
//	
	public FlightsPage clickOnFlightsLink(){
		flightsLink.click();
		return new FlightsPage();
	}
	
	public HotelsPage clickOnHotelsLink(){
		hotelsLink.click();
		return new HotelsPage();
	}
	
	
	
	
	
	
	
	
	
	

}
