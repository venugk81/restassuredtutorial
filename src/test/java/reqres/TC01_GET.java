package reqres;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC01_GET {
	
	@Test
	void test_get() {
		Response res = RestAssured.get("https://reqres.in/api/users/1");
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getHeader("content-type"));
		System.out.println(res.asString());
		
	}
	
	void getSpecificUserDataByID() {
		
	}
}
