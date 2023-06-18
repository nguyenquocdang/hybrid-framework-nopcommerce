package commons;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	// Chứa những hàm dùng chung cho cả layer page objects
    //	1 - Access Modifier: public/ protected/ private/ default
    
	//	2 - Kiểu dữ liệu của hàm (Data type): void/ int/ String/ boolean/ WebElement/ List<WebElement>/..
    //	Nó sẽ liên quan đến cái chức năng mình viết trong thân hàm
    
	//	3 - Tên hàm: Đặt tên có nghĩa theo chức năng đang cần viết
	// Đặt tên gọn gàng giống viết văn nói
    //	Convention tuân theo chuẩn của từng ngôn ngữ lập trình (Java)
    //	camelCase: từ đầu tiên viết thường - chữ cái đầu tiên của các từ tiếp theo sẽ viết hoa
   
	//	4 - Có tham số hay ko (tùy vào chức năng cần viết)
	// Dựa vào hàm của Selenium mình gọi ra để dùng là gì
	// Web Browser: WebDriver driver
	// WebElement: WebDriver driver, String locator
   
	//	5 - Kiểu dữ liệu trả về cho hàm
    //	Nếu như có return dữ liệu thì sẽ khớp vs kiểu dữ liệu ở số 2
    //	Nếu như có return thì nó là cái step cuối cùng

	public void openUrl(WebDriver driver, String url) {
		// 2 + 4 + 5
		driver.get("url");
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void acceptToAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelToAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void senKeyToAlert(WebDriver driver, String valueToSenkey) {
		waitForAlertPresence(driver).sendKeys(valueToSenkey);
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allIDs =  driver.getWindowHandles();
		
		for (String id  : allIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allIDs =  driver.getWindowHandles();

		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
			
		}
		
	}

	public void closeAllWindowWithoutExpectedID(WebDriver driver, String expectedID) {
		Set<String> allIDs =  driver.getWindowHandles();

		for (String id : allIDs) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(expectedID); 
	}
	
	private void sleepInSecond(long timeoutInSeconds) {
		try {
			Thread.sleep(timeoutInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
