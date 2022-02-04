package pojo.jsoncreation.simplejsonobj;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateNestedJSONArray1 {
	
	/*
	 
	 [
		  {
		    "name": "Venu",
		    "age": 26,
		    "designation": "QA"
		  },
		  {
		    "name": "Gopi",
		    "age": 30,
		    "designation": "QA Automation"
		  }
	]
	 
	 */
	
	SimpleJsonArray sjPojo1, sjPojo2;
	
	@Test
	public void testSimpleJSONObject() {
		sjPojo1 = new SimpleJsonArray();
		sjPojo1.setName("Venu");
		sjPojo1.setAge(26);
		sjPojo1.setDesignation("QA");	
		
		sjPojo2 = new SimpleJsonArray();
		sjPojo2.setName("Gopi");
		sjPojo2.setAge(30);
		sjPojo2.setDesignation("QA Automation");	

		System.out.println("====================Nested JSON Array");
		ArrayList<Object> al = new ArrayList<>();
		al.add(sjPojo1);
		al.add(sjPojo2);
		
		RestAssured.given().body(al).log().all().when().get();
	}

}


//