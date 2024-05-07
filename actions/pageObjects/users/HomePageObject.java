package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.users.HomePageUI;

public class HomePageObject extends BaseElement{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Click to Register link")
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	@Step("Click to Login link")
	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	@Step("Click to My Account link")
	public CustomerPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	
	public CustomerPageObject openMyAccountLink() {
		String myAccountLink = getElementAttribute(driver, HomePageUI.MY_ACCOUNT_LINK, "href");
		openUrl(driver, myAccountLink);
		return PageGeneratorManager.getCustomerPage(driver);
	}

	@Step("Verify the Register link is displayed")
	public boolean isRegisterLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
		
	}

	public SearchPageObject clickToSearchLink() {
		waitForElementClickable(driver, HomePageUI.SEARCH_LINK);
		clickToElement(driver, HomePageUI.SEARCH_LINK);
		return PageGeneratorManager.getSearchPage(driver);
	}
}
