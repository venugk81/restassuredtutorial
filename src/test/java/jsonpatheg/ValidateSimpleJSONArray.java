package jsonpatheg;

import java.io.File;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;




public class ValidateSimpleJSONArray {
	
	@Test
	public void testSimpleJSon() {
		String filePath = System.getProperty("user.dir") + "\\data\\jsonarray.json";
		File f = new File(filePath);
		if(f.exists()) {
			JsonPath jp = new JsonPath(f);
			System.out.println((Object)jp.get("$"));
			System.out.println("First emp id: "+ jp.getString("[0].empid"));
			System.out.println("emp ids: "+ jp.getList("empid"));
			System.out.println("Last emp id: "+ jp.getList("empid").get(1));
			System.out.println(jp.getBoolean("[0].married"));
			
			System.out.println("jp.getList(\"\").get(0): "+ jp.getList("").get(0));
			System.out.println("Get complete json object jp.get(\"\"): "+ jp.get(""));
			System.out.println("Get First Element jp.getList(\"\").get(0): "+ jp.getList("").get(0));
			System.out.println("===============Get Map==============");
			Map<String, Object>  map = (Map<String, Object>) jp.getList("").get(0);
			System.out.println("Salary: "+ map.get("sal"));
			
		}else {
			Assert.fail("File doesn't exists: "+ filePath);
		}
	}
}





/*  json data format

	[
	{
		"empid": 123,
		"empname": "venu",
		"isActive": "A",
		"married": false,
		"sal": 205.2
	},
	{
		"empid": 124,
		"empname": "G",
		"isActive": "L",
		"married": false
	}
]

	
*/