package com.jquery.table;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_12_Handle_DataTable extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	List<String> allValueUI = new ArrayList<String>();
	List<String> allValueDB = new ArrayList<String>();
	List<String> allValueAPI = new ArrayList<String>();
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	public void User_01_Search() {
		// Search dữ liệu trong 1 Table (trên Header)
		homePage.inputToColumnTextboxByName("Females", "283821");
		homePage.sleepInSecond(2);
		
		homePage.inputToColumnTextboxByName("Males", "295140");
		homePage.sleepInSecond(2);
		
		homePage.inputToColumnTextboxByName("Country", "Afghanistan");
		homePage.sleepInSecond(2);
		
		homePage.inputToColumnTextboxByName("Total", "791312");
		homePage.sleepInSecond(2);
	}
	
	public void User_02_Paging() {
		// Click to any page
		homePage.clickToPageByNumber("10");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("10"));
		
		homePage.clickToPageByNumber("21");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("21"));
		
		homePage.clickToPageByNumber("7");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("7"));
	}
	

	public void User_03_Displayed() {
		// Verify cho any row
		Assert.assertTrue(homePage.isRowValuesDisplayed("384187", "Afghanistan", "407124", "791312"));
		
		Assert.assertTrue(homePage.isRowValuesDisplayed("276880", "Angola", "276472", "553353"));
		
		Assert.assertTrue(homePage.isRowValuesDisplayed("338282", "Argentina", "349238", "687522"));
	}


	public void User_04_Icon_Button_Checkbox() {
		// Click vào bất kì 1 cái icon/ button/ checkbox... của 1 row nào đó
		// Tìm đc 1 key là duy nhất của row đó so với các row khác
		
		homePage.clickToRowActionByCountryName("Afghanistan", "remove");
		homePage.clickToRowActionByCountryName("AFRICA", "remove");
		homePage.clickToRowActionByCountryName("Albania", "remove");
		homePage.clickToRowActionByCountryName("Algeria", "remove");
		homePage.clickToRowActionByCountryName("Angola", "remove");
		
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToRowActionByCountryName("Afghanistan", "edit");
		homePage.refreshCurrentPage(driver);
		homePage.clickToRowActionByCountryName("Albania", "edit");
		homePage.refreshCurrentPage(driver);

	}
	
	
	public void User_05_Get_All_Column_Values() {
		// UI
		allValueUI = homePage.getAllPageValuesByColumnName("Country");
		
		// API: Rest Assured/ Karate/...
		// allValueAPI = homePage.getAllPageValuesByColumnNameInAPI("Country");
		
		//DB: JTDS/ SQL/...
		// allValueDB = homePage.getAllPageValuesByColumnNameInDB("Country");
		
		Assert.assertEquals(allValueUI, allValueDB);
		
		homePage.getAllPageValuesByColumnName("Total");
	}
	
	
	@Test
	public void User_06_Action_By_Index() {
		homePage.openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
	
		// Nhập vào textbox tại cột Contact Person tại dòng thứ 2
		homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "2", "Lionel Messi");
		homePage.enterToTextboxByColumnNameAndRowIndex("Company", "1", "Manchester");
		
		// Select dữ liệu tại cột Country tại dòng thứ 3
		homePage.selectDropdownByColumnNameAndRowIndex("Country", "3", "United Kingdom");
		homePage.selectDropdownByColumnNameAndRowIndex("Country", "1", "Japan");
		
		
		// Click vào checkbox tại cột NPO? tại dòng thứ 1
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "2");
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "1");
		homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "3");
	}
		
	

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
