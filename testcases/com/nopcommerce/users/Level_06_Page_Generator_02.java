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

public class Level_06_Page_Generator_02 extends BaseTest{
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
		
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		// Hàm nào có sự kiện chuyển trang từ A qua B
		// Thì sẽ đưa việc khởi tạo class B vào trong hàm đó luôn
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		homePage  = registerPage.clickToHomePageLogo();
		
		registerPage = homePage.clickToRegisterLink();
		
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
		homePage  = registerPage.clickToHomePageLogo();
		
		registerPage = homePage.clickToRegisterLink();

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
		homePage  = registerPage.clickToHomePageLogo();
		
		registerPage = homePage.clickToRegisterLink();

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
		homePage  = registerPage.clickToHomePageLogo();
		
		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextBox("John");
		registerPage.enterToLastNameTextBox("Wick");
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordTextBox("123456");
		registerPage.enterToConfirmPasswordTextBox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToHomePageLogo();

		loginPage = homePage.clickToLoginLink();
		
		homePage = loginPage.loginAsUser(emailAddress, "123456");
		
		customerPage = homePage.clickToMyAccountLink();
		
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "John");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Wick");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
