import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath; 

public class XMLValidator {
	@Test
	void validator() throws IOException {
		
		File file=new File("./SOAPxml/Add.xml");
		FileInputStream fileInput=new FileInputStream(file);
		String requestBody= IOUtils.toString(fileInput, "UTF-8");
//				(fileInput, "UTF-8");
		
		
		
		baseURI="http://www.dneonline.com/";
		
		given().
		contentType("text/xml").
		accept(ContentType.XML).
		body(requestBody).
		when().
		post("/calculator.asmx").
		then().
		statusCode(200).log().all().and().assertThat().body(matchesXsdInClasspath("Cal.xsd"));
		
	}
	
		
	}


