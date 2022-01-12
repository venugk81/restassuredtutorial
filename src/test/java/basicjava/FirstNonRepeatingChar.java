package basicjava;

import org.testng.annotations.Test;

public class FirstNonRepeatingChar {
	@Test
	public void test() {
		String s = "Bank of America B";
		char[] chr = s.toCharArray();
		boolean dupFlag = false;
		for(int i=0; i< chr.length; i++) {
			dupFlag = false;
			for(int j=i+1; j< chr.length; j++) {
				if(chr[i]==chr[j]) {
					//its duplicate..
					dupFlag = true;
					break;
				}			
			}
			if(!dupFlag) {
				System.out.println("first non repeating char: "+ chr[i]);
				break;
			}
		}
	}

}
