package com.browserstack;

import com.browserstack.SeleniumTest;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BStackDemoTest extends SeleniumTest {  
    
    @Test
    public void TestingOnBrowserStack_URL_Check() throws Exception {
        
        driver.get("https://www.browserstack.com");
		System.out.println(driver.getTitle()); 
		WebElement elem= driver.findElement(By.id("signupModalButton"));
		elem.click();
		System.out.println("Current Title is :" + driver.getTitle()); 
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.browserstack.com/users/sign_up");
    }
    
    @Test
    public void TestingOnBrowserStack_TitleCheck() throws Exception {
        
        driver.get("https://www.browserstack.com");
		System.out.println(driver.getTitle()); 
		WebElement elem= driver.findElement(By.id("signupModalButton"));
		elem.click();
		System.out.println("Current Title is :" + driver.getTitle()); 
		Assert.assertEquals(driver.getTitle(),"Get Started For Free & Access 3000+ Mobile Devices & Browsers | BrowserStack");
    }
}
