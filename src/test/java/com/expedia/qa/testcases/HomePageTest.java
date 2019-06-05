package com.expedia.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.expedia.qa.base.TestBase;
import com.expedia.qa.pages.HomePage;
import com.expedia.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	
	
	
	HomePage homePage;
	//HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeTest
	public void setUp(){
		initialization();
		homePage = new HomePage();	
	}
	
//	@Test(priority=1)
//	public void loginPageTitleTest(){
//		String title = loginPage.validateLoginPageTitle();
//		Assert.assertEquals(title, "");
//	}
	
	@Test(priority=1)
	
	public void flightsLinkTest() {
		homePage.clickOnFlightsLink();
		
		
	}
	
//	@Test(priority=4)
//	public void nameLogoTest(){
//		boolean flag = loginPage.validateNameLogo();
//		Assert.assertTrue(flag);
//	}
	
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
}
