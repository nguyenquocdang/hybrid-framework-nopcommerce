package com.jquery.upload;

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
import pageObjects.jquery.UploadPageObject;

public class Level_13_Upload_File extends BaseTest{
	WebDriver driver;
	UploadPageObject uploadPage;
	String hueCity = "Hue.jpg";
	String nhatrangCity = "NT.jpg";
	String quangninhCity = "QN.jpg";
	
	String[] fileNames = {hueCity, nhatrangCity, quangninhCity};
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		uploadPage = PageGeneratorManager.getUploadPage(driver);
	}
	

	public void User_01_Upload_File() {
		uploadPage.uploadMultipleFiles(driver, hueCity);
		uploadPage.sleepInSecond(2);
		
		uploadPage.uploadMultipleFiles(driver, nhatrangCity);
		uploadPage.sleepInSecond(2);
		
		uploadPage.uploadMultipleFiles(driver, quangninhCity);
		uploadPage.sleepInSecond(2);
		
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hueCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(nhatrangCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(quangninhCity));
		
		uploadPage.clickStartButtonEachFile();
		
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(hueCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(nhatrangCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(quangninhCity));

	}
		

	public void User_02_Multiple_File() {
		uploadPage.refreshCurrentPage(driver);
		uploadPage.uploadMultipleFiles(driver, fileNames);
		
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hueCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(nhatrangCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(quangninhCity));
		
		uploadPage.clickStartButtonEachFile();
		
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(hueCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(nhatrangCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(quangninhCity));
	}
	
	@Test
	public void User_03_Upload_GoFile() {
		uploadPage.openUrl(driver, "https://gofile.io/uploadFiles");
		
		Assert.assertTrue(uploadPage.isLoadingIconAtMainContentDisappear());
		
		uploadPage.uploadMultipleFiles(driver, fileNames);
		
		Assert.assertTrue(uploadPage.isLoadingIconAtMainUploadDisappear());
		
		Assert.assertTrue(uploadPage.isMultipleProgressBarIconDisappear());

		Assert.assertTrue(uploadPage.isSuccessMessageDisplayed("Your files have been successfully uploaded"));
		
		uploadPage.clickToSuccessLink();
		
		Assert.assertTrue(uploadPage.isContentTableDisplayed());
		
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(hueCity));
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(nhatrangCity));
		Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(quangninhCity));
		
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(quangninhCity));
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(nhatrangCity));
		Assert.assertTrue(uploadPage.isPlayButtonDisplayed(quangninhCity));
	}
	

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}

}
