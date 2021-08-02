import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;



public class Test_Get {

	@Test
	void test_01(){
		given().
		get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200).
		body("data.id[1]", equalTo(8)).
		log().all();
		
		
		
	}

}
