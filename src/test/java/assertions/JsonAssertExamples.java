package assertions;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;


public class JsonAssertExamples {
	
	
	@Test
	void testJsonAssert() throws IOException {
		
	String expectedValue = new String(Files.readAllBytes(Paths.get("src/test/resources/studentsList.json")));
	
	System.out.println(expectedValue);
		String actualValue = RestAssured
			.given().
				when().
					get("http://localhost:8085/student/list")
					.asString();
		System.out.println(actualValue);
		
		JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.LENIENT);
				
	}
	
	
	



}
