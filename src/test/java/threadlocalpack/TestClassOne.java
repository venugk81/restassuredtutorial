package threadlocalpack;

import org.testng.annotations.Test;

public class TestClassOne {
	
	@Test(priority = 1)
	public void generateRecordId() {
		int min = 101;
		int max = 400;
		//this is like creating a record id for parallel execution testing.. demo
		int id = (int) (Math.random()*(max-min+1)+min);
		ThreadLocalDemo.setValue("recordID", id);
		System.out.println("===================TestClassOne=======generateRecordId==========================");
		System.out.println("get Thread id TestClassOne: " + Thread.currentThread().getId() + "- Record id: "+ ThreadLocalDemo.getValue("recordID"));
	}
	
	@Test(priority = 2)
	public void validateRecordDetails() {
		System.out.println("=======TestClassOne==================validateRecordDetails==============");
		System.out.println("get Thread id TestClassOne: " + Thread.currentThread().getId() + "- Record id: "+ ThreadLocalDemo.getValue("recordID"));
	}

}
