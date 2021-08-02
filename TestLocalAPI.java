import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class TestLocalAPI {
	
//	@Test
	void get() {
//		baseURL="http://localhost:3000";
		given().get("http://localhost:3000/comments").then().statusCode(200).log().all();
		
	}
	
//	@Test
	void post() {
		JSONObject request=new JSONObject();
		request.put("id", "2");
		request.put("body", "Hello");
		request.put("postId", "2");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when().post("http://localhost:3000/comments").then().statusCode(201)
;	
	}
	
	@Test
	void delete() {
	
when().delete("http://localhost:3000/comments/2").then().statusCode(200)
;	
	}
	
}
