package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

public class QualificationsPageObject extends BaseActions {
	WebDriver driver;
	
	public QualificationsPageObject (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
