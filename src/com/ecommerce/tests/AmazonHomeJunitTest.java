package com.ecommerce.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonHomeJunitTest {
	
	WebDriver  driver;
	
	@Before
	public void setUpDriver() throws Exception {
		// 1. set selenium properties
		System.setProperty("webdriver.gecko.driver", 
		"/home/wahidkhan74gmai/eclipse-workspace/phase1-selenium-tests-01-31-2021/driver/geckodriver");
		
		// 2. Instantiating selenium web driver		
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void verifyTitle() {
		String siteUrl = "https://www.amazon.in/";
		driver.get(siteUrl);
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void verfySourceURL() {
		String siteUrl = "https://www.amazon.in/";
		driver.get(siteUrl);
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(siteUrl, actualUrl);
	}
	
	@Test
	public void verifyMobileSourcePage() {
		String siteUrl = "https://www.amazon.in/";
		driver.get(siteUrl);
		
		
		//local mobile link
		WebElement mobileLink = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]"));
		// click mobile link
		mobileLink.click();
		
		String actualTitle = driver.getTitle();
		String expectedTitle ="Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	
	@Test
	public void verifySearchForIphone11() throws InterruptedException {
		String siteUrl = "https://www.amazon.in/";
		driver.get(siteUrl);
		
		
		//find search box
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		// add input in search fields
		searchBox.sendKeys("Inphone 11 max pro");		
		Thread.sleep(2000);
		
		WebElement submit = driver.findElement(By.id("nav-search-submit-button"));
		
		// click submit link
		submit.click();
		Thread.sleep(2000);
		
		String actualTitle = driver.getTitle();
		String expectedTitle ="Amazon.in : Inphone 11 max pro";
		Assert.assertEquals(expectedTitle, actualTitle);
	}

}
