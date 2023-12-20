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

public class Level_22_Close_Browser extends BaseTest{
	private WebDriver driver;
	private String emailAddress = getEmailAddress();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.clickToButtonByText("Register");
		
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("FirstName"), "First name is required....");
		Assert.assertEquals(registerPage.getTextboxErrorMessageByID("LastName"), "Last name is required.");
	}

	@Test
	public void Register_01_Empty_Data() {
		
	}

	@Test
	public void Register_02_Invalid_Email() {
		
	}

	@Test
	public void Register_03_Invalid_Password() {
		
	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {

	}

	@Test
	public void Register_05_Success() {
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		quitBrowserDriver();
	}

}
