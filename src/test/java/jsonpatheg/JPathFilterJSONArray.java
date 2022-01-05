package jsonpatheg;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;




public class JPathFilterJSONArray {
	
	@Test
	public void testSimpleJSon() {
		String filePath = System.getProperty("user.dir") + "\\data\\jsonarray.json";
		File f = new File(filePath);
		if(f.exists()) {
			JsonPath jp = new JsonPath(f);
			System.out.println((Object)jp.get("$"));
			
			//size
			System.out.println("JSON Array Size: "+jp.getList("").size());
			
			System.out.println("Size-----------------: "+ jp.getInt("size()"));

//			get all female employees empname
			List<String> femaleEmps = jp.getList("findAll{it.gender=='Female'}.empname");
			System.out.println(femaleEmps);
			
//			get all female employees details.. All details
			List<Object> femaleEmployees = jp.getList("findAll{it.gender=='Female'}");
			System.out.println(femaleEmployees);
			
			//get terminated employee data:
			List<Integer> terminatedEmployees = jp.getList("findAll{it.is_active=='T'}.empid");
			System.out.println("Terminated Employee IDs List: "+ terminatedEmployees);
			
//			get all employees salary
			List<Double> allEmpSal = jp.getList("sal");		//null if sal tag is not avaible for any employee
			System.out.println(allEmpSal);
			
			//get employee sal if greater than 20
			List<Object> sal10 = jp.getList("findAll{it.sal>10}.empid");
			System.out.println("Empl ids whose sal is great than 10: "+ sal10);
			
			sal10 = jp.getList("findAll{it.sal>10}");
			System.out.println("Employees whose sal is great than 10: "+ sal10);
			
			//Femlae salary greater than 10
			sal10 = jp.getList("findAll{it.sal>10 & it.gender=='Female'}.empname");			// and operator .. use | for operator
			System.out.println("Female Employees whose sal is great than 10: "+ sal10);
			
//			get employe id whose name is Geetha find returns only one output
			int id1 = jp.getInt("find{it.empname=='Geetha'}.empid");
			System.out.println("employe id whose name is Geetha: " + id1);
			
//			get employe id whose name is Geetha find returns only one output			//startsWith
			List<Integer> ids = jp.getList("findAll{it.empname.startsWith('G')}.empid");
			System.out.println("employe id whose name is Geetha: " + ids);
			
			//contains
			ids = jp.getList("findAll{it.empname.contains('G')}.empname");
			System.out.println("employe id whose name is Geetha: " + ids);
			
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
	},
		{
		"empid": 128,
		"empname": "Gayatri",
		"is_active": "T",
		"married": false,
		"gender": "Female"
	},
	{
		"empid": 125,
		"empname": "Seetha",
		"is_active": "A",
		"married": true,
		"sal": 15,
		"gender": "Female"
	}
]


	
*/