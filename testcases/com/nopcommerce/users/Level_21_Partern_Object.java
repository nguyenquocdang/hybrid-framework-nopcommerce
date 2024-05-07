package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

public class Level_21_Partern_Object extends BaseTest{
	private WebDriver driver;
	private String emailAddress = getEmailAddressRandom();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		registerPage = homePage.clickToRegisterLink();
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.clickToButtonByText("Register");
		
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("FirstName"), "First name is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"), "Email is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Password"), "Password is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		homePage  = registerPage.clickToHomePageLogo();
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.enterToTextboxByID("FirstName", "John");
		registerPage.enterToTextboxByID("LastName", "Wick");
		registerPage.enterToTextboxByID("Email", "john@wick@gmail.com");
		registerPage.enterToTextboxByID("Password", "123456");
		registerPage.enterToTextboxByID("ConfirmPassword", "123456");

		registerPage.clickToButtonByText("Register");
		
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"), "Wrong email");
	}

	@Test
	public void Register_03_Invalid_Password() {
		homePage  = registerPage.clickToHomePageLogo();
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.enterToTextboxByID("FirstName", "John");
		registerPage.enterToTextboxByID("LastName", "Wick");
		registerPage.enterToTextboxByID("Email", "johnwick@gmail.com");
		registerPage.enterToTextboxByID("Password", "123");
		registerPage.enterToTextboxByID("ConfirmPassword", "123");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Password"), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {
		homePage  = registerPage.clickToHomePageLogo();
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.enterToTextboxByID("FirstName", "John");
		registerPage.enterToTextboxByID("LastName", "Wick");
		registerPage.enterToTextboxByID("Email", "johnwick@gmail.com");
		registerPage.enterToTextboxByID("Password", "123456");
		registerPage.enterToTextboxByID("ConfirmPassword", "654321");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Success() {
		homePage  = registerPage.clickToHomePageLogo();
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.enterToTextboxByID("FirstName", "John");
		registerPage.enterToTextboxByID("LastName", "Wick");
		registerPage.enterToTextboxByID("Email", emailAddress);
		registerPage.enterToTextboxByID("Password", "123456");
		registerPage.enterToTextboxByID("ConfirmPassword", "123456");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToHomePageLogo();
		
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		homePage = loginPage.loginAsUser(emailAddress, "123456");
		
		
		homePage.clickToHeaderLinkByName("My account");
		customerPage = PageGeneratorManager.getCustomerPage(driver);
		
		Assert.assertEquals(customerPage.getTextboxAttributeByID("FirstName"), "John");
		Assert.assertEquals(customerPage.getTextboxAttributeByID("LastName"), "Wick");
		Assert.assertEquals(customerPage.getTextboxAttributeByID("Email"), emailAddress);
	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
