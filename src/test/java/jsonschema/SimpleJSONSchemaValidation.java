package jsonschema;



import java.io.File;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ResponseBody;

public class SimpleJSONSchemaValidation {
	
//	https://mvnrepository.com/artifact/io.rest-assured/json-schema-validator/4.4.0

	public SimpleJSONSchemaValidation() {
		 		 
	}
	
//	@Test
	public void getBookingDetails() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/1";
		ResponseBody body = RestAssured
								.given()
									.get("https://restful-booker.herokuapp.com/booking/1")
								.getBody();
		System.out.println(body.asPrettyString());
		
//		RestAssured
//		.given()-
//			.get("https://restful-booker.herokuapp.com/booking/1").then().log().all();
	}
	
//	@Test
	public void getBookingSchemaValidation() {
		RestAssured.given()
			.contentType(ContentType.JSON)
			.get("https://restful-booker.herokuapp.com/booking/1")
		.then()
			.log().all()
			.statusCode(200)
			.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\gopiv\\auto\\rest_learning\\src\\resources\\GetBookingsSchema.json")));
	}
	
//	@Test
	public void getBookingSchemaValidationFromClassPath() {
		RestAssured.given()
			.contentType(ContentType.JSON)
			.get("https://restful-booker.herokuapp.com/booking/1")
		.then()
			.log().all()
			.statusCode(200)
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("GetBookingsSchema.json"))
			.extract().body();
		
		//In order to use file name without full path using matchesJsonSchemaInClasspath method, we need to keep the file "" under src/main/resources
	}
	
	@Test
	public void createJsonAndValidateAgainstSchema() {
		String jsonInput = "{\r\n" + 
				"    \"firstname\": \"Eric\",\r\n" + 
				"    \"lastname\": \"Ericsson\",\r\n" + 
				"    \"totalprice\": 658,\r\n" + 
				"    \"depositpaid\": false,\r\n" + 
				"    \"bookingdates\": {\r\n" + 
				"        \"checkin\": \"2018-03-06\",\r\n" + 
				"        \"checkout\": \"2020-03-28\"\r\n" + 
				"    }\r\n" + 
				"}";
		
//		This json I will send it in Body.class. so before sending it I want to validate it..
		MatcherAssert.assertThat(jsonInput, 
				JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\gopiv\\auto\\rest_learning\\src\\resources\\GetBookingsSchema.json")));
		
		MatcherAssert.assertThat(jsonInput, 
				JsonSchemaValidator.matchesJsonSchemaInClasspath("GetBookingsSchema.json"));
	}
}
