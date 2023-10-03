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

public class Level_14_Assert_Verify extends BaseTest{
	private WebDriver driver;
	private String emailAddress = getEmailAddress();
	
	// Không thuộc SideBar sẽ không gọi được
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	private DownloadableProductPageObject downloadableProductPage;
	private RewardPointPageObject rewardPointPage;
	private AddressesPageObject addressesPage;
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Register() {
		// Verify Register link undisplayed -> FAILED
		verifyFalse(homePage.isRegisterLinkDisplayed());

		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();
		
		// Verify error message at FirstName textbox -> PASSED
		verifyEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		// Verify error message at LastName textbox -> FAILED
		verifyEquals(registerPage.getLastNameErrorMessage(), "Last name is required");

		registerPage.enterToFirstNameTextBox("John");
		registerPage.enterToLastNameTextBox("Wick");
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordTextBox("123456");
		registerPage.enterToConfirmPasswordTextBox("123456");

		registerPage.clickToRegisterButton();

		// Verify success message -> FAILED
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.");
	}
	


	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
