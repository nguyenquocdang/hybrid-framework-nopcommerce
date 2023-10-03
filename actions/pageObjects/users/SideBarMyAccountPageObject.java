package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.PageGeneratorManager;
import pageUIs.users.SideBarMyAccountPageUI;

public class SideBarMyAccountPageObject extends BaseElement{
	WebDriver driver;
	
	public SideBarMyAccountPageObject (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public DownloadableProductPageObject openDownloadableProductPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.DOWNLOADABLE_PRODUCT_PAGE_LINK);
		return PageGeneratorManager.getDownloadableProductPage(driver);
	}
	
	public RewardPointPageObject openRewardPointPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.REWARD_POINT_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.REWARD_POINT_PAGE_LINK);
		return PageGeneratorManager.getRewardPointPage(driver);
	}
	
	public AddressesPageObject openAddressesPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.ADDRESSES_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.ADDRESSES_PAGE_LINK);
		return PageGeneratorManager.getAddressesPage(driver);
	}

	public CustomerPageObject openCustomerInforPage() {
		waitForElementClickable(driver, SideBarMyAccountPageUI.CUSTOMER_INFO_PAGE_LINK);
		clickToElement(driver, SideBarMyAccountPageUI.CUSTOMER_INFO_PAGE_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	
	public SideBarMyAccountPageObject openDynamicSideBarPage (String pageName) {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_lINK_TEXT, pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_lINK_TEXT, pageName);
	
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getCustomerPage(driver);
		case "Addresses":
			return PageGeneratorManager.getAddressesPage(driver);
		case "Downloadable products":
			return PageGeneratorManager.getDownloadableProductPage(driver);
		case "Reward points":
			return PageGeneratorManager.getRewardPointPage(driver);

		default:
			new RuntimeException("sidebar page name incorrect");
			return null;
		}
	}
	
	public void openDynamicSideBarPageByName (String pageName) {
		waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_lINK_TEXT, pageName);
		clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_lINK_TEXT, pageName);
	}
}
