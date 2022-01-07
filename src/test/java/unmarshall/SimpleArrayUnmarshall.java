package unmarshall;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

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
	@Test
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

}
