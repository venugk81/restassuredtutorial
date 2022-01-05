package unmarshall;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class SimpleObjectUnmarshall {
	
	@Test
	public void simpleObject() {
		Map map = RestAssured
					.get("https://run.mocky.io/v3/871defb7-1e42-464e-b1f8-2479fa8e2ee2")
					.as(Map.class);					// THis is not a good approach. Instead use java maps with generics.. typeRef..typeRef is an abstract class with no abstract method..
//		TypeRef is used to convert any class to a generic type..
		//TypeRef allows to convert json resonse to any generic class type
		System.out.println("Mapped to Map.class============");
		System.out.println(map.get("mobile"));
		String mobile = (String) map.get("mobile");
		System.out.println(map.get("id"));
		
		//Iterate the values using Map
		
		map.keySet().forEach(key-> System.out.println("Key: "+ key + " and value is: "+ map.get(key)));
	}
	//Above method is to use Map.class to convert simple json response to Map.
	/*
	 {
		  "name": "venu",
		  "mobile": "7875454",
		  "id": 123,
		  "sal": 12.3
	}
	 */
	
	//Another way to unmarshall is to create a java class with all the fields we get in json resonse and then use it 
	
	
	//.as() : Get the body and map it to a Java object. For JSON responses this requires that you have either
	@Test
	public void simpleObjectMapToJavaClass() {
		SimpleObjectMapping obj = RestAssured
					.get("https://run.mocky.io/v3/871defb7-1e42-464e-b1f8-2479fa8e2ee2")
					.as(SimpleObjectMapping.class);
		System.out.println("\nMapped to SimpleObjectMapping.class============");
		System.out.println("obj.getMobile(): "+ obj.getMobile());
		System.out.println("obj.getId() "+ obj.getId());
	}
	
	//Another way using TypeRef<T> generic class type(T)
//	TypeRef is a generic abstract class with no abstract methods used for obtaining fill generics type information by sub classing. 
	//usage is by sub classing. example to instantiate ref to generic list ty List<Integer>
	//TypeReference ref = new TypeReference<List>Integer>>(){ };.
	
	@Test
	public void simpleObjectMapToJavaObjectUsingTypeRef() {
		Map<String, Object> map = RestAssured
					.get("https://run.mocky.io/v3/871defb7-1e42-464e-b1f8-2479fa8e2ee2")
					.as(new TypeRef<Map<String, Object>>(){ });
					
					System.out.println("\nMapped to TypeRef ============");
					System.out.println(map.get("mobile"));
					String mobile = (String) map.get("mobile");
					System.out.println(map.get("id"));
					
					//Iterate the values using Map
					
					map.keySet().forEach(key-> System.out.println("Key: "+ key + " and value is: "+ map.get(key)));
	}

}
