package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_12_Handle_DataTable extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01() {
		// Search dữ liệu trong 1 Table (trên Header)
		homePage.inputToColumnTextboxByName("Females", "283821");
		
		
		
		
	}
	
	@Test
	public void User_02() {
		
	}
	


	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
