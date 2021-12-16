package jsonpathegs;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class HamChrestMatchersBody {
	public static final String BASE_URL= "https://api.github.com/";
//	public static final String BASE_URL= "https://reqres.in/apiusers?page=2";
	
	@Test
	public void usingHamCrestValidations() {
		RestAssured.get(BASE_URL)
		.then()
			.body(containsString("current_user_url"))
			.body("issue_search_url", equalTo("https://api.github.com/search/issues?q={query}{&page,per_page,sort,order}"))
			.body("current_user_url", equalTo(BASE_URL + "user"));
		
	}

}
