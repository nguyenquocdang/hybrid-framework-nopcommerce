package com.orangehrm.pim;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.orangehrm.AddEmployeePageObject;
import pageObjects.orangehrm.DashboardPageObject;
import pageObjects.orangehrm.EmployeeListPageObject;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.PageGeneratorManager;
import pageObjects.orangehrm.PersonalDetailsPageObject;
import pojoData.orangeHRM.EmployeeInfo;
import reportConfig.ExtentTestManager;

public class PIM_01_Employee extends BaseTest{
	private WebDriver driver;
	private String browserName;
	private LoginPageObject loginPage;
	private EmployeeInfo employeeInfo;
	private DashboardPageObject dashboardPage;
	private EmployeeListPageObject employeeListPage;
	private AddEmployeePageObject addEmployeePage;
	private PersonalDetailsPageObject personalDetailsPage;
	
	
	@Parameters({"url","browser"})
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		driver = getBrowserDriver(browserName, url);
		this.browserName = browserName;
		loginPage = PageGeneratorManager.getLoginPage(driver);
		employeeInfo = EmployeeInfo.getEmployee();
		
		employeeInfo.setFirstName("Michael");
		employeeInfo.setLastName("Owen");
		employeeInfo.setNickName("golden_boy");
		employeeInfo.setDriverLicenseNumber("D08954796");
		employeeInfo.setLicenseExpiryDate("2024-01-03");
		employeeInfo.setSsnNumber("428-53-1251");
		employeeInfo.setSinNumber("968563231");
		employeeInfo.setNationality("American");
		employeeInfo.setMaritalStatus("Married");
		employeeInfo.setDateOfBirth("1986-10-10");
		employeeInfo.setGenderStatus("Male");
		employeeInfo.setSmokerStatus("Yes");
		
		loginPage.enterToUsernameTextbox(GlobalConstants.ADMIN_ORANGE_HRM_USERNAME);
		loginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_ORANGE_HRM_PASSWORD);
		dashboardPage = loginPage.clickToLoginButton();
		
		employeeListPage = dashboardPage.openPIMModule();
	}
	
	@Test
	public void Employee_01_Add_New(Method method) {
		ExtentTestManager.startTest(method.getName(), "Employee_01_Add_New");

		addEmployeePage = employeeListPage.clickToAddEmployeeButton();
		
		addEmployeePage.enterToFirstNameTextbox(employeeInfo.getFirstName());
		addEmployeePage.enterToLastNameTextbox(employeeInfo.getLastName());
		
		employeeInfo.setEmployeeID(addEmployeePage.getEmployeeID());
		
		addEmployeePage.clickSaveButton();
		
		Assert.assertTrue(addEmployeePage.isSuccessMessageDisplayed("Successfully Saved"));
		addEmployeePage.waitForSpinnerIconInvisible();
		
		personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);
		
		Assert.assertTrue(personalDetailsPage.isPersonalDetailsHeaderDisplayed());
		personalDetailsPage.waitForSpinnerIconInvisible();
		
		Assert.assertEquals(personalDetailsPage.getFirstNameValue(), employeeInfo.getFirstName());
		Assert.assertEquals(personalDetailsPage.getLastNameValue(), employeeInfo.getLastName());
		Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeInfo.getEmployeeID());
		
		employeeListPage = personalDetailsPage.clickToEmployeeListButton();
		
		employeeListPage.enterToEmployeeIDTextbox(employeeInfo.getEmployeeID());
		employeeListPage.clickToSearchButton();
		
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Id", "1", employeeInfo.getEmployeeID()));
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("First (& Middle) Name", "1", employeeInfo.getFirstName()));
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Last Name", "1", employeeInfo.getLastName()));
	}
	
	@Test
	public void Employee_02_Personal_Details(Method method) {
		ExtentTestManager.startTest(method.getName(), "Employee_02_Personal_Details");

		personalDetailsPage = employeeListPage.clickToEditIconByEmployeeID(employeeInfo.getEmployeeID());
		
		Assert.assertTrue(personalDetailsPage.isPersonalDetailsHeaderDisplayed());
		
		Assert.assertEquals(personalDetailsPage.getFirstNameValue(), employeeInfo.getFirstName());
		Assert.assertEquals(personalDetailsPage.getLastNameValue(), employeeInfo.getLastName());
		Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeInfo.getEmployeeID());
		
		personalDetailsPage.setPersonalDetail(employeeInfo);
		
		personalDetailsPage.clickToSaveButtonAtPersonalDetailPart();
		
		Assert.assertTrue(personalDetailsPage.isSuccessMessageDisplayed("Successfully Updated"));
		personalDetailsPage.waitForSpinnerIconInvisible();
		
		Assert.assertEquals(personalDetailsPage.getNationalityDropdownSelectedText(), employeeInfo.getNationality());
		Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownSelectedText(), employeeInfo.getMaritalStatus());
		
		Assert.assertTrue(personalDetailsPage.isRadioButtonSelectedByLabelName(employeeInfo.getGenderStatus()));
		Assert.assertTrue(personalDetailsPage.isCheckboxSelectedByLabelName(employeeInfo.getSmokerStatus()));
	}
	
	@Test
	public void Employee_03_Contact_Details(Method method) {
		ExtentTestManager.startTest(method.getName(), "Employee_03_Contact_Details");

	}
	
	@Test
	public void Employee_04_Emergency_Contacts(Method method) {
		ExtentTestManager.startTest(method.getName(), "Employee_04_Emergency_Contacts");

	}
	
	@Test
	public void Employee_05_Dependents(Method method) {
		ExtentTestManager.startTest(method.getName(), "Employee_05_Dependents");

	}
	
	@Test
	public void Employee_06_Immigration(Method method) {
		ExtentTestManager.startTest(method.getName(), "Employee_06_Immigration");

	}
	
	@Test
	public void Employee_07_Job(Method method) {
		ExtentTestManager.startTest(method.getName(), "Employee_07_Job");

	}
	
	@Test
	public void Employee_08_Salary(Method method) {
		ExtentTestManager.startTest(method.getName(), "Employee_08_Salary");

	}
	
	@Test
	public void Employee_09_Report(Method method) {
		ExtentTestManager.startTest(method.getName(), "Employee_09_Report");

	}
	
	@Test
	public void Employee_10_Qualification(Method method) {
		ExtentTestManager.startTest(method.getName(), "Employee_10_Qualification");

	}
	
	

	@AfterClass
	public void afterClass() {
//		quitBrowserDriver();
	}
	
	
}
