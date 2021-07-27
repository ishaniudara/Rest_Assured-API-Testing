import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestGet {
	@Test
	void test1()
	{
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.body());
	}
}
