package basicjava;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;



public class CharCount {
//	@Test
	public void CharCountEg() {
		String a = "Bank of America, JP Morgan";
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i<a.length(); i++) {
			char val = a.charAt(i);
			if(map.containsKey(String.valueOf(val))) {
				map.put(String.valueOf(val), 1);
			}else {
				int num = map.get(String.valueOf(val));
				map.put(String.valueOf(val), num+1);
			}			
		}
		System.out.println(map);
	}

//	@Test
	public void test() {
		String s = "abc a xyz b a";
		System.out.println(s.indexOf("a"));
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		System.out.println(map.keySet());
		for(int i=0; i<s.length();i++) {
			char chr = s.charAt(i);
			System.out.println(chr);
//			map.putIfAbsent(s.charAt(i), 1);
			if(!String.valueOf(chr).strip().isEmpty()) {
				if(!map.containsKey(chr)) {
					map.put(chr, 1);
				}else {
					int count = map.get(chr);
					map.put(chr, count+1);
				}
			}
		}
		System.out.println(map);
		int size = map.size();
		System.out.println(size);
		
		System.out.println(map.containsValue(3));
		
		
		
		
		
	}
//	@Test
	void Findrepeter(){
	    String s="mmababctamantlslmag";
	    int distinct = 0 ;

	    for (int i = 0; i < s.length(); i++) {

	        for (int j = 0; j < s.length(); j++) {

	            if(s.charAt(i)==s.charAt(j))
	            {
	                distinct++;

	            }
	        }   
	        System.out.println(s.charAt(i)+"--"+distinct);
	        String d=String.valueOf(s.charAt(i)).trim();
	        s=s.replaceAll(d,"");
	        distinct = 0;

	    }

	}
	
	@Test
	public void testArrayCompare() {
		List<String> l1 = Arrays.asList("venu", "gopi", "g");
		List<String> l2 = Arrays.asList(new String[] {"venu", "g", "gopi"});
		
		System.out.println("l1.equals(l2): "+ l1.equals(l2));		//false
		System.out.println("l1.containsAll(l2): "+ l1.containsAll(l2));			//l1.containsAll(l2): true
		
		List<String> l3 = Arrays.asList(new String[] {"venu", "gopi", "g"});
		
		System.out.println("l1.equals(l3)");
		System.out.println(l1.equals(l3));
		
		
		System.out.println("\"l1.toArray(), l2.toArray(): \"+  ");
		
		Assert.assertEqualsNoOrder(l1.toArray(), l2.toArray());				//true
		
		System.out.println("After sorting the lements");
		Collections.sort(l1);
		System.out.println("L1 after sorting: "+ l1);
		Collections.sort(l2);
		System.out.println("L2 after sorting: "+ l2);
		System.out.println("l1.equals(l1): "+  l1.equals(l2));			// l1.equals(l1):  true after sorting
		
		Assert.assertTrue(l1.equals(l2));					//true
		
		
		int iarrp[]= {1,3,54,3};
		System.out.println("length: "+ iarrp.length);
		
		
	}
	
//	@Test
	public void charRepeatsInStrng() {
		System.out.println("testing: "+ "xyz".split("z"));
		
		 String s="venu";
		 String arr[] = s.split("e");		//this will not work.. need changes for first and last characters.. 
		 for(String a1: arr) {
			 System.out.println(a1);
		 }
		 
	}
}
