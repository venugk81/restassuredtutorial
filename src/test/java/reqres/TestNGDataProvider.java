package reqres;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {
	
	@DataProvider(name="userData")
	public Object[][] DataProviderTest() {
		Object userData[][] = new Object[2][3];  //2*3 matrix data..
		userData[0][0] ="Venu";
		userData[0][1] ="G";
		userData[0][2] =101;
		
		userData[1][0] ="Gopi";
		userData[1][1] ="k";
		userData[1][2] =102;		
		
		return userData;
	}
	
	@Test(dataProvider = "userData")
	public void ActualTest(String fname, String lname, int empNo) {
		System.out.println("First name: "+ fname + " Last name "+ lname + " and Emp ID: "+ empNo);
	}

}
