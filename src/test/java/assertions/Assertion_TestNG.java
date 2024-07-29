package assertions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;



public class Assertion_TestNG {
	
	
	/*** Logging ***/
	@Test
	void testPostUsingJsonFile() throws FileNotFoundException {

		File file = new File(".\\src\\test\\resources\\testData.json");
		FileReader fileReader = new FileReader(file);

		JSONTokener jsonTokener = new JSONTokener(fileReader);


		JSONObject jsonObject = new JSONObject(jsonTokener);
		

		String email = given()
			.contentType("application/json")
			//.log()
			//.body()
			//.ifValidationFails()
			.body(jsonObject.toString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.extract()
			.path("email");
		
		System.out.println("*** EMAIL ID *** = "+email);
		assertEquals(email, "lvk2@gmail.com");
		
	}
	
	@Test
	void testAssert() throws FileNotFoundException {

		File file = new File(".\\src\\test\\resources\\testData.json");
		FileReader fileReader = new FileReader(file);

		JSONTokener jsonTokener = new JSONTokener(fileReader);


		JSONObject jsonObject = new JSONObject(jsonTokener);
		

		given()
			.contentType("application/json")
			//.log()
			//.body()
			//.ifValidationFails()
			.body(jsonObject.toString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			
		.log()
		.all();
		
	}



}
