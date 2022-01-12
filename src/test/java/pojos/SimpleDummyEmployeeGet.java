package pojos;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SimpleDummyEmployeeGet {
	@Test
	public void test() {
		Employee emp = new Employee();
		emp.setName("venu");
		emp.setId(123);
		
		Address add = new Address();
		add.setStreet("Anakapally");
		add.setLocation("tarnaka, hyder");
		add.setCity("Hyd");
		
		emp.setAddress(add);
		
		RestAssured.given().log().all().body(emp).get();
	}

}
