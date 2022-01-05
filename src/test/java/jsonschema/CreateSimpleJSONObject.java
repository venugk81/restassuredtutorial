package jsonschema;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateSimpleJSONObject {
	Map<String, Object> map = new LinkedHashMap<>();
	Map<String, Object> addressMap = new LinkedHashMap<>();
	List<Map<String, Object>> lst = new LinkedList<>();
	
	public Map<String, Object> createSimpleJSONObject() {
		map.put("id", 1);
		map.put("first_name", "Abagael");
		map.put("last_name", "Kingsnoad");
		map.put("email", "akingsnoad0@icq.com");
		map.put("married", false);
		map.put("salary", 46.946);
		return map;
	}
	
	public Map<String, Object> addressMap() {
		addressMap.put("address1", "Malkajgiri, ayyappa road");
		addressMap.put("address2", "street 40");
		addressMap.put("city", "Hyderabnad");
		addressMap.put("state", "AP");
		addressMap.put("pin", 51214);	
		
		return addressMap;
	}
	
	public List<Map<String, Object>> createSimpleJSONOArray() {
		lst.add(createSimpleJSONObject()); 
		return lst;
	}
	
	public Map<String, Object> createModerateJSONObject() {
		map.put("address", addressMap());			// for map inside main map..
		return map;
	}
	
	
	
//	@Test
	public void prepareRequestForJSONObject() {
		System.out.println("==============Simple JSON Object================");
		RestAssured.given().log().all().body(createSimpleJSONObject()).get();
	}
	
//	@Test
	public void prepareRequestForJSONArray() {
		System.out.println("==============Simple JSON Array================");
		RestAssured.given().log().all().body(createSimpleJSONOArray()).get();
	}
	
//	@Test
	public void prepareModerateJSONObject() {
		System.out.println("==============Mederate JSON Object================");
		Map<String, Object> map1 =   new LinkedHashMap<>();
		map1 = createSimpleJSONObject();
//		System.out.println(map1);
		map1.put("address", addressMap());	//map inside another map..
//		System.out.println(map1);
		
		RestAssured.given().log().all().body(map1).get();
		
	}
	
//	@Test
	public void prepareJSONObjectWithJSONArray() {
		System.out.println("==============Mederate JSON Object================");
		Map<String, Object> map1 =   new LinkedHashMap<>();
		map1 = createSimpleJSONObject();
		
		lst.clear();
		lst.add(addressMap()); 
		lst.add(addressMap()); 
		map1.put("address", lst);		// json array inside json object.		
		
		RestAssured.given().log().all().body(map1).get();
		
	}
	
	@Test
	public void testMapofMap() {
		Map<String, Object> map1 = new LinkedHashMap<>();
		Map<String, Object> map2 = new LinkedHashMap<>();
		map1.put("empid", 1);
		map2.put("active", "A");
		map1.put("address", map2);
		RestAssured.given().log().all().body(map1).get();
		
	}
	

}
