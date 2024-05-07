package com.nopcommerce.users;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import jsonData.nopcommerce.UserInfoData;
import pageObjects.users.HomePageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.SearchPageObject;
import reportConfig.ExtentTestManager;

public class Level_30_Test_Not_Dependencies extends BaseTest{
	private WebDriver driver;
	private SearchPageObject searchPage;
	private HomePageObject homePage;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void beforeMethod(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		searchPage = homePage.clickToSearchLink();

	}

	@Test
	public void Search_01_ByEmptyData() {
		searchPage.entertoSearchTextbox("");
		searchPage.clickToSearchButton();
		
		// Verify
		
	}
	
	@Test
	public void Search_02_ByNameNotExist() {
		searchPage.entertoSearchTextbox("Macbook Pro 2050");
		searchPage.clickToSearchButton();
		
		// Verify
	}
	
	@Test
	public void Search_03_ByContainsProductName() {
		searchPage.entertoSearchTextbox("Lenovo");
		searchPage.clickToSearchButton();
		
		// Verify
	}
	
	@Test
	public void Search_04_ByProductName() {
		searchPage.entertoSearchTextbox("ThinkPad X1 Carbon");
		searchPage.clickToSearchButton();
		
		// Verify
	}
	
	@AfterMethod
	public void afterMethod() {
		quitBrowserDriver();
	}
	

	
}
