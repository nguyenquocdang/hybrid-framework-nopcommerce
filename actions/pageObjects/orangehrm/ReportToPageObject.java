package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

public class ReportToPageObject extends BaseActions {
	WebDriver driver;
	
	public ReportToPageObject (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
