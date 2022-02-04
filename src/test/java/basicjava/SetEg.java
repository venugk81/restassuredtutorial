package basicjava;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class SetEg {

//	@Test
	public void test() {
		String parent = "1";
		List<String> list = Arrays.asList("1", "3", "5");
		Set<String> set = new HashSet<String>(list);

		System.out.println(set.size());

		System.out.println(set);
		set.stream().forEach(e -> System.out.println(e.length()));

//		set.removeIf(e->e.contains(parent));
//		System.out.println(set);

		set.remove(parent);
		System.out.println(set);

		for (String s : set) {
			// driver.switchTo().window(s)
			// driver.findElement(By.id()). asdfasdfkasdf check and validate..
			// perform opearations
			// driver.close();
			System.out.println("printing s: " + s + " and set is " + set);

			// driver.switchTo().window(parent);

		}
	}
	
	@Test 
	public void mapTest() {
		Map<String, Integer> m = new HashMap<String, Integer> ();
		m.put("a", 2);
		m.put("s", 43);
		m.put("g", 21);
		m.put("b", 13);
		m.put("y", 3);
		
		int min = Collections.min(m.values());
		System.out.println(min);
		int max = Collections.max(m.values());
		System.out.println(max);
		
		Iterator<Map.Entry<String, Integer>> iterator= m.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry entry = iterator.next();
//			System.out.println(entry.getKey() + " value: "+ entry.getValue());	
			if((int)entry.getValue() == min) {
				System.out.println("min value: "+ min + " key: "+ entry.getKey());
			}else if((int)entry.getValue()==max) {
				System.out.println("max value: "+ max + " key: "+ entry.getKey());
			}
		}
		System.out.println("=============");
		m.forEach((k, v) -> System.out.println((k + ":" + v)));
		System.out.println("=============");
		m.forEach((k, v) -> {
			if(v==min) {
				System.out.println("character repeating: "+ k + " and appearing min times of "+ v);
			}else if(v==max) {
				System.out.println("character repeating: "+ k + " and appearing max times of "+ v);
			}
			
		});
		System.out.println("=============");
		m.keySet().forEach(k -> System.out.println((k + ":" + m.get(k))));
		System.out.println("=============");
		m.values().forEach(v -> System.out.println("value: "+ v));
		System.out.println("=====================================");
		m.keySet().stream().forEach(k-> System.out.println(k + " "+ m.get(k)));
	}
}
