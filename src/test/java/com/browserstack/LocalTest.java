package com.browserstack;

import static org.testng.AssertJUnit.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LocalTest {

	
    @Test
    public void testLocalFirefox() throws Exception {
    	
    	WebDriver FirefoxDriver = new FirefoxDriver();
		FirefoxDriver.manage().window().maximize();
		FirefoxDriver.get("https://www.browserstack.com");
 		System.out.println(FirefoxDriver.getTitle()); 
 		WebElement elem= FirefoxDriver.findElement(By.id("signupModalButton"));
 		elem.click();
 		System.out.println("Current Title is :" + FirefoxDriver.getTitle()); 
 		Assert.assertEquals(FirefoxDriver.getCurrentUrl(),"https://www.browserstack.com/users/sign_up");
 		FirefoxDriver.quit();
    }
    
    
    
    @Test
    public void testLocalChrome() {
    	System.setProperty("webdriver.chrome.driver","/users/ankur/java-browserstack/chromedriver_mac_arm64/chromedriver");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
    	WebDriver ChromeDriver = new ChromeDriver(options);
    	ChromeDriver.manage().window().maximize();
    	ChromeDriver.get("https://www.browserstack.com");
 		System.out.println(ChromeDriver.getTitle()); 
 		WebElement elem= ChromeDriver.findElement(By.id("signupModalButton"));
 		elem.click();
 		System.out.println("Current Title is :" + ChromeDriver.getTitle()); 
 		Assert.assertEquals(ChromeDriver.getCurrentUrl(),"https://www.browserstack.com/users/sign_up");
 		ChromeDriver.quit();
    }
    
    
    @Test
	public void LocalSafaritest() {
    	
			WebDriver SafariDriver = new SafariDriver();
			SafariDriver.manage().window().maximize();
			SafariDriver.get("https://www.browserstack.com");
			System.out.println(SafariDriver.getTitle()); 
			WebElement elem= SafariDriver.findElement(By.id("signupModalButton"));
			elem.click();
			System.out.println("Current Title is :" + SafariDriver.getTitle()); 
			assertEquals(SafariDriver.getCurrentUrl(),"https://www.browserstack.com/users/sign_up");
			SafariDriver.quit();
		
	}
	
	

    /* This test will run only when Selenium server is running locally
    @Test
	public void SeleniumServerTest() {
    	
    	MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "firefox");
		capabilities.setCapability("platformName", "MAC");
	

		RemoteWebDriver Firefoxdriver = null;
		try {
			Firefoxdriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	Firefoxdriver.get("http://www.google.com");
	Firefoxdriver.quit();
    }
    
    */
}
