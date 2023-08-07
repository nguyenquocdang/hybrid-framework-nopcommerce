package com.nopcommerce.users;

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

public class Level_11_Dynamic_Locator extends BaseTest{
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
	
	private String userUrl = GlobalConstants.DEV_USER_URL;
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
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
		downloadableProductPage = (DownloadableProductPageObject) customerPage.openDynamicSideBarPage("Downloadable products");
		// ...
		
		// Downloadable products => Addresses
		addressesPage = (AddressesPageObject) downloadableProductPage.openDynamicSideBarPage("Addresses");
		// ...
		
		// Addresses =>Reward points
		rewardPointPage = (RewardPointPageObject) addressesPage.openDynamicSideBarPage("Reward points");
		// ...
		
		//Reward points => Customer Info
		customerPage = (CustomerPageObject) rewardPointPage.openDynamicSideBarPage("Customer info");
		// ...
		
		// Customer Info => Addresses
		addressesPage = (AddressesPageObject) customerPage.openDynamicSideBarPage("Addresses");
		// ...
		
		// Addresses => Downloadable products
		downloadableProductPage = (DownloadableProductPageObject) addressesPage.openDynamicSideBarPage("Downloadable products");
		// ...
		
		customerPage = (CustomerPageObject) downloadableProductPage.openDynamicSideBarPage("Customer info");
		
		addressesPage =  (AddressesPageObject) customerPage.openDynamicSideBarPage("Addresses");
	}
	
	@Test
	public void User_03_Switch_Page() {
		// Addresses =>Reward points
		addressesPage.openDynamicSideBarPageByName("Reward points");
		rewardPointPage = PageGeneratorManager.getRewardPointPage(driver);
		
		//Reward points => Customer Info
		rewardPointPage.openDynamicSideBarPageByName("Customer info");
		customerPage = PageGeneratorManager.getCustomerPage(driver);
		
		// Customer Info => Addresses
		customerPage.openDynamicSideBarPageByName("Addresses");
		addressesPage = PageGeneratorManager.getAddressesPage(driver);
		
		
		// Addresses => Downloadable products
		addressesPage.openDynamicSideBarPageByName("Downloadable products");
		downloadableProductPage = PageGeneratorManager.getDownloadableProductPage(driver);
	}

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
