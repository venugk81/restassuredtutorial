package jsonpatheg;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;




public class ValidateSimpleJSONObject {
	
	/*
	 * String s = "{\r\n" + "	\"firstname\": \"Sally\",\r\n" +
	 * "	\"lastname\": \"Brown\",\r\n" + "	\"totalprice\": 111,\r\n" +
	 * "	\"depositpaid\": true\r\n" + "}";
	 */
	
	@Test
	public void testSimpleJSon() {
		String filePath = System.getProperty("user.dir") + "\\data\\simplejson.json";
		File f = new File(filePath);
		if(f.exists()) {
			JsonPath jp = new JsonPath(f);
			System.out.println((Object)jp.get("$"));
			System.out.println("First name: "+ jp.getString("firstname"));
			System.out.println(jp.getString("Checkin: "+ "bookingdates.checkin"));
			
		}else {
			Assert.fail("File doesn't exists: "+ filePath);
		}
	}
}





/*  json data format

	{
	"firstname": "Sally",
	"lastname": "Brown",
	"totalprice": 111,
	"depositpaid": true,
	"bookingdates": {
	    "checkin": "2013-02-23",
	    "checkout": "2014-10-23"
	},
	"additionalneeds": "Breakfast"
	}
*/