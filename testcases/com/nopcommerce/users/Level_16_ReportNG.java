package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointPageObject;

public class Level_16_ReportNG extends BaseTest{
	private WebDriver driver;
	private String emailAddress = getEmailAddressRandom();
	
	// Không thuộc SideBar sẽ không gọi được
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	private DownloadableProductPageObject downloadableProductPage;
	private RewardPointPageObject rewardPointPage;
	private AddressesPageObject addressesPage;
	private String firstName, lastName, password;
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		firstName = "John";
		lastName = "Wick";
		password = "123456";
	}

	@Test
	public void User_01_Register_Validate() {
		log.info("Register - Step 01: Verify Register link is displayed");
		verifyFalse(homePage.isRegisterLinkDisplayed());
		
		log.info("Register - Step 02: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 04: Verify error message at FirstName textbox");
		verifyEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		log.info("Register - Step 05: Verify error message at LastName textbox");
		verifyEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
	}
	
	@Test
	public void User_02_Register_Success() {
		log.info("Register - Step 01: Enter to First Name textbox with value is " + firstName);
		registerPage.refreshCurrentPage(driver);
		registerPage.enterToFirstNameTextBox(firstName);
		
		log.info("Register - Step 02: Enter to Last Name textbox with value is " + lastName);
		registerPage.enterToLastNameTextBox(lastName);
		
		log.info("Register - Step 03: Enter to Email address textbox with value is " + emailAddress);
		registerPage.enterToEmailTextBox(emailAddress);
		
		log.info("Register - Step 04: Enter to Password textbox with value is " + password);
		registerPage.enterToPasswordTextBox(password);
		
		log.info("Register - Step 05: Enter to ConfirmPassword textbox with value is " + password);
		registerPage.enterToConfirmPasswordTextBox(password);

		log.info("Register - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 07: Verify success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
	}
	
	

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
