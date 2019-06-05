package com.expedia.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.qa.base.TestBase;

public class LoginPage extends TestBase {
   
	
	//Page Factory - OR:
		@FindBy(id="gss-signin-email")
		WebElement username;
		
		@FindBy(id="gss-signin-password")
		WebElement password;
		
		@FindBy(xpath="//*[@id=\"gss-goto-signup\"]")
		WebElement signupBtn;
		
		@FindBy(xpath="//*[@id=\"gss-signin-submit\"]")
		WebElement loginBtn;
		
	//	@FindBy(xpath="//*[@id=\"userGreetingName\"]")
		@FindBy(xpath="//*[@class=\"nonArrangedUser\"]")
		WebElement nameLogo;
		//*[@id="userGreetingName"]
		//*[@id="header-account-menu-signed-in"]/span/span[1]/span[1]
		
		@FindBy(xpath="//*[@id=\"header-account-menu\"]")
		WebElement accountTab;
		
		@FindBy(xpath="//a[@id='account-signin']")
		WebElement signinTab;
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
//		public String validateLoginPageTitle(){
//			return driver.getTitle();
//		}
		public void clickAccountTab() {
			accountTab.click();
			
		}
		
		public void clickSinginTab() {
			signinTab.click();
			
		}
		
		
		public boolean validateNameLogo(){
			return nameLogo.isDisplayed();
		}
		
		public void login(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
//			    	JavascriptExecutor js = (JavascriptExecutor)driver;
//	    	js.executeScript("arguments[0].click();", loginBtn);
			    	
//			return new HomePage();
		}
	
	
	
}