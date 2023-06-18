package com.nopcommerce.users;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Register {
	// Yêu cầu:
	// Viết làm sao để có thể chạy được
	// Ko quan tâm tối ưu
	// Có thể lặp lại nhiều step giống nhau

	// RY: Repeat Yourself
	// DRY: Don't Repeat Yourself

	// Ưu điểm:
	// Tốc độ rất nhanh - cho phép lặp lại nhiều lần
	// Code mẫu vài TC để hiểu được cách dùng tool nào đó (PoC)
	// Phù hợp dự án làm nhanh/ ngắn hạng/ thử nghiệm

	// Nhược điểm:
	// Sự lặp lại rất nhiều step: Locator/ Hàm Selenium
	// Phí bảo trì tăng lên khi có sự thay đổi: Logic/ Business/ thư viện/ UI
	// Không phù hợp với Framework
	// Không phù hợp để làm dự án auto có time dài/ mang lại nhiều value

	// Nguyên tắc: Có thể tại sử dụng được và hạn chế/ tránh sự lặp lại

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void Register_01_Empty_Data() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.xpath("//a[text()='Register']")).click();

		driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='First name is required.']")).getText(),
				"First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(),
				"Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
				"Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
				"Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.xpath("//a[text()='Register']")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("John");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Wick");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("john@wick@gmail.com");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
	}

	@Test
	public void Register_03_Invalid_Password() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.xpath("//a[text()='Register']")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("John");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Wick");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("johnwick@gmail.com");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");

		driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.xpath("//a[text()='Register']")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("John");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Wick");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("johnwick@gmail.com");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123654");

		driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
				"The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Success() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.xpath("//a[text()='Register']")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("John");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Wick");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(getEmailAddress());
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String getEmailAddress() {
		Random rand = new Random();
		return "john" + rand.nextInt(9999) + "@gmail.com";
	}

}
