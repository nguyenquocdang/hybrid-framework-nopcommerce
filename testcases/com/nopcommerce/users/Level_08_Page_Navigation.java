package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointPageObject;

public class Level_08_Page_Navigation extends BaseTest{
	private WebDriver driver;
	private String emailAddress = getEmailAddress();
	
	// Không thuộc SideBar sẽ không gọi được
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	
	// Thuộc SideBar sẽ gọi các hàm trong SideBar dùng được
	private CustomerPageObject customerPage;
	private DownloadableProductPageObject downloadableProductPage;
	private RewardPointPageObject rewardPointPage;
	private AddressesPageObject addressesPage;
	
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
		// Customer Info => Downloadable products
		downloadableProductPage = customerPage.openDownloadableProductPage();
		// ...
		
		// Downloadable products => Addresses
		addressesPage = downloadableProductPage.openAddressesPage();
		// ...
		
		// Addresses =>Reward points
		rewardPointPage = addressesPage.openRewardPointPage();
		// ...
		
		//Reward points => Customer Info
		customerPage = rewardPointPage.openCustomerInforPage();
		// ...
		
		// Customer Info => Addresses
		addressesPage = customerPage.openAddressesPage();
		// ...
		
		// Addresses => Downloadable products
		downloadableProductPage = addressesPage.openDownloadableProductPage();
		// ...xww3
		
		customerPage = downloadableProductPage.openCustomerInforPage();
		
		addressesPage =  customerPage.openAddressesPage();
	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
