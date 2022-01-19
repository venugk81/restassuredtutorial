package selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentReportsUtil;

public class TC002_UsingReportExtent extends CommonPage{
	ExtentTest test;
	@Test
	public void test() {
//			test = reports.createTest("TC001_UsingReportExtent");	
			test = ExtentReportsUtil.setTestname("TC002_UsingReportExtent2");
			test.assignAuthor("Gopi").assignCategory("Sample2").assignDevice("Firefox Browser2");
			test.info("Test started");			
			driver.findElement(By.name("q")).sendKeys("testing");
			
	}
	
	
}

