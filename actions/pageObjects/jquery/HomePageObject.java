package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver= driver;
	}
	
	public void inputToColumnTextboxByName(String columnName, String valueToSend) {
		waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, columnName);
		sendkeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, valueToSend, columnName);
	}
	
}
