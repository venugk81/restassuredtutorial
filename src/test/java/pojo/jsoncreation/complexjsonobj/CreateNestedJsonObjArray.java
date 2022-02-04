package pojo.jsoncreation.complexjsonobj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.jsoncreation.simplejsonobj.SimpleJsonAddressArrayPojo;

public class CreateNestedJsonObjArray {
	
	ComplexJsonObjectPojo complexJson;
	SimpleJsonAddressArrayPojo addressObj1, addressObj2;
	
	@Test
	public void testSimpleJSONObject() {
		complexJson = new ComplexJsonObjectPojo();
	
		complexJson.setName("Venu");
		complexJson.setAge(26);
		complexJson.setDesignation("QA");		
		
		List<SimpleJsonAddressArrayPojo> arrObj = new LinkedList<SimpleJsonAddressArrayPojo>();
		
		addressObj1 = new SimpleJsonAddressArrayPojo();
		addressObj1.setStreet("Tarnaka");
		addressObj1.setLandmark("circle");
		addressObj1.setPincode(4654546);
		
		addressObj2 = new SimpleJsonAddressArrayPojo();
		addressObj2.setStreet("Uppal");
		addressObj2.setLandmark("testing");
		addressObj2.setPincode(12312);
		
		arrObj.add(addressObj1);
		arrObj.add(addressObj2);
		
		complexJson.setAddress(arrObj);
		
		RestAssured.given().body(complexJson).log().all().when().get();		
	}
}


/*

{
  "name": "Venu",
  "age": 26,
  "designation": "QA",
  "address": [
    {
      "street": "Tarnaka",
      "landmark": "circle",
      "pincode": 4654546
    },
    {
      "street": "Uppal",
      "landmark": "testing",
      "pincode": 12312
    }
  ]
}

*/