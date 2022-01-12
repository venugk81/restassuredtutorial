package testngdatasharing;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Test1RetrieveData {

	@Test
	public void retriveContext(ITestContext context1) {
		
		
		
		context1.getAttribute("recordData");
		System.out.println("Value retrived using getAttribute of iTestContext: "+ context1.getAttribute("recordData"));
	
		
	}
}
