package com.expedia.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.expedia.qa.util.TestUtil;



//import com.qa.util.TestUtil;

//import com.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
//	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/expedia/qa/config/config.properties");	
			prop.load(ip);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/yawenwang/Documents/SelenuimServer/chromedriver");	
			
			
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/yawenwang/Documents/SelenuimServer/geckodriver");	
			driver = new FirefoxDriver(); 
		
		
			
		
		
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		        
		driver.get(prop.getProperty("url"));
		
	
		
   }
	
}
