package reqres;


import static io.restassured.RestAssured.*;
//import static restconfig.ConfigFactory.getDefaultConfig;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import restconfig.ConfigFactory;

public class TestWithConfigFactory {
	
	@BeforeClass
	public void beforeClass() {
		RestAssured.config= ConfigFactory.getDefaultConfig();
	}
	
	
	
	@Test
	public void getSpecificUserDetailsByName() {	
		baseURI = "https://reqres.in/api";
		given()
			.get("/users?page=2")
		.then()	
			.contentType(ContentType.JSON)
			.statusCode(200)
			.body("data[0].email", equalTo("michael.lawson@reqres.in"));
		
		/*
		 * Response res = doGetRequest(); 
		 * List<String> jsonRes =  res.jsonPath().getList("$"); 
		 * System.out.println(jsonRes.size());
		 * ResponseBody<?> body = res.getBody(); 
		 * JsonPath path = body.jsonPath();
		 * System.out.println(path.get("address.zipcode").toString());
		 * System.out.println(path.get("address[0].zipcode").toString());
		 */		
		
	}
	
	
	
	//Set default parser to json..

	public Response doGetRequest() {	
		RestAssured.defaultParser = Parser.JSON;
		return 
				given().
					headers("Content-Type",  ContentType.JSON, "Accept", ContentType.JSON).
				when().
					get("https://jsonplaceholder.typicode.com/users").
				then().
					contentType(ContentType.JSON).extract().response();
	}
	
	
	
}
