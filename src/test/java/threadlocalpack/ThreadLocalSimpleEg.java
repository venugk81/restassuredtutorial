package threadlocalpack;

public class ThreadLocalSimpleEg {
	
	ThreadLocalSimpleEg(){}
	
	private static ThreadLocal<String> counter1 = new ThreadLocal<String>();
	
	public static void setValue(String val) {
		counter1.set(val);
	}
	public static String getValue() {
		System.out.println("------------------- "+ counter1.get());
		return counter1.get();
	}
}
