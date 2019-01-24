package example;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class base {
	
	protected ExtentReports reports;
	ExtentHtmlReporter reporter;
	protected ExtentTest logger;
	String driverPath;
	String reportPath;
	String xmlConfig;
	protected WebDriver driver;
	
	@BeforeClass (alwaysRun = true)
	public void setup() throws Exception {
		locateFiles();
		String testerName = "QA Master";
		
		reporter = new ExtentHtmlReporter(reportPath);
		reports = new ExtentReports();
		//reporter.setAppendExisting(true);
		reports.attachReporter(reporter);		
		reporter.loadXMLConfig(xmlConfig);
		//reports.setSystemInfo("OS", "Win 7");
		reports.setSystemInfo("Tester", testerName);
		
//		System.setProperty("webdriver.chrome.driver",driverPath);
//		driver = new ChromeDriver();
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability("jenkins.label","gcaleze");
		capability.setCapability("jenkins.nodeName","(master)");
		driver = new RemoteWebDriver(new URL("http://192.168.125.97:4444/wd/hub"), capability);
	}
	
	public void locateFiles() {
		String OS = System.getProperty("os.name");
		if (OS.equals("Windows 7")) {
			driverPath = "C:\\Selenium\\chromedriver.exe";
			reportPath = System.getProperty("user.dir") + "\\Reports\\report.html";
			xmlConfig = System.getProperty("user.dir") + "\\src\\test\\java\\extent-config.xml";
			System.out.println("Windows 7");
		} else {
			driverPath = "/usr/bin/chromedriver";
			reportPath = System.getProperty("user.dir") + "/Reports/report.html";
			xmlConfig = System.getProperty("user.dir") + "/src/test/java/extent-config.xml";
			System.out.println("Other OS");
		}
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			
			logger.fail(MarkupHelper.createLabel(result.getName() + 
					" Test Case Failed", ExtentColor.RED));
			logger.fail(result.getThrowable());
			
		} else if(result.getStatus()==ITestResult.SUCCESS) {
			
			logger.pass(MarkupHelper.createLabel(result.getName() + 
					" Test Case Passed", ExtentColor.GREEN));
		} else {
			
			logger.skip(MarkupHelper.createLabel(result.getName() +
					" Test Case Skipped", ExtentColor.ORANGE));
			
			logger.skip(result.getThrowable());
		}
	}
	
	@AfterClass
	public void cleanUp() {
		reports.flush();
	}
}