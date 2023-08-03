package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DownloadableProductPageObject extends SideBarMyAccountPageObject {
	WebDriver driver;
	
	public DownloadableProductPageObject(WebDriver driver) {
		this.driver = driver;
	}	
	
}
