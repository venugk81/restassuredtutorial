package common;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import restconfig.ConfigFactory;

public class RequestSpecificationUtil {
	public static RequestSpecification reqSpec;
	
	public static RequestSpecification getDefaultReqSpecification() {
		reqSpec = RestAssured.given()
				.log().all()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.baseUri("https://reqres.in/api")
				.config(ConfigFactory.getDefaultConfig());		
		return reqSpec;
				
	}
	
	public static RequestSpecification getDefaultReqSpecificationBuilder() {
		reqSpec = new RequestSpecBuilder()
				.log(LogDetail.ALL)
				.setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON)
				.setBaseUri("https://reqres.in/api")
				.setConfig(ConfigFactory.getDefaultConfig())			//Here Set methods are used to configure 			
				.build();			
		return reqSpec;
				
	}
	
}
