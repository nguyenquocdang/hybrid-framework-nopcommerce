package commons;

import java.io.File;
import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	protected final Logger log;
	
	public BaseTest() {
		log = LogManager.getLogger(getClass());
	}
	
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

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info("-----------------PASSED-----------------");
		} catch (Throwable e) {
			log.info("-----------------FAILED-----------------");
			pass = false;

			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("-----------------PASSED-----------------");
		} catch (Throwable e) {
			log.info("-----------------FAILED-----------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("-----------------PASSED-----------------");
		} catch (Throwable e) {
			log.info("-----------------FAILED-----------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	@BeforeSuite
	public void deleteFileInReport() {
		deleteAllFileInFolder("reportNGImage");
		deleteAllFileInFolder("allure-json");
	}
	
	public void deleteAllFileInFolder(String folderName) {
		try {
			String pathFolderDownload = GlobalConstants.RELATIVE_PROJECT_PATH + File.separator + folderName;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}
}
