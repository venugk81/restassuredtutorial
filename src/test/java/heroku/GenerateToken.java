package heroku;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenerateToken {

	String userName = "admin";
	String password = "password123";
	String token = "";

	GenerateToken() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

	}

//	@Test
	public void authentication() {

	
		/*
		 * PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		 * authScheme.setUserName(userName); authScheme.setPassword(password);
		 * RestAssured.authentication = authScheme;
		 */
		
		/*
		 * Response response =
		 * RestAssured.given().when().post("/auth").then().assertThat()
		 * .statusCode(200).extract().response();
		 * System.out.println(response.asPrettyString());
		 */
		RequestSpecification spec= RestAssured.given()
				.auth()
				.preemptive()
				.basic(userName, password);
		Response res = spec.get("/auth").
				then()
				.log().all()
				.statusCode(200)
				.extract().response();
		System.out.println(res.asPrettyString());
		
	}
	
//	@Test
	public void basicPreEmptiveAuth() {
		RequestSpecification spec= RestAssured.given()
				.log().all()
				.auth()
				.preemptive()
				.basic("postman", "password");
		Response res = spec.get("https://postman-echo.com/basic-auth")
				.then()
				.log().all()
				.extract()
				.response();
		System.out.println(res.asPrettyString());
	}
	
	@Test
	public void basicAuth() {
		RequestSpecification spec= RestAssured.given()
				.log().all()
				.auth()
				.basic("postman", "password");
		
		Response res = spec.get("https://postman-echo.com/basic-auth")
				.then()
				.extract()
				.response();
		System.out.println(res.asPrettyString());
	}
	
	
	@Test
	public void generateToken() {
		
		JSONObject obj = new JSONObject(); 
		obj.put("username", "admin");
		obj.put("password", "password123");
		
		/*
		 * Response res = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
		 * + "    \"username\" : \"admin\",\r\n" +
		 * "    \"password\" : \"password123\"\r\n" +
		 * "}").baseUri("https://restful-booker.herokuapp.com/").when().post("auth").
		 * then().extract().response();
		 */
		
//		Map<String, String> obj = new LinkedHashMap<String, String>();
//		obj.put("username", "admin");
//		obj.put("password", "password123");
		
		
		///since i static imported RestAssured , i can ignore RestAssured and directly write given().. instead of RestAssured.given()
		Response res = given()
					.log().all()
					.contentType(ContentType.JSON)
					.body(obj.toJSONString())
//					.body(obj)
					.baseUri("https://restful-booker.herokuapp.com/")
				.when()
					.post("auth")
				.then()
					.log().all()
//					.statusCode(200)
					.extract()
					.response();
		System.out.println(res.asPrettyString());
	}

}
