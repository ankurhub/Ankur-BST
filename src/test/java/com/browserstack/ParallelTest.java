package com.browserstack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ParallelTest {
	public WebDriver driver;
    public WebDriver driver2;

    @Test
    public void ParallelTestingOnBrowserStack_URLCheck() throws Exception {
    	ChromeOptions options = new ChromeOptions();
    	
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts();
    	driver.get("https://www.browserstack.com");
 		System.out.println(driver.getTitle()); 
 		WebElement elem= driver.findElement(By.id("signupModalButton"));
 		elem.click();
 		System.out.println("Current Title is :" + driver.getTitle()); 
 		Assert.assertEquals(driver.getCurrentUrl(),"https://www.browserstack.com/users/sign_up");
 		driver.quit();
 		
    }
    
    
    @Test
    public void ParallelTestingOnBrowserStack_TitleCheck() throws Exception {
    	ChromeOptions options = new ChromeOptions();
    	
        options.addArguments("start-maximized");
    	driver2 = new ChromeDriver(options);
    	driver2.manage().timeouts();
        driver2.get("https://www.browserstack.com");
		System.out.println(driver2.getTitle()); 
		WebElement elem= driver2.findElement(By.id("signupModalButton"));
		elem.click();
		System.out.println("Current Title is :" + driver2.getTitle()); 
		Assert.assertEquals(driver2.getTitle(),"Get Started For Free & Access 3000+ Mobile Devices & Browsers | BrowserStack");
		driver2.quit();
    }
    
    
}
