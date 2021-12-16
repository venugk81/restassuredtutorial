import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class SeleniumTest {
	
	@Test
	public void test() {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);		
		// Navigate to the demoqa website
		driver.get("https://www.google.com");		
		driver.close();
		driver.quit();
	}
	
	@Test
	public void test2() {
		System.out.println("Testing.. failing scripts==Pass");
	}
}

