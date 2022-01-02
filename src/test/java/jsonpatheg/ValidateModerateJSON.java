package jsonpatheg;

import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;




public class ValidateModerateJSON {
	

	
	@Test
	public void testModerateJSon() {
		String filePath = System.getProperty("user.dir") + "\\data\\moderateJSON.json";
		File file = new File(filePath);
		if(file.exists()) {
			JsonPath jp = new JsonPath(file);
			System.out.println("\nGet List (Object)jp.get(\"$\")===========================");
			System.out.println("\n(Object)jp.get(\"$\"): "+ (Object)jp.get("$"));
			System.out.println("(Object)jp.get(\"employees.employee\"): "+ (Object)jp.get("employees.employee"));
			System.out.println("Get List jp.getList(\"employees.employee\").get(0)===========================");
			System.out.println("(Object)jp.get(\"employees.employee\").get(0): "+ jp.getList("employees.employee").get(0));
			System.out.println("Get List employees.employee===========================");
			System.out.println("(Object)jp.get(\"employees.employee\"): "+ jp.getList("employees.employee"));
			
//			All emp ids:
			List<Integer> allIDS = jp.getList("employees.employee.id");
			System.out.println("All emp ids:: "+ allIDS);
			
//			"All address of first employee"
			List<Object> addresses = jp.getList("employees.employee[0].address");
			System.out.println("All address of first employee: "+ addresses);
			
			//Filters start here..
//			jp.getList("findAll{it.empname.startsWith('G')}.empid");
//			employees whose pin is 4001
			List<Object> TomDetails = jp.getList("employees.employee.findAll{it.firstName=='Tom'}");
			System.out.println("\nTom Details: "+ TomDetails);
			
			List<Integer> TomIDs = jp.getList("employees.employee.findAll{it.firstName=='Tom'}.id");
			System.out.println("\nAll Tom ids employees.employee.findAll{it.firstName=='Tom'}.id: "+ TomIDs);
			
			//get All firstnames from json..
			List<String> allNames = jp.getList("employees.employee.firstName");
			System.out.println("All emp first names: "+ allNames);
			
		}else {
			Assert.fail("File doesn't exists: "+ filePath);
		}
	}
}



