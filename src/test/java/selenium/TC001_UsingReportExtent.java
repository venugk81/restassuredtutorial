package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentReportsUtil;

public class TC001_UsingReportExtent extends CommonPage{
	ExtentTest test;
	@Test
	public void test() {
//			test = reports.createTest("TC001_UsingReportExtent");	
			test = ExtentReportsUtil.setTestname("TC001_UsingReportExtent1");
			test.assignAuthor("Venu").assignCategory("Sample").assignDevice("Chrome Browser");
			test.info("Test started");			
			driver.findElement(By.name("q")).sendKeys("testing");
			test.info("Test in progress");
			test.pass("sstep passed 001");
			test.skip("skipped 001");
			test.warning("warning 001");
			test.fail("failed 001");
	}
	
	
}

