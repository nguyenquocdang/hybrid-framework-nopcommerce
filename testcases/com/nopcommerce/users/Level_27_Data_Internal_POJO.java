package com.nopcommerce.users;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.HomePageObject;
import pageObjects.users.RegisterPageObject;
import pojoData.nopcommerce.UserInfo;
import reportConfig.ExtentTestManager;

public class Level_27_Data_Internal_POJO extends BaseTest{


	
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		userInfo = UserInfo.getUser();
		
		userInfo.setEmailAddress(getEmailAddressRandom("john"));
		userInfo.setFirstName("John");
		userInfo.setLastName("Kennedy");
		userInfo.setPassword("123456");
	}

	@Test
	public void User_01_Register_Validate(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_01_Register_Validate");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' page");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Verify Register link is displayed");
//		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Verify error message at FirstName textbox");
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Verify error message at LastName textbox");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
	}
	
	@Test
	public void User_02_Register_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Register_Success");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Enter to First Name textbox with value is " + userInfo.getFirstName());
		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextBox(userInfo.getFirstName());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to Last Name textbox with value is " + userInfo.getLastName());
		registerPage.enterToLastNameTextBox(userInfo.getLastName());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Email address textbox with value is " + userInfo.getEmailAddress());
		registerPage.enterToEmailTextBox(userInfo.getEmailAddress());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Password textbox with value is " + userInfo.getPassword());
		registerPage.enterToPasswordTextBox(userInfo.getPassword());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to ConfirmPassword textbox with value is " + userInfo.getPassword());
		registerPage.enterToConfirmPasswordTextBox(userInfo.getPassword());

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Verify success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
	
	private WebDriver driver;
	
	
	// Không thuộc SideBar sẽ không gọi được
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private UserInfo userInfo;

}
