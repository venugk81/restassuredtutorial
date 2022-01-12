package selenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	
	@Test
	public void test() {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);		
		// Navigate to the demoqa website
		try {
			driver.get("https://www.google.com");		
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.name("q")).sendKeys("First Jenkins test");
			Thread.sleep(1000);
			driver.close();
			driver.quit();	
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void test2() {
		System.out.println("Testing.. failing scripts==Pass");
	}
}

