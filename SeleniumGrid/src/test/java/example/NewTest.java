package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	String driverPath = "/usr/bin/chromedriver";
	public WebDriver driver;

	@Test
	public void test1() {
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Test test");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}

	@AfterClass
	public void afterClass() {
	}

}
