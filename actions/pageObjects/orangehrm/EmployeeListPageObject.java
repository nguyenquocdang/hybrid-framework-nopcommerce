package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import pageUIs.orangehrm.EmployeeListPageUI;
import pageUIs.orangehrm.PersonalDetailsPageUI;

public class EmployeeListPageObject extends BaseActions {
	WebDriver driver;
	
	public EmployeeListPageObject (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public AddEmployeePageObject clickToAddEmployeeButton() {
		waitForElementClickable(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
		clickToElement(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
		waitForSpinnerIconInvisible();
		return PageGeneratorManager.getEmployeePage(driver);
	}

	public void enterToEmployeeIDTextbox(String employeeID) {
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX);
		sendkeyToElement(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX, employeeID);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, EmployeeListPageUI.SEARCH_BUTTON);	
		clickToElement(driver, EmployeeListPageUI.SEARCH_BUTTON);
		waitForSpinnerIconInvisible();
	}

	public PersonalDetailsPageObject clickToEditIconByEmployeeID(String employeeID) {
		waitForElementVisible(driver, EmployeeListPageUI.EDIT_ICON_BY_EMPLOYEE_ID, employeeID);
		clickToElement(driver, EmployeeListPageUI.EDIT_ICON_BY_EMPLOYEE_ID, employeeID);
		waitForSpinnerIconInvisible();
		return PageGeneratorManager.getPersonalDetailsPage(driver);
	}




}
