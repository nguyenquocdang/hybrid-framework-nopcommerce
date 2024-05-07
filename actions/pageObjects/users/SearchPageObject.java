package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import io.qameta.allure.Step;
import pageUIs.users.HomePageUI;
import pageUIs.users.RegisterPageUI;
import pageUIs.users.SearchPageUI;

public class SearchPageObject extends BaseElement{
	private WebDriver driver;
	
	public SearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void entertoSearchTextbox(String value) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, value);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}



}
