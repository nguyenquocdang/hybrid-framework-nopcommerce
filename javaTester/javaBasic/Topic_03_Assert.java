package javaBasic;

import org.testng.Assert;

public class Topic_03_Assert {

	public static void main(String[] args) {
		// True/ False: Nó sẽ nhận vào tham số là kiểu dữ liệu boolean
		// isDisplayed/ isSelected/ isEnable/ isMultiple -> boolean
		// wait trả về boolean
		// isPageLoadedSuccess/ isImageLoaded/ waitForElementInvisible... -> boolean
		// Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
		
		boolean status = true;
		Assert.assertTrue(status);
		
		status = false;
		Assert.assertTrue(status);
		
		// Equals: Nó sẽ nhận vào 2 tham số có kiểu dữ liệu tương ứng nhau
		// getText/ getAttribut/ getCss/ getSize/...
		
		String fullName = "Automation FC";
		Assert.assertEquals(fullName, "Automation FC");
		
	}

}
