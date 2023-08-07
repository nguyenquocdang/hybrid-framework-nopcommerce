package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Rest_Parameter {
	String addressLink = "//div[@class='listbox']//a[text()='Addresses']";
	String downloadableProductLink = "//div[@class='listbox']//a[text()='Downloadable products']";
	
	String dynamicSideBarLink = "//div[@class='listbox']//a[text()='%s']";
	
	String dynamicLink = "//div[@class='%s']//a[text()='%s']";
	String dynamicMenuLink = "//div[@class='%s']/div[@id='%s']/a[text()='%s']";
	
	
	@Test
	public void TC_01_Rest_Param() {
		// Cố định
		clickToElement(addressLink);
		clickToElement(downloadableProductLink);
		
		// 1 param
		clickToElement(dynamicSideBarLink, "Addresses");
		clickToElement(dynamicSideBarLink, "Downloadable products");
		clickToElement(dynamicSideBarLink, "Customer info");
		
		// 2 param
		clickToElement(dynamicLink, "footer", "Orders");
		clickToElement(dynamicLink, "footer", "Blog");
		clickToElement(dynamicLink, "header", "Register");
		clickToElement(dynamicLink, "header", "Login");
		
		// 3 param
		clickToElement(dynamicMenuLink, "header", "computer", "Lenovo");
		
	}
	
//	// Hàm để click vào 1 element cố định
//	public void clickToElement(String locatorValue) {
//		System.out.println("Click to: " + locatorValue);
//	}
//	
//	// Hàm để click vào 1 element ko cố định (dynamic) vs 1 tham số
//	public void clickToElement(String locatorValue, String pageName) {
//		locatorValue = String.format(locatorValue, pageName);
//		System.out.println("Click to: " + locatorValue);
//	}
//	
//	// Hàm để click vào 1 element ko cố định (dynamic) vs 2 tham số
//	public void clickToElement(String locatorValue, String pageType, String pageName) {
//		locatorValue = String.format(locatorValue, pageType, pageName);
//		System.out.println("Click to: " + locatorValue);
//	}
//	
//	// Hàm để click vào 1 element ko cố định (dynamic) vs 3 tham số
//	public void clickToElement(String locatorValue, String pageType, String categoryType, String pageName) {
//		locatorValue = String.format(locatorValue, pageType, categoryType, pageName);
//		System.out.println("Click to: " + locatorValue);
//	}
//	
//	// Hàm để click vào 1 element ko cố định (dynamic) vs 4 tham số
//	public void clickToElement(String locatorValue, String female, String country, String male, String total) {
//		locatorValue = String.format(locatorValue, female, country, male, total);
//		System.out.println("Click to: " + locatorValue);
//	}
	
	// Var Argument = Rest Parameter
	// Hàm để click vào 1 element ko cố định (dynamic) vs bất kì tham số nào (1 - n tham số)
	public void clickToElement(String locatorValue, String... values) { // Mảng String[]
		locatorValue = String.format(locatorValue, (Object[]) values);
		System.out.println("Click to: " + locatorValue);
	}
	
	
}
