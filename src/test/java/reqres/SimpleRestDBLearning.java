package reqres;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SimpleRestDBLearning {
//	Object userData[][] = null;
	public SimpleRestDBLearning() {
		baseURI = "http://localhost:3000";
	}
	
	//sample rest api for learning : restful-booker.herokuapp.com
	//create json body for post: http:s//naveenautoamtionlabs.com/http-post-method-using-restassured
	
	@Test
	void getAllUsersData() {
		given().get("/users").then().log().all();
	}
	
//	@Test
	void getUserByID() {
		given().param("id", 1).
		get("/users").then().log().all();
	}
	
//	@Test
	void addUserData() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("firstName", "Aditya");
		jsonObj.put("lastName", "IK");
		jsonObj.put("subjectId", 3);			
		given().
			contentType(ContentType.JSON).accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(jsonObj.toJSONString()). 
		when().
			post("/users").
		then().
			statusCode(201).log().all();		
	}
	
//	@Test
	void updateUserData() {
		JSONObject jsonObj = new JSONObject();	
		jsonObj.put("firstName", "Aditya");
//		jsonObj.put("lastName", "IK");
		jsonObj.put("subjectId", 2);				
		given().
			contentType(ContentType.JSON).accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(jsonObj.toJSONString()).
		when().
			patch("/users/2").
//			put("/users/4").		// Try this.. 
		then().
			statusCode(200).log().all();			
		//Patch is used to update partial data.. I mean u can send partial data as input object.. 
		//In case of put, u need to send all the data including what u want to change. else, data which u r not sending will be deleted completely.. 
	}
	
	
//	@Test
	void DeleteUserData() {
		JSONObject jsonObj = new JSONObject();			
		given().
			contentType(ContentType.JSON).accept(ContentType.JSON).
			header("Content-Type", "application/json").   
			body(jsonObj.toJSONString()).
		when().
			delete("/users/3").
		then().
			statusCode(200).log().all();
	}
	
	
	@DataProvider(name="userData")
	public Object[][] multiUserData(){		
		Object userData[][] = new Object[2][3];  //2*3 matrix data..
		userData[0][0] ="Andy";
		userData[0][1] ="Ga";
		userData[0][2] =1;
		
		userData[1][0] ="JIM";
		userData[1][1] ="cooper";
		userData[1][2] =2;		
		
		userData[1][0] ="Raj";
		userData[1][1] ="Koothrapali";
		userData[1][2] =2;	
		return userData;		
	}
	
//	@Test(dataProvider = "userData")
	void addMultipleUsers(String firstname, String lastname, int subjID ) {
		JSONObject jsonObj = new JSONObject();	
		jsonObj.put("firstName", firstname);
		jsonObj.put("lastName", lastname);
		jsonObj.put("subjectId", subjID);
		
		given().
			contentType(ContentType.JSON).accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(jsonObj.toJSONString()).
		when().
			post("/users").
		then().
			log().all();		
	}
	
	
	@DataProvider(name="DeleteUsers")
	public Object[] deleteUsers() {
		Object delObjData[] = new Object[2];
		delObjData[0]=8;
		delObjData[1]=7;		
		return delObjData;	
		
		//second approach directly like this.. 
//		return new Object[] = {7, 8 };
	}
	
//	@Test(dataProvider = "DeleteUsers")
	public void deleteUser(int id) {
		JSONObject json = new JSONObject();
		json.put("id", id);
		
		given().
			contentType(ContentType.JSON).accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(json.toJSONString()).
		when().
			delete("users/"+id).
		then().
			log().all();
	}
	
	
	@Test
	public void printJSONObject() {
		JSONObject jsonObj = new JSONObject();	
		jsonObj.put("firstName", "Aditya");
//		jsonObj.put("lastName", "IK");
		jsonObj.put("subjectId", 2);				
		System.out.println("============000=================");
		System.out.println(jsonObj.toJSONString());
		//output: {"firstName":"Aditya","subjectId":2}
	}
	
		
	
	

}
