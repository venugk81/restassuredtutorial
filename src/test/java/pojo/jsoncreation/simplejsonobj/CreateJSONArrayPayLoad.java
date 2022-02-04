package pojo.jsoncreation.simplejsonobj;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateJSONArrayPayLoad {
	
	SimpleJsonArray sjPojo;
	
	@Test
	public void testSimpleJSONObject() {
		sjPojo = new SimpleJsonArray();
		sjPojo.setName("Venu");
		sjPojo.setAge(26);
		sjPojo.setDesignation("QA");	
//		System.out.println(sjPojo);
		System.out.println("====================Simple JSON Array");
		ArrayList<Object> al = new ArrayList<>();
		al.add(sjPojo);
		
		RestAssured.given().body(al).log().all().when().get();
	}

}

/*
[
	{
	"name":"Venu",
	"age":26,
	"designation":"QA"
	}
]

*/