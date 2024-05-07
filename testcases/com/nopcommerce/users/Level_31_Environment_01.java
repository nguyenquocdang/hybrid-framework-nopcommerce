package com.nopcommerce.users;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.DownloadableProductPageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPointPageObject;
import reportConfig.ExtentTestManager;
import utilities.FakerConfig;

public class Level_31_Environment_01 extends BaseTest{

	@Parameters({"browser", "server"})
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		driver = getBrowserEnvironment(browserName, serverName);
		
	}

	@Test
	public void User_01_Register_Validate(Method method) {

	}
	
	@Test
	public void User_02_Register_Success(Method method) {

	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}
	
	WebDriver driver;

}
