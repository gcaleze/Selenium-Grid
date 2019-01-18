package example;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
    String baseURL, nodeURL;
	@Test(priority = 1)
	public void test1(){		
		
//-----------------------------------------------		
//        baseURL = "http://demo.guru99.com/test/guru99home/";
//        nodeURL = "http://192.168.43.223:4444/wd/hub";
//        DesiredCapabilities capability = DesiredCapabilities.chrome();
//        String label = System.getProperty("SELENIUM_LABEL");
//        //capability.setCapability("jenkins.label", Platform.WINDOWS);------------
//        capability.setCapability("jenkins.label", label);
//        //capability.setBrowserName("chrome");-----------
//        //capability.setPlatform(Platform.WINDOWS);------
//        driver = new RemoteWebDriver(new URL(nodeURL), capability);
//------------------------------
        
//		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver.exe");	        
		System.setProperty("webdriver.gecko.driver","/usr/bin/geckodriver");		 
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
	

//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
//		driver =new ChromeDriver();
//		driver.get("http://www.google.com");
	
		driver.quit();
		driver.close();
	}
}