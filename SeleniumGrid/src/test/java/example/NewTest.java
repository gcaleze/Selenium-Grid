package example;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class NewTest {

	@Test(priority = 1)
	public void test1() throws MalformedURLException {
		WebDriver driver;
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.BINARY,
				new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe").getAbsolutePath());
		driver = new RemoteWebDriver(new URL("http://192.168.125.97:4444/wd/hub"), capabilities);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
	}
}