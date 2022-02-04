package selenium;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.restassured.RestAssured;
import utilities.ExtentReportsUtil;

public class TC003_BrokenLinksTest extends CommonPage{
	ExtentTest test;
	@Test
	public void test() {
//			test = reports.createTest("TC001_UsingReportExtent");	
			test = ExtentReportsUtil.setTestname("TC001_UsingReportExtent1");
			test.assignAuthor("Venu").assignCategory("Sample").assignDevice("Chrome Browser");
			test.info("Test started");			
			List<WebElement> links = driver.findElements(By.tagName("a"));
			String href="";
			int statusCode;
			for(WebElement link: links) {
				href = link.getAttribute("href");
				statusCode = RestAssured.get(href).getStatusCode();
				if(statusCode!=200) {
					System.out.println("link: "+ href + " is a broken link: "+ href);
				}else {
					System.out.println("Valid link: "+ href + " and status code: "+ statusCode);
				}
			}
			
			
			
	}
	
	
}

