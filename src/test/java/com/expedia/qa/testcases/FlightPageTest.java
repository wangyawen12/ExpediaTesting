package com.expedia.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.expedia.qa.util.TestUtil;
import com.expedia.qa.base.TestBase;
import com.expedia.qa.pages.FlightsPage;
import com.expedia.qa.pages.HomePage;

public class FlightPageTest extends TestBase {
	
	

	FlightsPage flightPage;
	HomePage homePage;
	String sheetName = "flights";
	
	public FlightPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
		flightPage = homePage.clickOnFlightsLink();
		
   }

	
	@DataProvider
	public Object[][] getExpediaTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1,dataProvider="getExpediaTestData")
	
	public void RoundTripTest(String from, String to, String departDay, String returnDay) throws InterruptedException  {
		flightPage.clickOnFlightOnlyButton();
		
		flightPage.enterFlightFrom(from);

		flightPage.enterFlightTo(to);

		flightPage.enterDepartDate(departDay);

		flightPage.enterReturnDate(returnDay);
		Thread.sleep(2000);
		flightPage.clickOnSrearchButton();
		
	}
	
	


	@AfterMethod
	public void tearDown(){
     	driver.quit();
	}
	
}