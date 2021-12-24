package reqres;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetTesting {
	
	public GetTesting(){
		
	}
	
//	@Test
	public void getSpecificUserDetailsByName() {	
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[0].email", equalTo("michael.lawson@reqres.in"));
		
//		given().get("/users?page=2").then().statusCode(200).log().all();
		
		
		Response res = doGetRequest();
		List<String> jsonRes = res.jsonPath().getList("$");
		System.out.println(jsonRes.size());
		
		ResponseBody<?> body = res.getBody();
		JsonPath path = body.jsonPath();
		System.out.println(path.get("address.zipcode").toString());
		System.out.println(path.get("address[0].zipcode").toString());
		
		
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
	
	@Test
	public void usingHamCrestValidations() {
		RestAssured.get("https://api.github.com/")
		.then()
		.body("public_gists_url", containsString("public"));
		
		//Response res = RestAssured.get("https://reqres.in/api/users?page=2");you
//		System.out.println(res.getHeaders().asList());
		
//		System.out.println(res.asPrettyString());
//		
//		ResponseBody<?> bod = res.getBody();
//		JsonPath jp = res.jsonPath();
//		System.out.println("Total: "+ jp.getString("data.email"));	
		
		RestAssured.get("https://api.github.com/users")
		.then()
		.body("following_url[0]", containsString("other"))
		.body("url[0]", containsString("mojombo"));
		
		
		//Not hamcrest.. Just extracting headers.. from response.. 
		System.out.println("Response headers example: ===============================");
		Response res= RestAssured.get("https://api.github.com/users").then().statusCode(200).extract().response();
		Headers headers = res.getHeaders();
		for(Header header: headers) {
			System.out.println(header);
		}
				
		System.out.println("=============\n Link from headers using getHeaders: " + headers.getValue("Link"));
		System.out.println("=============\n Link from headers using getHeader from response: " + res.getHeader("Link"));
		
		
		
		
		
	}
	
	
}
