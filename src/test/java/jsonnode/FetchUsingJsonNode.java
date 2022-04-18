package jsonnode;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchUsingJsonNode {
	@Test
	public void parseJsonObjectToReadValues() throws JsonMappingException, JsonProcessingException
	{
		String jsonObject = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				"  \"married\": false,\r\n" + 
				"  \"salary\": 2000.54,\r\n" + 
				"  \"addressPin\": 45324\r\n" + 
				"}";
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get tree representation of json
		JsonNode jsonTree = objectMapper.readTree(jsonObject);
		// Get value of firstName as string
		String firstName = jsonTree.get("firstName").asText();
		String lastName = jsonTree.get("lastName").asText();
		// Get value of married as boolean
		boolean married = jsonTree.get("married").asBoolean();
		double salary = jsonTree.get("salary").asDouble();
		long addressPin = jsonTree.get("addressPin").asLong();
		
		System.out.println("FirstName is : "+firstName);
		System.out.println("LastName is  : "+lastName);
		System.out.println("Married is   : "+married);
		System.out.println("Salary is    : "+salary);
		System.out.println("Addresspin is: "+addressPin);
		
		//http://makeseleniumeasy.com/2020/09/01/rest-assured-tutorial-44-fetch-value-from-json-object-using-jsonnode-jackson/
		
	}
}
