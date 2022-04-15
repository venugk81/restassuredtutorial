package jsonnode;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchFromJSONUsingJacksonAt {

	//http://makeseleniumeasy.com/2020/09/05/rest-assured-tutorial-45-fetch-value-from-nested-json-object-using-jsonnode-jackson-at-method/
	@Test
	public void parseJsonObjectToReadValues() throws JsonMappingException, JsonProcessingException
	{
		String jsonObject = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				"  \"married\": false,\r\n" + 
				"  \"salary\": 2000.54,\r\n" + 
				"  \"addressPin\": 45324,\r\n" + 
				"  \"skills\" :{\r\n" + 
				"    \"Java\" :\"Intermediate\",\r\n" + 
				"    \"Selenium\" :\"Intermediate\",\r\n" + 
				"    \"Javascript\" :\"Beginner\"\r\n" + 
				"  }\r\n" + 
				"}";
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get tree representation of json
		JsonNode jsonTree = objectMapper.readTree(jsonObject);
		
		// Using chaining of get() methods
		String javaLevel = jsonTree.get("skills").get("Java").asText();
		System.out.println(javaLevel);
		
		// Using chaining of path() methods
		String javaLevel2 = jsonTree.path("skills").path("Java").asText();
		System.out.println(javaLevel2);
		
		// Using pattern expression with at()
		String javaLevel3 = jsonTree.at("/skills/Java").asText();
		System.out.println(javaLevel3);
		
		//at() method will never return null if no matching node exists. In that case, it will return a node for which isMissingNode() method returns true.
		
	}
}
