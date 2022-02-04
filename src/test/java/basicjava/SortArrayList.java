package basicjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



public class SortArrayList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("xyz");
		list.add("pqr");
		list.add("aac");
		List<String> ll = new LinkedList<String>(list);
		
		System.out.println("Maintains insertion order: "+ ll);
		Collections.sort(list);
		System.out.println("Sorted List: "+ list);
		
	}

}
