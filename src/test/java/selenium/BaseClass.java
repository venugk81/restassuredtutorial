package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentReportsUtil;

public class BaseClass {
	public ExtentReportsUtil extentReportsUtil = new ExtentReportsUtil();
	public ExtentReports reports;
	
	public WebDriver driver=null;
	ChromeOptions chromeOptions;
	String url = "https://www.google.com";
	@BeforeSuite
	public void beforeSuite() {
		chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);	
		reports = extentReportsUtil.getReportConfig();
		try {
			driver.get(url);		
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.close();
		driver.quit();
		extentReportsUtil.flushReport();
		
	}

}
