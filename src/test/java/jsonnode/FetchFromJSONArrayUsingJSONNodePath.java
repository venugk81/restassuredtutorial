package jsonnode;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FetchFromJSONArrayUsingJSONNodePath {
	//http://makeseleniumeasy.com/2020/09/16/rest-assured-tutorial-46-fetch-value-from-json-array-using-jsonnode-jackson-get-path-methods/
	
	@Test
	public void parseJsonArrayToReadValues() throws JsonMappingException, JsonProcessingException
	{
		String jsonArray = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Amod\",\r\n" + 
				"    \"lastName\": \"Mahajan\",\r\n" + 
				"    \"age\": 28,\r\n" + 
				"    \"isMarried\": false,\r\n" + 
				"    \"salary\": 23456.54\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Rahul\",\r\n" + 
				"    \"lastName\": \"Arora\",\r\n" + 
				"    \"age\": 32,\r\n" + 
				"    \"isMarried\": true,\r\n" + 
				"    \"salary\": 33456.54\r\n" + 
				"  }\r\n" + 
				"]";
		
		
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get tree representation of json
		JsonNode jsonTree = objectMapper.readTree(jsonArray);
		
		// To know if tree is a JSON object or JSON array
		System.out.println("Is parsed JSOn tree a JSON Object?"+ Boolean.toString(jsonTree instanceof ObjectNode));
		System.out.println("Is parsed JSOn tree a JSON Array?"+ Boolean.toString(jsonTree instanceof ArrayNode));
		
		// Get first json object and storing 
		JsonNode firstJsonObject = jsonTree.get(0);
		// Get second json object and storing 
		JsonNode secondJsonObject = jsonTree.get(1);
		
		// Get value of firstName as string
		String firstName = firstJsonObject.get("firstName").asText();
		String lastName = firstJsonObject.get("lastName").asText();
		// Get value of married as boolean
		int age = firstJsonObject.get("age").asInt();
		boolean married = firstJsonObject.get("isMarried").asBoolean();
		double salary = firstJsonObject.get("salary").asLong();
		
		System.out.println("FirstName is : "+firstName);
		System.out.println("LastName is  : "+lastName);
		System.out.println("Age is   : "+age);
		System.out.println("Maritial status is    : "+married);
		System.out.println("Salary is: "+salary);
		
		
		// Get value of firstName as string
		firstName = secondJsonObject.get("firstName").asText();
		lastName = secondJsonObject.get("lastName").asText();
		// Get value of married as boolean
		age = secondJsonObject.get("age").asInt();
		married = secondJsonObject.get("isMarried").asBoolean();
		salary = secondJsonObject.get("salary").asLong();
		
		System.out.println("FirstName is : "+firstName);
		System.out.println("LastName is  : "+lastName);
		System.out.println("Age is   : "+age);
		System.out.println("Maritial status is    : "+married);
		System.out.println("Salary is: "+salary);
				
	}
}
