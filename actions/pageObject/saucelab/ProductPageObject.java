package pageObject.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.ProductPageUI;

public class ProductPageObject extends BasePage{
	private WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortDropdown(String sortItem) {
		waitForElementClickable(driver, ProductPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.SORT_DROPDOWN, sortItem);
		sleepInSecond(3);
	}

	public boolean isProductNameSortByAscending() {
		// Bước 1: Lấy hết Product name lưu lại
		List<WebElement> allProductNameText = getListElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		
		List<String> actualProductName = new ArrayList<String>();
		
		for (WebElement productName : allProductNameText) {
			actualProductName.add(productName.getText());
		}
		
		// Bước 2: Clone data từ bước 1 ra thành 1 dữ liệu mới
		List<String> expectedProductName = new ArrayList<String>();
		for (String name : actualProductName) {
			expectedProductName.add(name);
		}
		
		// Bước 3: Cho sort dữ liệu ở bước 2
		Collections.sort(expectedProductName);
		
		// Bước 4: Verify dữ liệu trước và sau khi sort giống nhau
		return actualProductName.equals(expectedProductName);
	}

	public boolean isProductNameSortByDescending() {
		List<WebElement> allProductNameText = getListElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		
		List<String> actualProductName = new ArrayList<String>();
		
		for (WebElement productName : allProductNameText) {
			actualProductName.add(productName.getText());
		}
		
		List<String> expectedProductName = new ArrayList<String>();
		for (String name : actualProductName) {
			expectedProductName.add(name);
		}
		
		Collections.sort(expectedProductName);
		Collections.reverse(expectedProductName);
		
		return actualProductName.equals(expectedProductName);
	}

	public boolean isProductPriceSortByAscending() {
		List<WebElement> allProductPriceText = getListElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		
		List<Float> actualProductPrice = new ArrayList<Float>();
		
		for (WebElement productPrice : allProductPriceText) {
			actualProductPrice.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}
		
		List<Float> expectedProductPrice = new ArrayList<Float>();
		for (Float price : actualProductPrice) {
			expectedProductPrice.add(price);
		}
		
		Collections.sort(expectedProductPrice);
		
		return actualProductPrice.equals(expectedProductPrice);
	}

	public boolean isProductPriceSortByDescending() {
		List<WebElement> allProductPriceText = getListElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		
		List<Float> actualProductPrice = new ArrayList<Float>();
		
		for (WebElement productPrice : allProductPriceText) {
			actualProductPrice.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}
		
		List<Float> expectedProductPrice = new ArrayList<Float>();
		for (Float price : actualProductPrice) {
			expectedProductPrice.add(price);
		}
		
		Collections.sort(expectedProductPrice);
		Collections.reverse(expectedProductPrice);
		
		return actualProductPrice.equals(expectedProductPrice);
	}
	


}
