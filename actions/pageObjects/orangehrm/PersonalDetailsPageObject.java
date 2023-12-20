package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import pageUIs.orangehrm.PersonalDetailsPageUI;

public class PersonalDetailsPageObject extends BaseActions {
	WebDriver driver;
	
	public PersonalDetailsPageObject (WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getFirstNameValue() {
		waitForElementVisible(driver, PersonalDetailsPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, PersonalDetailsPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameValue() {
		waitForElementVisible(driver, PersonalDetailsPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, PersonalDetailsPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmployeeIDValue() {
		waitForElementVisible(driver, PersonalDetailsPageUI.EMPLOYEE_ID_TEXTBOX);
		return getElementAttribute(driver, PersonalDetailsPageUI.EMPLOYEE_ID_TEXTBOX, "value");
	}

	public EmployeeListPageObject clickToEmployeeListButton() {
		waitForElementClickable(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BUTTON);
		clickToElement(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BUTTON);
		return PageGeneratorManager.getEmployeeListPage(driver);
	}

	public boolean isPersonalDetailsHeaderDisplayed() {
		waitForElementVisible(driver, PersonalDetailsPageUI.PERSONAL_DETAILS_PAGE_HEADER);
		return isElementDisplayed(driver, PersonalDetailsPageUI.PERSONAL_DETAILS_PAGE_HEADER);
	}

	public void enterToNicknameTextbox(String nickName) {
		waitForElementVisible(driver, PersonalDetailsPageUI.NICKNAME_TEXTBOX);
		sendkeyToElement(driver, PersonalDetailsPageUI.NICKNAME_TEXTBOX, nickName);
	}

	public void enterToDriverLicenseNumberTextbox(String driverLicense) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX, driverLicense);
	}

	public void enterToLicenseExpiryDatePicker(String driverLicenseExpiryDate) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_EXPIRY_DATE_PICKER);
		sendkeyToElement(driver, PersonalDetailsPageUI.DRIVER_EXPIRY_DATE_PICKER, driverLicenseExpiryDate);
	}

	public void enterToSocialSecurityNumberTextbox(String ssNumber) {
		waitForElementVisible(driver, PersonalDetailsPageUI.SOCIAL_SECURITY_NUMBER_CHECKBOX);
		sendkeyToElement(driver, PersonalDetailsPageUI.SOCIAL_SECURITY_NUMBER_CHECKBOX, ssNumber);
	}

	public void enterToSocialInsuranceNumberTextbox(String siNumber) {
		waitForElementVisible(driver, PersonalDetailsPageUI.SOCIAL_INSURANCE_NUMBER_CHECKBOX);
		sendkeyToElement(driver, PersonalDetailsPageUI.SOCIAL_INSURANCE_NUMBER_CHECKBOX, siNumber);
	}

	public void selectToNationalityDropdown(String nationalityName) {
		waitForElementClickable(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_PARENT);
		selectItemInCustomDropdown(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_CHILD_ITEM, nationalityName);
	}

	public void selectToMaritalStatusDropdown(String maritalStatus) {
		waitForElementClickable(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_PARENT);
		selectItemInCustomDropdown(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_CHILD_ITEM, maritalStatus);
	}

	public void enterToDateOfBirtgDatePicker(String dateOfBirth) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_PICKER);
		sendkeyToElement(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_PICKER, dateOfBirth);
	}

	public void clickToSaveButtonAtPersonalDetailPart() {
		waitForElementClickable(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_PERSONAL_DETAIL);
		clickToElement(driver, PersonalDetailsPageUI.SAVE_BUTTON_AT_PERSONAL_DETAIL);
	}

	public String getNationalityDropdownSelectedText() {
		return getElementText(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_SELECTED_TEXT);
	}

	public String getMaritalStatusDropdownSelectedText() {
		return getElementText(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_SELECTED_TEXT);
	}



}
