package com.saucelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import pageObject.saucelab.LoginPageObject;
import pageObject.saucelab.PageGeneratorManager;
import pageObject.saucelab.ProductPageObject;

public class Level_31_Sort_ASC_DESC extends BaseTest{
	private WebDriver driver;
	private LoginPageObject loginPage;
	private ProductPageObject productPage;
	
	
	@Parameters({"browser", "url"})
	@BeforeMethod
	public void beforeMethod(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		loginPage.enterToUserName("standard_user");
		loginPage.enterToPassword("secret_sauce");
		productPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		productPage.selectItemInSortDropdown("Name (A to Z)");
		Assert.assertTrue(productPage.isProductNameSortByAscending());
		
		productPage.selectItemInSortDropdown("Name (Z to A)");
		Assert.assertTrue(productPage.isProductNameSortByDescending());

	}
	
	@Test
	public void Sort_02_Price() {
		productPage.selectItemInSortDropdown("Price (low to high)");
		Assert.assertTrue(productPage.isProductPriceSortByAscending());

		productPage.selectItemInSortDropdown("Price (high to low)");
		Assert.assertTrue(productPage.isProductPriceSortByDescending());

	}
	
	@AfterMethod
	public void afterMethod() {
		quitBrowserDriver();
	}
	

	
}
