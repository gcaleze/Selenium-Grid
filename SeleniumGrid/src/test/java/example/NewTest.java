package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
	String driverPath;
	//String driverPath = "/usr/bin/geckodriver";
	public WebDriver driver;

	@Test
	public void test1() {
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Test test");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
	}

	@BeforeClass
	public void beforeClass() {
		locateDriver();
		//System.setProperty("webdriver.gecko.driver", driverPath);
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	public void locateDriver() {
		String OS = System.getProperty("os.name");
		System.out.println("locateDriver()");
		if (OS.equals("Windows 7")) {
			driverPath = "C:\\Selenium\\chromedriver.exe";
			System.out.println("Windows 7");
		} else {
			System.out.println("Other OS");
			driverPath = "/usr/bin/chromedriver";
		}
	}

	@AfterClass
	public void afterClass() {
	}

}
