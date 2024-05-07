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
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

public class Level_06_Page_Generator_01 extends BaseTest{
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
	}

	@Test
	public void Register_01_Empty_Data() {
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextBox("John");
		registerPage.enterToLastNameTextBox("Wick");
		registerPage.enterToEmailTextBox("john@wick@gmail.com");
		registerPage.enterToPasswordTextBox("123456");
		registerPage.enterToConfirmPasswordTextBox("123456");

		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void Register_03_Invalid_Password() {
		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextBox("John");
		registerPage.enterToLastNameTextBox("Wick");
		registerPage.enterToEmailTextBox("johnwick@gmail.com");
		registerPage.enterToPasswordTextBox("123");
		registerPage.enterToConfirmPasswordTextBox("123");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {
		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextBox("John");
		registerPage.enterToLastNameTextBox("Wick");
		registerPage.enterToEmailTextBox("johnwick@gmail.com");
		registerPage.enterToPasswordTextBox("123456");
		registerPage.enterToConfirmPasswordTextBox("654321");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Success() {
		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		
		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextBox("John");
		registerPage.enterToLastNameTextBox("Wick");
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordTextBox("123456");
		registerPage.enterToConfirmPasswordTextBox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		registerPage.clickToHomePageLogo();
		homePage = new HomePageObject(driver);

		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountLink();
		
		customerPage = new CustomerPageObject(driver);
		
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "John");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Wick");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
