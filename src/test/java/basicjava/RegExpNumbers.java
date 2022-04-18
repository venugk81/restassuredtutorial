package basicjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.testng.annotations.Test;



public class RegExpNumbers {
	
	@Test
	public void binaryOfNumber() {
		long num = 34;
		System.out.println(Long.toBinaryString(num));
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.valueOf(Long.toBinaryString(num)));
		System.out.println("Binary Value: "+ buffer);
		System.out.println("Reverse string of buffer value: "+ buffer.reverse());
		
	}

	@Test
	public void getOnlyNumbers()
	{
		String s = "asdf454asdf54asdf4a47d41";
		s.length();
		Pattern p = Pattern.compile("\\d+");
		Matcher matcher = p.matcher(s);
		String nu="";
		
		

		while(matcher.find()) {
			nu = nu + matcher.group();	
		}
	
		System.out.println(nu);
		
		
		String str = "venu123asfd23sasd1";
		String finalStr ="";
		for(int i=0; i<str.length(); i++) {
			String s1 = String.valueOf(str.charAt(i));
			if(StringUtils.isNumeric(s1)) {
				finalStr = finalStr + s1;
			}
		}
		System.out.println("finalStr : "+ finalStr);
		
		
	}
}
