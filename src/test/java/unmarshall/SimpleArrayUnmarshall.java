package unmarshall;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;

public class SimpleArrayUnmarshall {
	
//	@Test
	public void simpleObject() {
		List lst = RestAssured
					.get("https://run.mocky.io/v3/1397562f-ca88-46b7-a260-561959c3d061")
					.as(List.class);					
		// THis is not a good approach. Instead use java maps with generics.. typeRef..typeRef is an abstract class with no abstract method..
//		TypeRef is used to convert any class to a generic type..
		//TypeRef allows to convert json resonse to any generic class type
		Map<String, String> map = (Map<String, String>) lst.get(0);
		System.out.println(map.get("name"));		
		map = (Map<String, String>) lst.get(1);
		System.out.println(map.get("name"));		
	}
	
	//Above method is to use Map.class to convert simple json response to Map.
	/*
	 [
	  {
	    "name": "venu",
	    "mobile": "7875454",
	    "id": 123,
	    "sal": 12.3
	  },
	  {
	    "name": "vinod",
	    "mobile": "465465445",
	    "id": 124,
	    "sal": 10.3
	  }
	]
	 */
	
	//Another way to unmarshall is to create a java class with all the fields we get in json resonse and then use it 
	
	
	//.as() : Get the body and map it to a Java object. For JSON responses this requires that you have either
//	@Test
	public void simpleObjectMapToJavaClass() {
		SimpleJSONArrayMapping obj = RestAssured
					.get("https://run.mocky.io/v3/1397562f-ca88-46b7-a260-561959c3d061")
					.as(SimpleJSONArrayMapping.class);
		System.out.println("\nMapped to SimpleJSONArrayMapping.class============");
		
	}
	
	//Another way using TypeRef<T> generic class type(T)
//	TypeRef is a generic abstract class with no abstract methods used for obtaining fill generics type information by sub classing. 
	//usage is by sub classing. example to instantiate ref to generic list ty List<Integer>
	//TypeReference ref = new TypeReference<List>Integer>>(){ };.
	
//	@Test
	public void simpleObjectMapToJavaObjectUsingTypeRef() {
		List<Map<String, Object>> lst = RestAssured
					.get("https://run.mocky.io/v3/1397562f-ca88-46b7-a260-561959c3d061")
					.as(new TypeRef<List<Map<String, Object>>>(){ });
		
		System.out.println("\n simpleObjectMapToJavaObjectUsingTypeRef ============");
		System.out.println("First Object: " + lst.get(0));		
		System.out.println("Mobile: "+ lst.get(0).get("mobile"));	
	}
	
//	@Test
	public void ModerateJSONArrayObjectTypeRef() {
		List<Map<String, Object>> lst = RestAssured
					.get("https://run.mocky.io/v3/1ae1aaf3-fb7a-4b12-bb4a-e2fccf10c863")
					.as(new TypeRef<List<Map<String, Object>>>(){ });
		
		System.out.println("\n simpleObjectMapToJavaObjectUsingTypeRef ============");
		System.out.println("First Object: " + lst.get(0));		
		System.out.println("Mobile: "+ lst.get(0).get("mobile"));	
	}
	
//	@Test
	public void ModerateJSONObjectTypeRef() {
		Map<String, Object> map = RestAssured
					.get("https://run.mocky.io/v3/83443fd1-eb19-4893-bfdb-16c01200c4ba")
					.as(new TypeRef<Map<String, Object>>() {});
		
		System.out.println("\n simpleObjectMapToJavaObjectUsingTypeRef ============");
		System.out.println("First Object: " + map.get("employee"));		
		
	}
	
//	@Test
	public void ModerateDynamicJSONValidation() {
		Object obj = RestAssured
					.get("https://run.mocky.io/v3/83443fd1-eb19-4893-bfdb-16c01200c4ba")
					.as(Object.class);	
		
		
		System.out.println("\n simpleObjectMapToJavaObjectUsingTypeRef ============");
		
		
		if(obj instanceof List) {
			List resList = (List)obj;
			System.out.println(resList.size());
			
		}else if(obj instanceof Map) {
			Map resObj = (Map)obj;
			System.out.println(((Map)obj).keySet());
			System.out.println("emp obj: "+ resObj.get("employee"));
		}
		
		
		Response response = RestAssured
				.get("https://run.mocky.io/v3/83443fd1-eb19-4893-bfdb-16c01200c4ba");
		
		
		Object object = JSONValue.parse(response.asString());
		
	
		System.out.println(object instanceof JSONArray);
		System.out.println(object instanceof JSONObject);
		
		if(object instanceof JSONArray) {
			List resList = (List)object;
			System.out.println(resList.size());
			
		}else if(object instanceof JSONObject) {
			Map resObj = (Map)object;
			System.out.println(((Map)object).keySet());
			JSONArray arr = (JSONArray) resObj.get("employee");
			System.out.println(arr);
			for (Object ob : arr) {
				System.out.println(ob instanceof JSONObject);
				JSONObject jsonObject = (JSONObject) ob;
				
				System.out.println(jsonObject.get("firstName"));
				jsonObject.put("firstName", "Yanna Raskella");
			}
			System.out.println("=================");
			for (Object ob : arr) {
				System.out.println(ob instanceof JSONObject); 
				JSONObject jsonObject = (JSONObject) ob;
				
				System.out.println(jsonObject.get("firstName"));
				jsonObject.put("firstName", "Yanna Raskella");
			}
		}
		
		/*
		 * String jsonString = resp  onse.asString(); 
		 * Object obj =  JSONValue.parse(jsonString); 
		 * System.out.println(obj instanceof JSONArray); 
		 * if(obj instanceof JSONArray) { 
		 * //First JSONArray then iterate through array
		 * for json objects.. in this case JSONArray array = (JSONArray) obj;
		 */
		
		
	}
	
	@Test
	public void ModerateDynamicUsingObjectMapper() throws JsonMappingException, JsonProcessingException {
		ObjectMapper map = new ObjectMapper();
		Response res = RestAssured
					.get("https://run.mocky.io/v3/83443fd1-eb19-4893-bfdb-16c01200c4ba");
		Map<String, Object> emps = map.readValue(res.asString(), new TypeReference<Map<String, Object>>() {
		});
		System.out.println(emps);
		
		System.out.println(emps.get("employee"));
		
		String data = map.writerWithDefaultPrettyPrinter().writeValueAsString(emps.get("employee"));
		System.out.println(data);
		
		Object object = JSONValue.parse(data);
		System.out.println(object instanceof JSONArray);
		
	}
	

}
