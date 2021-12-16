package jsonpathegs;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Filter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ValidateBody {

	public RequestSpecification httpRequest;
	public Response response;

	public ValidateBody() {
		RestAssured.baseURI = "http://localhost:3000";
	}

//	@Test
	public void getMetaData() {
		httpRequest = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type",
				"application/json");
		response = httpRequest.get("/subjects/1/users");
		System.out.println(response.body().asString());

		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println("Status Linee: " + response.getStatusLine());

		System.out.println(response.getHeader("Content-Type"));
		// get all headers - key value pair iteratable:

		Headers headers = response.getHeaders();
		for (Header head : headers) {
			System.out.println("Header Key: " + head.getName() + " and its value: " + head.getValue());
		}

		System.out.println("Print all the node elenments-----------");
		JsonPath jp = response.jsonPath();
		System.out.println("jp.get(\"firstName\"): " + jp.get("firstName")); // this is an array

	}

//	@Test
	public void getUserDetailsByName() throws ParseException {
		httpRequest = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type",
				"application/json");
		response = httpRequest.get("/users?firstName=venu");
		System.out.println(response.body().asString());

		// Now retrive user id from the body...

		ResponseBody body = response.getBody();
		
		System.out.println("Body here..................");
		System.out.println(body.asString());
		System.out.println("Body end here..................");

		// Get values using JSON Path
		JsonPath jp = response.jsonPath();
	
		System.out.println("jp.get(\"firstName\"): " + jp.get("firstName")); // this is an array

		List<String> a = jp.get("firstName");
		System.out.println("a as list$$$$$$$$$$$$$$$: " + a.toString());
		System.out.println("a.get(0): " + a.get(0));
		Assert.assertEquals(a.get(0), "venu");

//		method 2
		String jsonString = response.asString();
		List<String> lname = JsonPath.from(jsonString).get("lastName");
		System.out.println("Last Name: " + lname.get(0));

		Object obj = JSONValue.parse(jsonString);
		System.out.print("obj instanceof JSONArray :");
		System.out.println(jp.getList("$") instanceof JSONArray);

		JSONArray array = (JSONArray) obj;
		System.out.println("=====================\n array.get(0): " + array.get(0)); // {"firstName":"venu","lastName":"g","id":1,"subjectId":1}

		for (Object ob : array) {
			System.out.println(ob instanceof JSONObject);

			JsonPath jpath = new JsonPath(ob.toString());
			String placeId = jpath.getString("lastName");
			System.out.println(placeId);
		}

		System.out.println("==============Testing===========");

		System.out.println("jp.getList(\"$\") " + jp.getList("$")); // [{firstName=venu, lastName=g, subjectId=1, id=1}]

		System.out.println("jp.getList(\"$\").size() " + jp.getList("$").size()); // 1

		System.out.println(
				"response.jsonPath().getString(\"firstName[0]\") " + response.jsonPath().getString("firstName[0]")); // venu

		String usernames = response.jsonPath().getString("firstName");
		System.out.println("usernames :" + usernames);
		// https://devqa.io/parse-json-response-rest-assured/ good

	}

	/*
	 * 
	 * 2xx - OK 3xx - Redirection 4xx - Resource not found 5xx - Server error
	 * 
	 */
//	https://www.youtube.com/watch?v=ZjZqLUGCWxo
//	@Test
	public void getAllUserNodes() {
		httpRequest = RestAssured.given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				header("Content-Type",
				"application/json");
		
		response = httpRequest.get("/subjects/1/users");
		
		/*response= [											JSONArray    []
		           		{										JSONObject   {}
			        	    "firstName": "venu",
			        	    "lastName": "g",
			        	    "subjectId": 1,
			        	    "id": 1
		        	  	}, {}, repeats..
		        	] 
		        	  
		 */
		
		           
		String jsonString = response.asString();
		Object obj = JSONValue.parse(jsonString);
		System.out.println(obj instanceof JSONArray);			
		
		if(obj instanceof JSONArray) {				//First JSONArray then iterate through array for json objects.. in this case
			JSONArray array = (JSONArray) obj;
			System.out.println(obj);
			System.out.println("Array Length of the JSON Array Object: "+ array.size());
			for (Object ob : array) {
				System.out.println("Is obj is JSONObject: "+ (ob instanceof JSONObject));				
			
				JSONObject jsonObject = (JSONObject) ob;
				System.out.println("Trying to print value directly: "+ jsonObject.get("firstName"));
				
				for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
				    String key = (String) iterator.next();
				    System.out.println("Key: '"+ key +"' and value is:: "+ jsonObject.get(key) );
				}	
				
				System.out.println("&&&&&&&&&&&&&&& start &&&&&&&&&&&&&&&&&&&&");
				Iterator<String> keys = jsonObject.keySet().iterator();
				while(keys.hasNext()) {
				    String key = keys.next();
				    System.out.println("Key: "+ key + " and value is: "+ jsonObject.get(key));				    
				}
				System.out.println("&&&&&&&&&&&&&&& end &&&&&&&&&&&&&&&&&&&&");
			}
		}
	}
	
	//Interesting 
	/*
	 * 
	 * https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/
	 * https://www.toolsqa.com/rest-assured/jsonpath-and-query-json-using-jsonpath/
	 */

