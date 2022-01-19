package selenium;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;

public class CommonPage extends BaseClass {
	
	ExtentTest test;

	public void click(By by) {
		driver.findElement(by).click();
		
	}
}
