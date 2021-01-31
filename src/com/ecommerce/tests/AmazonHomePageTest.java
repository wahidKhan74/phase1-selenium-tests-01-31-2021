package com.ecommerce.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonHomePageTest {

	public static void main(String[] args) {
		
		final String siteUrl = "https://www.amazon.in/";
		
		// 1. Set selenium properties
		System.setProperty("webdriver.gecko.driver", 
				"/home/wahidkhan74gmai/eclipse-workspace/phase1-selenium-tests-01-31-2021/driver/geckodriver");
		
		// 2. Instantiating selenium web driver		
		WebDriver driver = new FirefoxDriver();
		driver.get(siteUrl);
		
		// 3. Perform test
		String pageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		if(driver.getTitle().equals(pageTitle)) {
			System.out.println("Test Passed !");
		} else {
			System.out.println("Test Failed !");
		}
		driver.close();
	}

}
