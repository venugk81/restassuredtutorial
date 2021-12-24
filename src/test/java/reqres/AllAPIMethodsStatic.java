package reqres;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AllAPIMethodsStatic {
//	@Test(priority=3)
	void getUsersDataStatusCode() {
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.log().all();
	}

//	
//	@Test
	void getDataByID() {
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.body("data.id[2]", equalTo(9));
	}

//	@Test(priority = 1)
	void insertUserData() {
		JSONObject obj = new JSONObject();
		obj.put("name", "venug");
		obj.put("job", "testerg");
		given()
			.body(obj.toJSONString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201);
	}

//	@Test(priority = 2)
	void PutUserData() {
		JSONObject obj = new JSONObject();

		obj.put("name", "venuag");
		obj.put("job", "testerg");
		given()
			.header("content-type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(obj.toJSONString())
		.when()
			.post("https://reqres.in/api/users/2")
		.then()
			.statusCode(201).log().all();
	}

//	@Test(priority = 3)
	void PatchUserData() { // patch is for again update like put but for partial data update
		JSONObject obj = new JSONObject();

		obj.put("name", "venuag");
		obj.put("job", "testerg");
		given()
			.header("content-type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(obj.toJSONString())
		.when()
			.post("https://reqres.in/api/users/2")
		.then()
			.statusCode(201)
			.log().all();
	}

	@Test(priority = 2)
	void test_get() {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getHeader("content-type"));
		System.out.println(res.asString());
		System.out.println("------------------------------Pretty Print----------------");
		System.out.println(res.print());

	}

}