//	@Test
	public void parseResponseInJSONPath() {
		httpRequest = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type",
				"application/json");
		response = httpRequest.get("/users");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@ in test method@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ parseResponseInJSONPath");
		JsonPath jp = response.jsonPath();
		System.out.println(jp.getList("$"));	
		
		//output: [{firstName=venu, lastName=g, subjectId=1, id=1}, {firstName=Aditya, lastName=IK, subjectId=2, id=2}, ...]
		System.out.println(jp.getList("$").get(0));			//{firstName=venu, lastName=g, subjectId=1, id=1}
		
		System.out.println(jp.getList("$").get(0).getClass().getSimpleName());		//LinkedHashMap
		

		System.out.println("All Firstnames:" + jp.getString("firstName"));	// [venu, Aditya, melisha, sheldon, melisha, Raj, Andy, Raj]
		
		System.out.println(response.jsonPath().getString("firstName[0]"));		//venu
		
		System.out.println("@@@@@@@@@@");
		
		System.out.println(jp.getClass().getSimpleName());
		
	}
	
	@Test
	public void getReqresData() {
		httpRequest = RestAssured.given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				header("Content-Type", "application/json");
		
		response = httpRequest.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		
		JsonPath jp = response.jsonPath();
		System.out.println("Total: "+ jp.getString("total"));		
		List<Map<String, String>> data =  jp.from(response.asString()).getList("data");		
		System.out.println("Size data: "+ data.size());	
		
		System.out.println(data instanceof JSONObject);
		
		System.out.println("Printing Data Json array ");
		System.out.println(data);
		System.out.println("Email: "+ data.get(0).get("email"));
		System.out.println(data.get(0));		
		
		System.out.println("&&&&&&&&&&&&&&& start &&&&&&&&&&&&&&&&&&&&");		
		for (Object ob : data) {			
			System.out.println("Is obj is JSONObject: "+ (ob instanceof JSONArray));	
		}
		
		String jsonString = response.asString();
		Object obj = JSONValue.parse(jsonString);	
		System.out.print("obj instanceof JSONObject: ");
		System.out.println(obj instanceof JSONObject);		
		
		if(obj instanceof JSONObject) {			
			System.out.println(((JSONObject) obj).get("per_page"));			
			
		}else if(obj instanceof JSONArray) {
			
		}
		
	}
	
	@Test
	public void jsonPathTest() {
		httpRequest = RestAssured.given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				header("Content-Type", "application/json");
		
		response = httpRequest.get("https://reqres.in/api/users");
		JsonPath path = response.jsonPath();
		String s = path.get("data.email");
		System.out.println(s);
		System.out.println(path.get("data.email[0]").toString());
		
		
		System.out.println("Assert statements.. ");
		assertEquals(response.getStatusCode(), 200);
		assertEquals(response.getContentType(), "application/json; charset=utf-8");
		
		System.out.println("Print Content-Type using header method: " + response.getHeader("Content-Type"));	
		System.out.println(response.getHeader("cache-control"));
		//application/json; charset=utf-8 this is the output.. 
		//now to assert this, we can save the value in a variable and use assert statements.. 
		//instead we can also use then() method.. then() returns validatable response
		
		//then() method usage:
		
		//Here we will not save the output to response Object. keep appending then(), and(), when methods..  like below
		
		RestAssured.get("https://reqres.in/api/users")
		.then()
			.statusCode(200)
			.and()
				.assertThat()
				.contentType(ContentType.JSON) 
			.and()
				.assertThat()
				.header("server", "cloudflare")
			.and()
				.header("cache-control", "max-age=14400");			
	}
}
