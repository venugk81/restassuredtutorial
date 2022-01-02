package jsonpatheg;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;




public class JPathModerateJSONDataFilters {
	
	@Test
	public void testSimpleJSon() {
		String filePath = System.getProperty("user.dir") + "\\data\\jsonarraydata.json";
		File f = new File(filePath);
		if(f.exists()) {
			JsonPath jp = new JsonPath(f);
			System.out.println("size: "+ jp.getInt("data.size()"));
			//or
			System.out.println("Size using List explicitly: "+ jp.getList("data").size());
			
			//get first employee name: 
			System.out.println("get first employee name: "+ jp.getString("data[0].empname"));
			//get all male emp names:
			
			List<String> names = jp.getList("data.findAll{it.gender=='Male'}.empname");
			System.out.println("\n All Male emp names: "+ names);
			
			
			
		}else {
			Assert.fail("File doesn't exists: "+ filePath);
		}
	}
}





/*  json data format

	
{
	"data": [
		{
			"empid": 123,
			"empname": "venu",
			"is_active": "A",
			"married": false,
			"sal": 205.2,
			"gender": "Male"
		},
		{
			"empid": 127,
			"empname": "g",
			"is_active": "A",
			"married": false,
			"sal": 10,
			"gender": "Male"
		},
		{
			"empid": 126,
			"empname": "kG",
			"is_active": "A",
			"married": false,
			"sal": 11,
			"gender": "Male"
		},
		{
			"empid": 124,
			"empname": "Geetha",
			"is_active": "T",
			"married": false,
			"gender": "Female"
		}
	]
}


	
*/