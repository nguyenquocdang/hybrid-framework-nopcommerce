package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;

public class Level_07_Switch_Multiple_Page extends BaseTest{
	private WebDriver driver;
	private String emailAddress = getEmailAddress();
	
	// Không thuộc SideBar sẽ không gọi được
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	
	// Thuộc SideBar sẽ gọi các hàm trong SideBar dùng được
	private CustomerPageObject customerPage;
	
	@Parameters({"browser", "userUrl", "adminUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Register() {
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
	
	@Test
	public void User_02_Switch_Page() {
		// Để các hàm mở page trong BasePage
		// Customer Info => Downloadable products
		// downloadableProductPage = customerPage.openDownloadableProductPage(driver);
		// ...
		
		// Downloadable products => Addresses
		// addressesPage = downloadableProductPage.openAddressesPage(driver);
		// ...
		
		// Addresses =>Reward points
		// rewardPointPage = addressesPage.openRewardPointPage(driver);
		// ...
		
		//Reward points => Customer Info
		// customerPage = rewardPointPage.openCustomerInforPage(driver);
		// ...
		
		// Customer Info => Addresses
		// addressesPage = customerPage.openAddressesPage(driver);
		// ...
		
		// Addresses => Downloadable products
		// downloadableProductPage = addressesPage.openDownloadableProductPage(driver);
		// ...
		
		// customerPage = downloadableProductPage.openCustomerInforPage(driver);
		
		// addressesPage =  customerPage.openAddressesPage(driver);
	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
