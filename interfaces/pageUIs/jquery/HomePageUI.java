package pageUIs.jquery;

public class HomePageUI {
	
	public static final String COLUMN_TEXTBOX_BY_NAME = "Xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String PAGE_LINK_BY_NUMBER = "Xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGE_LINK_ACTIVE_BY_NUMBER = "Xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String DYNAMIC_ROW_VALUES = "Xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String ROW_ACTION_BY_COUNTRY_NAME = "Xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";
	
	
	public static final String ALL_PAGE_LINKS = "XPATH=//a[contains(@class,'qgrd-pagination-page-link')]";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "XPATH=//div[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String ALL_VALUE_BY_COLUMN_INDEX = "XPATH=//tr/td[%s]";
	
	
	public static final String DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME = "XPATH=//th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "XPATH=//tr[%s]/td[%s]/input";
	
	public static final String DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX = "XPATH=//tr[%s]/td[%s]//select";
	public static final String DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "XPATH=//tr[%s]/td[%s]//input[@type='checkbox']";
}
