import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidator {
	
	@Test
	void testget() {
//	baseURL="http://localhost:3000";
		given().get("https://reqres.in/api/users?page=2").then().assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
		;
		
	}

}
