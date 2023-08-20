package pageObjects.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.UploadPageUI;

public class UploadPageObject extends BasePage{
	WebDriver driver;
	
	public UploadPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedSuccess(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
	}

	public void clickStartButtonEachFile() {
		List<WebElement> startButtons = getListElement(driver, UploadPageUI.MULTIPLE_START_BUTTON);
		for (WebElement button : startButtons) {
			waitForElementClickable(driver, button);
			clickToElement(driver, button);
			sleepInSecond(2);
		}
	}

	public boolean isFileUploadedSuccess(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
	}

	public boolean isLoadingIconAtMainContentDisappear() {
		return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_CONTENT);
	}

	public boolean isLoadingIconAtMainUploadDisappear() {
		return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_UPLOAD);
	}

	public boolean isMultipleProgressBarIconDisappear() {
		return waitForListElementInvisible(driver, UploadPageUI.MULTIPLE_PROGRESS_BAR_ICON);
	}

	public boolean isSuccessMessageDisplayed(String successMessage) {
		waitForElementVisible(driver, UploadPageUI.UPLOADED_SUCCESS_MASSAGE, successMessage);
		return isElementDisplayed(driver, UploadPageUI.UPLOADED_SUCCESS_MASSAGE, successMessage);
	}

	public void clickToSuccessLink() {
		waitForElementClickable(driver, UploadPageUI.UPLOADED_SUCCESS_LINK);
		clickToElement(driver, UploadPageUI.UPLOADED_SUCCESS_LINK);
	}

	public boolean isContentTableDisplayed() {
		waitForElementVisible(driver, UploadPageUI.CONTENT_TABLE);
		return isElementDisplayed(driver, UploadPageUI.CONTENT_TABLE);
	}

	public boolean isDownloadButtonDisplayed(String fileNames) {
		waitForElementVisible(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_FILE_NAME, fileNames);
		return isElementDisplayed(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_FILE_NAME, fileNames);
	}

	public boolean isPlayButtonDisplayed(String fileNames) {
		waitForElementVisible(driver, UploadPageUI.PLAY_BUTTON_BY_FILE_NAME, fileNames);
		return isElementDisplayed(driver, UploadPageUI.PLAY_BUTTON_BY_FILE_NAME, fileNames);
	}
}