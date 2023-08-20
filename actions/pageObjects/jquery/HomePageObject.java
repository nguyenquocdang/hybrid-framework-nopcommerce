package pageObjects.jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToColumnTextboxByName(String columnName, String valueToSend) {
		waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, columnName);
		sendkeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, valueToSend, columnName);
	}
	
	public void clickToPageByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
	}
	
	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
	}
	
	public boolean isRowValuesDisplayed(String female, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
	}
	
	public void clickToRowActionByCountryName(String country, String rowAction){
		waitForElementClickable(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
		clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
	}

	public List<String> getAllPageValuesByColumnName(String columnName) {
		List<String> allValues = new ArrayList<String>();
		
		// Bước 1: Lấy ra tất cả các page
		List<WebElement> allPageLinks = getListElement(driver, HomePageUI.ALL_PAGE_LINKS);
		
		int columnIndex = getListElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		
		// Bước 2: Duyệt qua từng page
		for (WebElement pageLink : allPageLinks) {
			pageLink.click();
			sleepInSecond(1);
			
			// Bước 3: Lấy ra tất cả các giá trị của 1 cột trong cái page đó -> lưu nó vào List/ Set/...
			List<WebElement> allRowValues = getListElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));
			
			for (WebElement rowValue : allRowValues) {
				allValues.add(rowValue.getText());
			}
		}
		//Sort ASC/DESC
		return allValues;
	}

	public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSend) {
		int columnIndex = getListElementsSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, valueToSend, rowIndex, String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownItem) {
		int columnIndex = getListElementsSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		selectDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, dropdownItem, dropdownItem, rowIndex, String.valueOf(columnIndex));
	}

	public void clickToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
		int columnIndex = getListElementsSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		
		waitForElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		checkToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
	}
	
		
	
	
}
