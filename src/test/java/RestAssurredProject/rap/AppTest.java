package RestAssurredProject.rap;



/**
 * Unit test for simple App.
 */
final  class Sys{
	
	Sys(){
		
	}
	
	static  void out(String val) {
		System.out.println(val);;
	}
   
}


public class AppTest{
	
	public static void main(String a[]) {
		Sys s = new Sys();
		s.out("Testing");
	}
}