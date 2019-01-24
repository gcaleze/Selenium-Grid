package example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

public class NewTest extends base {

	public String expected = null;
	public String actual = null;

	@Test (priority = 1)
	public void verifyTitle() throws InterruptedException {
		logger = reports.createTest("Verify Title");
		String expectedTitle = "Google";		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");		
		Thread.sleep(1000);		
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	
	@Test(priority = 2)
	public void test1() {
		logger = reports.createTest("Search");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("asdfjkl;");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
	}

	@Test(priority = 3)
	public void test2() throws IOException {
		logger = reports.createTest("sample Gen Reports1");
		logger.log(Status.INFO, "Info 1");
		logger.log(Status.PASS, "Pass 2");
		logger.log(Status.DEBUG, "Debug 3");
		logger.log(Status.ERROR, "Error 4");
		logger.log(Status.FAIL, "Fail 5");
		logger.log(Status.SKIP, "Skip 6");
		logger.log(Status.WARNING, "Warning 7");
		logger.log(Status.FATAL, "Fatal 7.5");
		logger.debug("Debug 8");
		logger.error("Error 9");
		logger.fail("Fail 10");
		logger.fatal("Fatal 11");
		logger.info("Info 12");
		logger.pass("Pass 13");
		logger.skip("Skip 14");
		logger.warning("Warning 15");
		System.out.println("1.1");
		Screenshot.capture(driver, "test_"+ "1st");
		//logger.log(Status.FAIL, "image below: " + logger.addScreenCaptureFromPath("/job/SQA%20Test/ws/JenkinsGit/Reports/Screenshots/test_1st.png"));
		logger.log(Status.FAIL, "image below: " + logger.addScreenCaptureFromPath("Screenshots/test_1st.png"));
	}

	@Test(priority = 4)
	public void test3() throws IOException {
		logger = reports.createTest("sample Gen Reports2");
		logger.log(Status.INFO, "Info 1.1");
		logger.log(Status.PASS, "Pass 2.1");
		logger.log(Status.DEBUG, "Debug 3.1");
		logger.log(Status.ERROR, "Error 4.1");
		logger.log(Status.FAIL, "Fail 5.1");
		logger.log(Status.SKIP, "Skip 6.1");
		logger.log(Status.WARNING, "Warning 7.1");
		logger.log(Status.FATAL, "Fatal 7.5.1");
		logger.debug("Debug 8.1");
		logger.error("Error 9.1");
		logger.fail("Fail 10.1");
		logger.fatal("Fatal 11.1");
		logger.info("Info 12.1");
		logger.pass("Pass 13.1");
		logger.skip("Skip 14.1");
		logger.warning("Warning 15.1");
		System.out.println("2.1");
		Screenshot.capture(driver, "test_"+ "2nd");;
		logger.log(Status.FAIL, "image below: " + logger.addScreenCaptureFromPath("Screenshots/test_2nd.png"));
	}
}
