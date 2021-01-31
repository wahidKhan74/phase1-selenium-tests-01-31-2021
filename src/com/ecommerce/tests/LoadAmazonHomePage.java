package com.ecommerce.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoadAmazonHomePage {

	@Test
	public void test() {
		final String siteUrl = "https://www.amazon.in/";
		
		// 1. Set selenium properties
		System.setProperty("webdriver.gecko.driver", 
				"/home/wahidkhan74gmai/eclipse-workspace/phase1-selenium-tests-01-31-2021/driver/geckodriver");
		
		// 2. Instantiating selenium web driver		
		WebDriver driver = new FirefoxDriver();
		driver.get(siteUrl);
		
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle);
	}

}
