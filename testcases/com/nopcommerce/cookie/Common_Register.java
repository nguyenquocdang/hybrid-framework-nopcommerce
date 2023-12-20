package com.nopcommerce.cookie;


import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

public class Common_Register extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String password;
	private LoginPageObject loginPage;
	public static String emailAddress, firstName, lastName;
	public static Set<Cookie> cookies;
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName = "John";
		lastName = "Wick";
		password = "123456";
		emailAddress = getEmailAddress();
		
		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextBox(firstName);
		registerPage.enterToLastNameTextBox(lastName);
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordTextBox(password);
		registerPage.enterToConfirmPasswordTextBox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		homePage = registerPage.clickToHomePageLogo();

		loginPage = homePage.clickToLoginLink();
		
		homePage = loginPage.loginAsUser(emailAddress, password);
		homePage.sleepInSecond(5);
				
		cookies = homePage.getBrowserCookies(driver);
		
		quitBrowserDriver();
	}
}
