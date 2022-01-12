package threadlocalpack;

import java.util.LinkedHashMap;
import java.util.Map;

public class ThreadLocalDemo {
	
	ThreadLocalDemo(){}
	
	private static ThreadLocal<LinkedHashMap<String, Object>> threadDataMap = 
			ThreadLocal.withInitial(()-> new LinkedHashMap<String, Object>());
//	
	////// below commented lines doesn't work.. 
	
//	private static ThreadLocal<LinkedHashMap<String, Object>> threadDataMap = 
//			new ThreadLocal<LinkedHashMap<String, Object>>();
	
	public static void setValue(String key, Object value) {
		threadDataMap.get().put(key, value);
	}
	
	public static Object getValue(String key) {
		return threadDataMap.get().get(key);		  
	}
	
	//This way we can achieve thread safe scripts.. 
}


