package threadlocalpack;

import org.testng.annotations.Test;

public class SimpleClassUsingThreadLocal {
	
	@Test(priority = 1)
	public void testSet1() {
		String v1 = "test1";
		ThreadLocalSimpleEg.setValue(v1);
		System.out.println("Value is set..........");		
	}
	
	@Test(priority = 2)
	public void getVal1() {
		String v2 = ThreadLocalSimpleEg.getValue();
		System.out.println("Thread id: "+ Thread.currentThread().getId() + " and value: "+ v2);
	}
	

}
