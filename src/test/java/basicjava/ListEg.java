package basicjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEg {
	
	public static void main(String[] args) {
		List<String> lst = new ArrayList<>();
		lst.add("3");
		lst.add("2");
		lst.add("34");
		lst.add("13");
		
		List<String> lst2 = new ArrayList<>();
		lst2.add("3");
		lst2.add("ve");
		lst2.add("2");
		
		
		
		
		System.out.println("min: "+ Collections.min(lst));
		
//		System.out.println(lst.containsAll(lst2));
		
		
		System.out.println("lst: "+ lst);
		lst.retainAll(lst2);
		System.out.println("after retainAll: "+ lst);
		
		
		
	}
	

}
