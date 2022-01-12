package testngdatasharing;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Test1SharingData {

	@Test
	public void setContext(ITestContext context) {
		
		String val = "Consider this is genered record data and saving it to a variale and then saving it context using setAttribute..";		
		context.setAttribute("recordData", val);
		System.out.println("Value is set in setContext");
		
		context.getSuite().setAttribute("val1", "venu");
	}
}
