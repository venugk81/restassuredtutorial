package restconfig;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.listener.ResponseValidationFailureListener;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;



public class ConfigFactory {
	
	//Global COnfig with redirect, object mapper and failure listener.. 
	public static RestAssuredConfig getDefaultConfig() {
		return RestAssured.config()				
				.redirect(RedirectConfig.redirectConfig().maxRedirects(3))
				.and()
				.failureConfig(FailureConfig.failureConfig().failureListeners(getFailureListener()))
				.and()
				.objectMapperConfig(ObjectMapperConfig.objectMapperConfig().jackson2ObjectMapperFactory(getDefaultMapperFactory()));				
	}
	
	public static ResponseValidationFailureListener getFailureListener() {		
		ResponseValidationFailureListener failureListener = (reqSpec, responseSpec, response)-> 
		System.out.printf("We have a failure, "+
				"response code %s and the body is %s", + 
				response.getStatusCode(), response.getBody().asPrettyString());
		return failureListener;
	}
	
	//Map Jackson2 object mapper.. imported from import com.fasterxml.jackson.databind.ObjectMappe r;
	public static Jackson2ObjectMapperFactory getDefaultMapperFactory() {
		return (type, s) -> {
			ObjectMapper om = new ObjectMapper();
			om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return om;		
		};
	}

}
