package basicjava;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMap {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("abc", 31);
		map.put("aac", 12);
		map.put("aab", 21);
		map.put("xya", 931);
		map.put("pqr", 431);
		
		System.out.println("First Map: "+ map);
		Map<String, Integer> tree = new TreeMap<>(map);
		System.out.println("TreeMap Sorts the elements by Key: "+ tree);
		
	}
}
