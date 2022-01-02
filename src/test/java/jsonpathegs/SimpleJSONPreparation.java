package jsonpathegs;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SimpleJSONPreparation {

	@Test
	public void simpleJSONPreparation() {
		String simpleJSON = "{\r\n" + 
				"\"firstname\": \"venu\",\r\n" + 
				"\"lastname\": \"g\",\r\n" + 
				"}";
		
		String json = "{\r\n" + 
				"\"firstname\": \"venu\",\r\n" + 
				"\"lastname\": \"g\",\r\n" + 
				"\"age\": 30,\r\n" + 
				"\"married\": false,\r\n" + 
				"\"salary\": 12.15\r\n" + 
				"}";

		JsonPath jsonPath = new JsonPath(simpleJSON);

		System.out.println((Object) jsonPath.get());
		
		System.out.println((Object) jsonPath.get("$"));
		System.out.println(jsonPath.getString("$"));
		
		System.out.println((Object) jsonPath.get(""));
		System.out.println(jsonPath.getString(""));
		
		System.out.println(jsonPath.getString("firstname"));
		
		System.out.println((Object)(jsonPath.getString("$")) instanceof JSONObject );
		System.out.println((Object)(jsonPath.getString("$")) instanceof JSONArray );
		
		 
		
	
	}

}

/*
 
Output:-------- --------------

{firstname=Venu, lastName=G}	(Object) jsonPath.get()			: is replaced with =
{firstname=Venu, lastName=G}	(Object) jsonPath.get("$")		: is replaced with =
[firstname:Venu, lastName:G]			 jsonPath.getString("$")
{firstname=Venu, lastName=G}	(Object) jsonPath.get("")		: is replaced with =
[firstname:Venu, lastName:G]			 jsonPath.getString("")

System.out.println(jsonPath.getString("firstname"));			  venu
*/