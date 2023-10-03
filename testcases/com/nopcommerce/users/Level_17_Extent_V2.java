//package com.nopcommerce.users;
//
//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BasePage;
//import commons.BaseTest;
//import commons.GlobalConstants;
//import commons.PageGeneratorManager;
//import pageObjects.users.AddressesPageObject;
//import pageObjects.users.CustomerPageObject;
//import pageObjects.users.DownloadableProductPageObject;
//import pageObjects.users.HomePageObject;
//import pageObjects.users.LoginPageObject;
//import pageObjects.users.RegisterPageObject;
//import pageObjects.users.RewardPointPageObject;
//import reportConfig.ExtentManager;
//
//public class Level_17_Extent_V2 extends BaseTest{
//	private WebDriver driver;
//	private String emailAddress = getEmailAddress();
//	
//	// Không thuộc SideBar sẽ không gọi được
//	private HomePageObject homePage;
//	private RegisterPageObject registerPage;
//
//	private DownloadableProductPageObject downloadableProductPage;
//	private RewardPointPageObject rewardPointPage;
//	private AddressesPageObject addressesPage;
//	private String firstName, lastName, password;
//	
//	
//	@Parameters({"browser"})
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName);
//		homePage = PageGeneratorManager.getHomePage(driver);
//		registerPage = PageGeneratorManager.getRegisterPage(driver);

//		firstName = "John";
//		lastName = "Wick";
//		password = "123456";
//	}
//
//	@Test
//	public void User_01_Register_Validate(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register_Validate");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Verify Register link is displayed");
//		Assert.assertFalse(homePage.isRegisterLinkDisplayed());
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Click to Register link");
//		registerPage = homePage.clickToRegisterLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Verify error message at FirstName textbox");
//		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Verify error message at LastName textbox");
//		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
//	}
//	
//	@Test
//	public void User_02_Register_Success(Method method) {
//		ExtentManager.startTest(method.getName(), "User_02_Register_Success");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Enter to First Name textbox with value is " + firstName);
//		registerPage = homePage.clickToRegisterLink();
//		registerPage.enterToFirstNameTextBox(firstName);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Last Name textbox with value is " + lastName);
//		registerPage.enterToLastNameTextBox(lastName);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Email address textbox with value is " + emailAddress);
//		registerPage.enterToEmailTextBox(emailAddress);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Password textbox with value is " + password);
//		registerPage.enterToPasswordTextBox(password);
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to ConfirmPassword textbox with value is " + password);
//		registerPage.enterToConfirmPasswordTextBox(password);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Verify success message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
//	}
//	
//	
//
//	@AfterClass
//	public void afterClass() {
//		quitBrowserDriver();
//	}
//
//}
