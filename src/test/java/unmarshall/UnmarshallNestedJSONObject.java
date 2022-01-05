package unmarshall;

import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class UnmarshallNestedJSONObject {
	
//	@Test
	public void nestedJSONObjectUnmarshall() {
		Map map= RestAssured
					.get("https://run.mocky.io/v3/be08f41c-c7e7-4248-8ce1-e2ecbf4ba1d1")
					.as(Map.class);		//remains same for nested json object.. but to retruve skill and experience, we need to.. cast Skills to Map again.. 
		
		String name = (String) map.get("name");
		String mobile = (String) map.get("mobile");
		System.out.println("Name: "+ name +" and mobile: "+ mobile);
		
		//but in order retrieve skill and experience, we need to create another Map for skills property.
		
		Map<String, String> skillsMap = (Map<String, String>) map.get("skills");
		
		String skill = skillsMap.get("skill");
		System.out.println("Skill: "+ skill);
		System.out.println("experience: "+ skillsMap.get("experience"));		
	}
	
	@Test
	public void nestedJSONObjectUnmarshallUsingTypeRef() {
		Map<String, Object> map= RestAssured
					.get("https://run.mocky.io/v3/be08f41c-c7e7-4248-8ce1-e2ecbf4ba1d1")
					.as(new TypeRef<Map<String, Object>>(){ });		
		//remains same for nested json object.. but to retruve skill and experience, we need to.. cast Skills to Map again.. 
		
		String name = (String) map.get("name");
		String mobile = (String) map.get("mobile");
		System.out.println("Name: "+ name +" and mobile: "+ mobile);
		
		//but in order retrieve skill and experience, we need to create another Map for skills property.
		
		Map<String, String> skillsMap = (Map<String, String>) map.get("skills");
		
		String skill = skillsMap.get("skill");
		System.out.println("Skill: "+ skill);
		System.out.println("experience: "+ skillsMap.get("experience"));		
	}
}


/*

https://run.mocky.io/v3/59a982f9-4c24-4ccb-9202-96c35ad3516d
{
	"name": "venu",
	"mobile": "7875454",
	"id": 123,
	"sal": 12.3
	"skills":{
		  "skill": "testing",
		  "experience": "12 years"
	}
}
*/