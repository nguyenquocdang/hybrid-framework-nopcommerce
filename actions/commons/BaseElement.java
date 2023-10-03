package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.users.HomePageObject;
import pageUIs.users.BaseElementUI;
import pageUIs.users.CustomerPageUI;

public class BaseElement extends BasePage {
	WebDriver driver;
	
	public BaseElement(WebDriver driver) {
		this.driver = driver;
	}

	// Hàm này theo business là bất kì 1 page nào cũng nhìn thấy để thao tác lên nó được
	public HomePageObject clickToHomePageLogo() {
		waitForElementClickable(driver, BaseElementUI.HOME_LOGO_IMAGE);
		clickToElement(driver, BaseElementUI.HOME_LOGO_IMAGE);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	
	// Theo business thì bất kì page nào cũng gọi ra dùng được 
	public void clickToHeaderLinkByName(String pageName) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
		clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
	}
	
	// Thao tác với bất kì 1 button ở page nào
	public void clickToButtonByText(String buttonText) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
	}
	
	// Get ra error message của Textbox tại bất kì page nào
	public String getTextboxErrorMessageByID(String errorMessageID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID, errorMessageID);
		return getElementText(driver, BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID, errorMessageID);
	}
	
	// Nhập vào 1 textbox bất kì tại bất kì page nào
	public void enterToTextboxByID(String textboxID, String valueToSendkey) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, valueToSendkey, textboxID);
	}
	
	// Get ra attribute của textbox tại bất kì page nào
	public String getTextboxAttributeByID(String textboxID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}
	
}
