package com.expedia.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.expedia.qa.base.TestBase;
import com.expedia.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	
	
	LoginPage loginPage;
	//HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeTest
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
//	@Test(priority=1)
//	public void loginPageTitleTest(){
//		String title = loginPage.validateLoginPageTitle();
//		Assert.assertEquals(title, "");
//	}
	
	@Test(priority=1)
	
	public void accountTabTest() {
		loginPage.clickAccountTab();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
//	@Test(priority=4)
//	public void nameLogoTest(){
//		boolean flag = loginPage.validateNameLogo();
//		Assert.assertTrue(flag);
//	}
	
	@Test(priority=3)
	public void loginTest(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=2)
	public void clickSinginTabTest(){
		loginPage.clickSinginTab();
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	

}

