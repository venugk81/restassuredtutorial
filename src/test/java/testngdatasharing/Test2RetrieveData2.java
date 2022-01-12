package testngdatasharing;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Test2RetrieveData2 {

	@Test
	public void retriveContext2(ITestContext context) {
		
		System.out.println("Trying to retrieve data using iTestContext from another Test and it should be null");
		
		context.getAttribute("recordData");
		System.out.println("Value retrived using getAttribute of iTestContext: should be null:  "+ context.getAttribute("recordData"));
		
		System.out.println("Suite Value: "+ context.getSuite().getAttribute("val1"));
		
	}
}
