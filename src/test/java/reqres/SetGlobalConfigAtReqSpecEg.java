package reqres;


import static io.restassured.RestAssured.*;
//import static restconfig.ConfigFactory.getDefaultConfig;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import restconfig.ConfigFactory;

public class SetGlobalConfigAtReqSpecEg {
	
	/*
	 * @BeforeClass public void beforeClass() { RestAssured.config=
	 * ConfigFactory.getDefaultConfig(); }
	 */
	
	
	//This example is not configured with request specification and config.. so if it requires to pass headers and other config like url redirects, it has to separately. 
	//Instead of all that, we can create global configs and specification and call them as shown in setConfigGlobalEg method... 
//	@Test			//// no req spec and no config.. 
	public void getSpecificUserDetailsByName() {	
		baseURI = "https://reqres.in/api";
		given()
			.get("/users?page=2")
		.then()	
			.contentType(ContentType.JSON)
			.statusCode(200)
			.body("data[0].email", equalTo("michael.lawson@reqres.in"));
	}
	
	@Test
	public void setConfigGlobalEg() {		
		given()
			.log().all()
			.spec(getDefaultReqSpecBuilder())
			.get("/users?page=2")			
		.then()	
			.contentType(ContentType.JSON)
			.statusCode(200)
			.body("data[0].email", equalTo("michael.lawson@reqres.in"))
			.and()
			.log().all();
	}
	// This is a local req spec example.. if designed like this, tis method is rquired in every test.. 
	//Instead create a common util as shown in common package and call it in given using spec method.
	public static RequestSpecification getDefaultReqSpecBuilder() {
		return  new RequestSpecBuilder()
				.setAccept(ContentType.JSON)
				.setBaseUri("https://reqres.in/api")
				.setConfig(ConfigFactory.getDefaultConfig())			
				.build();
	}
	
	
	
	
	
}
