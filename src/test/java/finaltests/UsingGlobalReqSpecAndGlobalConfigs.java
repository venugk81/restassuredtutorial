package finaltests;


import static io.restassured.RestAssured.*;
//import static restconfig.ConfigFactory.getDefaultConfig;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.RequestSpecificationUtil;
import common.ResponseSpecificationsUtil;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import restconfig.ConfigFactory;

public class UsingGlobalReqSpecAndGlobalConfigs {
	
	/*
	 * @BeforeClass public void beforeClass() { RestAssured.config=
	 * ConfigFactory.getDefaultConfig(); }
	 */
	
	
	//This example is not configured with request specification and config.. 
	//so if it requires to pass headers and other config like url redirects, it has to separately. 
	//Instead of all that, we can create global configs and specification and call them as shown in setConfigGlobalEg method... 
//	@Test			//// no req spec and no config.. 
	public void getSpecificUserDetailsByName() {	
		baseURI = "https://reqres.in/api";
		given()
			.config(ConfigFactory.getDefaultConfig())		
			// set the config at the test level.. or we can set config in request specification and call specification at test level.
			.get("/users?page=2")			
		.then()	
			.contentType(ContentType.JSON)
			.statusCode(200)
			.body("data[0].email", equalTo("michael.lawson@reqres.in"));
	}
	
	
	//Here we are setting global request specifications which are already configured with global configs.. 
//	@Test
	public void setConfigGlobalEgAndRun() {		
		given()
			.spec(RequestSpecificationUtil.getDefaultReqSpecification())				/////OR
//			.spec(RequestSpecificationUtil.getDefaultReqSpecificationBuilder())   
			.get("/users?page=2")			
		.then()	
			.contentType(ContentType.JSON)
			.statusCode(200)
			.body("data[0].email", equalTo("michael.lawson@reqres.in"))
			.and()
			.log().all();
	}
	
	///Time to take care of common response validations using ResponseSpecifications/builder
	
	//Here we are setting global request specifications which are already configured with global configs.. 
		@Test
		public void setbothSpecsAndRun() {		
			given()
				.spec(RequestSpecificationUtil.getDefaultReqSpecification())				/////OR
//				.spec(RequestSpecificationUtil.getDefaultReqSpecificationBuilder())   
				.get("/users?page=2")			
			.then()	
				.spec(ResponseSpecificationsUtil.getGenericResponseSpecs(200))			/// OR below method 
//				.spec(ResponseSpecificationsUtil.getResponseSpecUsingBuilder(200))
				.body("data[0].email", equalTo("michael.lawson@reqres.in"))
				.and()
				.log().all();
		}
	
}
