package basicjava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class SetEg {

	@Test
	public void test() {
		String parent = "1";
		List<String> list = Arrays.asList("1", "3", "5");
		Set<String> set = new HashSet<String>(list);
		
		System.out.println(set.size());
		
		System.out.println(set);
		set.stream().forEach(e-> System.out.println(e.length()));
		
//		set.removeIf(e->e.contains(parent));
//		System.out.println(set);
		
		set.remove(parent);
		System.out.println(set);
		
		for(String s : set) {
			//driver.switchTo().window(s)
			// driver.findElement(By.id()). asdfasdfkasdf check and validate.. 
			//perform opearations 
			//driver.close();
			System.out.println("printing s: "+ s +" and set is "+ set);

			//driver.switchTo().window(parent);
			
		}
	}
}
