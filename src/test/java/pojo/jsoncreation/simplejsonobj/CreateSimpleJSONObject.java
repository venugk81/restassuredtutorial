package pojo.jsoncreation.simplejsonobj;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateSimpleJSONObject {
	
	SimpleJsonPojo sjPojo;
	
	@Test
	public void testSimpleJSONObject() {
		sjPojo = new SimpleJsonPojo();
		sjPojo.setName("Venu");
		sjPojo.setAge(26);
		sjPojo.setDesignation("QA");	
//		System.out.println(sjPojo);
		System.out.println("====================Simple JSON Object");
		
		RestAssured.given().body(sjPojo).log().all().when().get();
	}

}


//