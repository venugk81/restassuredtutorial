package common;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationsUtil {
	public static ResponseSpecification responseSpec;
	
	public static ResponseSpecification getGenericResponseSpecs(int StatusCode) {
		responseSpec = RestAssured.expect()
				.statusCode(StatusCode)
				.contentType(ContentType.JSON)				
				.time(Matchers.lessThan(3000L));
		return responseSpec;
	}
	
	public static ResponseSpecification getResponseSpecUsingBuilder(int StatusCode) {
		responseSpec = new ResponseSpecBuilder()
				.expectStatusCode(StatusCode)
				.expectContentType(ContentType.JSON)
				.expectResponseTime(Matchers.lessThan(3000L))
				.build();
		return responseSpec;				
	}

}
