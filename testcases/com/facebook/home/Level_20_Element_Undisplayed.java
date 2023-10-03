package com.facebook.home;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_20_Element_Undisplayed extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Element_Displayed() {
		homePage.clickToCreateNewAccountButton();
		
		verifyTrue(homePage.isFirstNameTextboxDisplayed());
		verifyTrue(homePage.isSurNameTextboxDisplayed());
		verifyTrue(homePage.isEmailTextboxDisplayed());
		verifyTrue(homePage.isPasswordTextboxDisplayed());
		
		homePage.enterToEmailTextbox("Automationfc@gmail.com");
		
		log.info("Verify Confirm Email textbox is displayed");
		verifyTrue(homePage.isConfirmEmailTextboxDisplayed());
		
	}
	
	@Test
	public void User_02_Element_Undisplayed_In_HTML() {
		homePage.enterToEmailTextbox("");
		homePage.sleepInSecond(3);
		
		// Sau khi xóa dữ liệu của Email textbox đi - thì Confirm Email textbox ko hiển thị trên UI
		// Nhưng vẫn có trong HTML
		log.info("Verify Confirm Email textbox is not displayed");
		verifyFalse(homePage.isConfirmEmailTextboxDisplayed());
	}
	

	public void User_03_Element_Undisplayed_Not_In_HTML_02() {
		homePage.clickToCloseSignUpPopup();
		
		log.info("Verify Firstname textbox is not displayed");
		verifyTrue(homePage.isFirstNameTextboxUndisplayed());
		
		log.info("Verify Surname textbox is not displayed");
		verifyTrue(homePage.isSurNameTextboxUndisplayed());
		
		log.info("Verify Emailname textbox is not displayed");
		verifyTrue(homePage.isEmailTextboxUndisplayed());
		
		log.info("Verify Password textbox is not displayed");
		verifyTrue(homePage.isPasswordTextboxUndisplayed());
	}
	
	@Test
	public void User_03_Element_Undisplayed_Not_In_HTML_01() {
		homePage.clickToCloseSignUpPopup();
		
		log.info("Verify Firstname textbox is not displayed");
		verifyTrue(homePage.isFirstNameTextboxUndisplayed());
		
		log.info("Verify Surname textbox is not displayed");
		verifyTrue(homePage.isSurNameTextboxUndisplayed());
		
		log.info("Verify Emailname textbox is not displayed");
		verifyTrue(homePage.isEmailTextboxUndisplayed());
		
		log.info("Verify Password textbox is not displayed");
		verifyTrue(homePage.isPasswordTextboxUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
