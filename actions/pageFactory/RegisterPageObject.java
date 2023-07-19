package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(css="button#register-button")
	WebElement registerButton;
	
	@FindBy(id="FirstName-error")
	WebElement firstNameErrorMsg;
	
	@FindBy(id="LastName-error")
	WebElement lastNameErrorMsg;
	
	@FindBy(id="Email-error")
	WebElement emailErrorMsg;
	
	@FindBy(id="Password-error")
	WebElement passwordErrorMsg;
	
	@FindBy(id="ConfirmPassword-error")
	WebElement confirmPasswordErrorMsg;
	
	@FindBy(css="div.result")
	WebElement registerSuccessMsg;
	
	@FindBy(id="FirstName")
	WebElement firstNameTextbox;
	
	@FindBy(id="LastName")
	WebElement lastNameTextbox;
	
	@FindBy(id="Email")
	WebElement emailTextbox;
	
	@FindBy(id="Password")
	WebElement passwordTextbox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTextbox;
	
	@FindBy(xpath="//div[@class='header-logo']//img")
	WebElement homePageLogo;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, firstNameErrorMsg);
		return getElementText(driver, firstNameErrorMsg);
	}

	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, lastNameErrorMsg);
		return getElementText(driver, lastNameErrorMsg);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMsg);
		return getElementText(driver, emailErrorMsg);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, passwordErrorMsg);
		return getElementText(driver, passwordErrorMsg);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, confirmPasswordErrorMsg);
		return getElementText(driver, confirmPasswordErrorMsg);
	}

	public void clickToHomePageLogo() {
		waitForElementClickable(driver, homePageLogo);
		clickToElement(driver, homePageLogo);
	}

	public void enterToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void enterToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}

	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void enterToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMsg);
		return getElementText(driver, registerSuccessMsg);
	}

}
