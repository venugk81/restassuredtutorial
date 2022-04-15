package jsonnode;

import java.io.File;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EditExistingJSONUsingJsonNodeJackson {
	//http://makeseleniumeasy.com/2020/11/03/rest-assured-tutorial-57-editing-existing-json-object-on-the-fly-using-jsonnode-jackson/
//	https://www.baeldung.com/jackson-json-node-tree-model
	//https://www.twilio.com/blog/java-json-with-jackson
	//https://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial
	
//	@Test(priority = 0)
	public void quickEditToJsonObject() throws JsonMappingException, JsonProcessingException {
		String jsonObject = "{\r\n" + 
				"  \"firstname\": \"Amod\",\r\n" + 
				"  \"lastname\": \"Mahajan\"\r\n" + 
				"}";
 
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get ObjectNode representation of json as json is an Object
		ObjectNode objectNode = objectMapper.readValue(jsonObject, ObjectNode.class);
		objectNode.put("role", "admin");
		objectNode.put("firstname", "Venu");
		System.out.println(objectNode.toPrettyString());
 
	}
	
//	@Test(priority = 1)
	public void addNewNodeToExistingJson() throws JsonMappingException, JsonProcessingException {
		String jsonObject = "{\r\n" + 
				"  \"firstname\": \"Amod\",\r\n" + 
				"  \"lastname\": \"Mahajan\"\r\n" + 
				"}";
 
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get ObjectNode representation of json as json is an Object
		ObjectNode objectNode = objectMapper.readValue(jsonObject, ObjectNode.class);
		
		ObjectNode bookingDetails = objectMapper.createObjectNode();
		bookingDetails.put("firstname", "Jim");
		bookingDetails.put("lastname", "Brown");
 
		objectNode.set("bookingDetails", bookingDetails);
		System.out.println(objectNode.toPrettyString());
 
	}
	
//	@Test(priority = 2)
	public void AddinganewkeyinsideanestedJSONObject() throws JsonMappingException, JsonProcessingException {
		String jsonObject = "{\r\n" + 
				"  \"firstname\" : \"Amod\",\r\n" + 
				"  \"lastname\" : \"Mahajan\",\r\n" + 
				"  \"bookingDetails\" : {\r\n" + 
				"    \"firstname\" : \"Jim\",\r\n" + 
				"    \"lastname\" : \"Brown\"\r\n" + 
				"  }\r\n" + 
				"}";
 
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get ObjectNode representation of json as json is an Object
		ObjectNode objectNode = objectMapper.readValue(jsonObject, ObjectNode.class);
		
		objectNode.with("bookingDetails").put("gender", "male");
		System.out.println(objectNode.toPrettyString());
 
		
	}
	
//	@Test(priority = 3)
	public void Updatevalueexistingkeys() throws JsonMappingException, JsonProcessingException {
		String jsonObject = "{\r\n" + 
				"  \"firstname\" : \"Amod\",\r\n" + 
				"  \"lastname\" : \"Mahajan\",\r\n" + 
				"  \"bookingDetails\" : {\r\n" + 
				"    \"firstname\" : \"Jim\",\r\n" + 
				"    \"lastname\" : \"Brown\"\r\n" + 
				"  }\r\n" + 
				"}";
 
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get ObjectNode representation of json as json is an Object
		ObjectNode objectNode = objectMapper.readValue(jsonObject, ObjectNode.class);
		
		objectNode.put("firstname", "Animesh");
		objectNode.with("bookingDetails").put("firstname", "Rahul");
		System.out.println(objectNode.toPrettyString());
	}
	
//	@Test(priority = 4)
	public void removeDeleteExistingKey() throws JsonMappingException, JsonProcessingException {
		String jsonObject = "{\r\n" + "  \"firstname\" : \"Amod\",\r\n" + "  \"lastname\" : \"Mahajan\",\r\n"
				+ "  \"bookingDetails\" : {\r\n" + "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\"\r\n" + "  }\r\n" + "}";
 
		// Creating an instance of ObjectMapper class
		ObjectMapper objectMapper = new ObjectMapper();
		// Get ObjectNode representation of json as json is an Object
		ObjectNode objectNode = objectMapper.readValue(jsonObject, ObjectNode.class);
 
		objectNode.remove("firstname");
		objectNode.with("bookingDetails").remove("firstname");
 
		System.out.println(objectNode.toPrettyString());
	}
	
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
		String javaLevel2 = jsonTree.path("skills").path("Java").asText();		//path method
		System.out.println(javaLevel2);
		
		// Using pattern expression with at()
		String javaLevel3 = jsonTree.at("/skills/Java").asText();			//////at method
		System.out.println(javaLevel3);
		//at() method will never return null if no matching node exists. In that case, it will return a node for which isMissingNode() method returns true.
	}
	
	
//	@Test
	public void readDataFromJson() {
		File f = null;
		try {
			f = new File(System.getProperty("user.dir")+ "/data/simplejson.json");
			if(f.exists()) {
				ObjectMapper objectMapper = new ObjectMapper();
				// Get tree representation of json			
				JsonNode jsonTree = objectMapper.readTree(f);				
				String createdNestedJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonTree);
				System.out.println("Created plain JSON Object is : \n"+ createdNestedJsonObject);				
			}else {
				System.out.println("File is not found");
			}
		}catch(Exception oExp) {
			oExp.printStackTrace();
		}
	}
	
	@Test
	public void readDataFromJsonFile() {
		File f = null;
		try {
			f = new File(System.getProperty("user.dir")+ "/data/simplejson.json");
			if(f.exists()) {
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode jsonTree = objectMapper.readTree(f);	
				ObjectNode objectNode = objectMapper.readValue(jsonTree.toString(), ObjectNode.class);
				objectNode.put("firstname", "Animesh");
				objectNode.put("depositpaid", "false");
				objectNode.with("bookingdates").put("firstname", "Rahul");
				
				System.out.println("booking date: "+ objectNode.at("/bookingdates").get("checkout"));
				
				String createdNestedJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);
				System.out.println("Created plain JSON Object is : \n"+ createdNestedJsonObject);	
			}else {
				System.out.println("File is not found");
			}
		}catch(Exception oExp) {
			oExp.printStackTrace();
		}
	}
}
