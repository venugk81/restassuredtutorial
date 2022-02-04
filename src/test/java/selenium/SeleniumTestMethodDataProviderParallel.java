package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTestMethodDataProviderParallel {
	
	@Test(dataProvider="getData")
	public void test(String row, String data, int no) {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);		
		// Navigate to the demoqa website
		try {
			driver.get("https://www.google.com");		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.findElement(By.name("q")).sendKeys(row + " " + data + " " + no);
			System.out.println("===================entered data in search field for counter: "+ no);
			Thread.sleep(500);
			driver.close();
			driver.quit();	
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}

	// when data provider is set to parallel. it will launch test method execution for all the data in parallel.
	//To control how many iterations to launch, we have an attribute "data-provider-thread-count". Set it in testng.xml as <suite name="Suite" data-provider-thread-count="3">
	// at the suite level
	@DataProvider(parallel=true)				
	public Object[][] getData(){
		Object[][] data= new Object[6][3];
		data[0][0] ="row1";
		data[0][1] ="data1";
		data[0][2] = 1;		
		
		data[1][0] ="row2";
		data[1][1] ="data2";
		data[1][2] = 2;		
		
		data[2][0] ="row3";
		data[2][1] ="data3";
		data[2][2] = 3;
		
		data[3][0] ="row4";
		data[3][1] ="data4";
		data[3][2] = 4;
		
		data[4][0] ="row5";
		data[4][1] ="data5";
		data[4][2] = 5;
		
		data[5][0] ="row6";
		data[5][1] ="data6";
		data[5][2] = 6;
		
		return data;
		
	}
	
}
