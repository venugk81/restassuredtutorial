package testngdatasharing;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restconfig.ConfigFactory;

public class CreateBooking {
	
//	@Test
	public void getBookers() {
		RestAssured.get("https://restful-booker.herokuapp.com/booking/1").then().log().all();
	}
	
	
	@Test(priority = 1)
	public void Booking(ITestContext context) {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
		
		Map<String, Object> obj = new LinkedHashMap<>(); 
		
		obj.put("firstname", "Jim");
		obj.put("lastname", "Brown");
		obj.put("totalprice", 121);
		obj.put("depositpaid", true);
		
		
		Map<String, Object> obj1 = new LinkedHashMap<String, Object>(); 
		obj1.put("checkin", "2018-01-01");
		obj1.put("checkout", "2019-01-01");
		
		obj.put("bookingdates", obj1);
		obj.put("additionalneeds", "Breakfast");
		
		/*
		 * String jsonBody ="{\r\n" + "    \"firstname\" : \"Jim\",\r\n" +
		 * "    \"lastname\" : \"Brown\",\r\n" + "    \"totalprice\" : 111,\r\n" +
		 * "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n" +
		 * "        \"checkin\" : \"2018-01-01\",\r\n" +
		 * "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n" +
		 * "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";
		
		 */
		
		
		int bookingID = RestAssured
				.given()
					.log().all()
					.config(ConfigFactory.getDefaultConfig())
					.body(obj)
				.when()
					.post()
				.then()
					.statusCode(HttpStatus.SC_SUCCESS)
				.and()
					.extract()
					.response()
					.jsonPath()
					.get("bookingid");
		System.out.println("Booking ID: "+ bookingID);
		
		
//		RestAssured
//		.given()
//			.log().all().body(obj).when().get();
	}

}
