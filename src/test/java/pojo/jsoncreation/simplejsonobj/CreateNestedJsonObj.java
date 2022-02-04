package pojo.jsoncreation.simplejsonobj;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateNestedJsonObj {
	

	SimpleJsonAddressArrayPojo addressObj, addressObj2;
	
	ComplexJsonObjectPojo complexJson;
	
	@Test
	public void testSimpleJSONObject() {
		complexJson = new ComplexJsonObjectPojo();
	
		complexJson.setName("Venu");
		complexJson.setAge(26);
		complexJson.setDesignation("QA");	

		System.out.println("====================Simple JSON Object");
		
		addressObj = new SimpleJsonAddressArrayPojo();
		addressObj.setStreet("Tarnaka");
		addressObj.setLandmark("Aaradhana Theatre");
		addressObj.setPincode(5454);
		
//		addressObj2 = new SimpleJsonAddressArrayPojo();
//		addressObj2.setStreet("Tarnaka");
//		addressObj2.setLandmark("Aaradhana Theatre");
//		addressObj2.setPincode(5454);
		
		List<Object> arrObj = new ArrayList<>();
		arrObj.add(addressObj);
//		arrObj.add(addressObj2);
		
		complexJson.setAddress(addressObj);
		
		RestAssured.given().body(complexJson).log().all().when().get();
		
		/*
			{
			  "name": "Venu",
			  "age": 26,
			  "designation": "QA",
			  "address": {
			    "street": "Tarnaka",
			    "landmark": "Aaradhana Theatre",
			    "pincode": 5454
			  }
			}
		 */
	}
}


//