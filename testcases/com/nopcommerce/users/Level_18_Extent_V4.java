package com.nopcommerce.users;

import java.lang.reflect.Method;

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
//import reportConfig.ExtentManager;

public class Level_18_Extent_V4 extends BaseTest{
	private WebDriver driver;
	private String emailAddress = getEmailAddress();
	
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
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		firstName = "John";
		lastName = "Wick";
		password = "123456";
	}

	@Test
	public void User_01_Register_Validate(Method method) {
		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
	}
	
	@Test
	public void User_02_Register_Success(Method method) {
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextBox(firstName);
		
		registerPage.enterToLastNameTextBox(lastName);
		
		registerPage.enterToEmailTextBox(emailAddress);
		
		registerPage.enterToPasswordTextBox(password);
		
		registerPage.enterToConfirmPasswordTextBox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}
	
	

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
