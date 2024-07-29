package studentsApp;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	
	@BeforeMethod
	public static void init() {
		
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";
		
	}
}
