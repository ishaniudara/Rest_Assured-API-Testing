import org.testng.annotations.Test;
import org.apache.commons.io.IOUtils;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
//import io.restassured.internal.util.IOUtils;

//import static io.restassured.internal.util.IOUtils;

import static io.restassured.RestAssured.baseURI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;;

public class SoapAPI {
	@Test
	void validateXML() throws IOException {
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
		statusCode(200).log().all();
		
	}
	

}
