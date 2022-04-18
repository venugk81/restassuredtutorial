package pojo.jsoncreation.simplejsonobj;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class CreateSimpleJSONObject {
	
	SimpleJsonPojo sjPojo;
	
//	@Test
	public void testSimpleJSONObject() {
		sjPojo = new SimpleJsonPojo();
		sjPojo.setName("Venu");
		sjPojo.setAge(26);
		sjPojo.setDesignation("QA");	
//		System.out.println(sjPojo);
		System.out.println("====================Simple JSON Object");
		
		RestAssured.given().body(sjPojo).log().all().when().get();
	
	}
	
//	/////https://www.youtube.com/watch?v=97glUcWs5z0&list=PL-a9eJ2NZlbT0Hoo_Hj43utwgq2VusPyN&index=59
	@Test
	public void testReadJSONFile() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		SimpleJsonArray simpleJSON = mapper.readValue(new File("C:\\Users\\gopiv\\auto\\rest_learning\\data\\jsondatasimple.json"), SimpleJsonArray.class);
		System.out.println(simpleJSON.getName());
		System.out.println("==============Before editing values in json===============");
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(simpleJSON));
		simpleJSON.setAge(30);
		simpleJSON.setName("Venu GOPI");
		
		System.out.println("==============Write value as string===============");
		System.out.println(mapper.writeValueAsString(simpleJSON));
		
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(simpleJSON));
		
		System.out.println("=================================If you dont have a address pojo class then=============");
		Map<String, Object> map = mapper.readValue(new File("C:\\Users\\gopiv\\auto\\rest_learning\\data\\jsondatasimple.json"), 
				new TypeReference<Map<String, Object>>() {});
		
//		Here without a user defined class, we are storing the values of json in a map. then retriving values using keys
		System.out.println("get name: "+ map.get("name"));
		map.replace("name", "xyz");
				
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
	}
	
	/*
	
			Venu
			==============Write value as string===============
			{"name":"Venu","age":26,"designation":"QA"}
			{
			  "name" : "Venu",
			  "age" : 26,
			  "designation" : "QA"
			}

	*/

}


//