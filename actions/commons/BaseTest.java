package commons;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {
	private WebDriver driver;
	
	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case CHROME:
			// driver = WebDriverManager.chromedriver().create();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			// driver = WebDriverManager.firefoxdriver().create();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			// driver = WebDriverManager.edgedriver().create();
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser name is not valid.");
		}

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
//		driver.manage().window().setSize(new Dimension(1920, 1080));
//		driver.manage().window().setPosition(new Point(0, 0));
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String url) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case CHROME:
			// driver = WebDriverManager.chromedriver().create();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			// driver = WebDriverManager.firefoxdriver().create();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			// driver = WebDriverManager.edgedriver().create();
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser name is not valid.");
		}

		driver.get(url);
		driver.manage().window().maximize();
//		driver.manage().window().setSize(new Dimension(1920, 1080));
//		driver.manage().window().setPosition(new Point(0, 0));
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		return driver;
	}
	
	protected String getEmailAddress() {
		Random rand = new Random();
		return "john" + rand.nextInt(9999) + "@gmail.com";
	}
	
	protected void quitBrowserDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
