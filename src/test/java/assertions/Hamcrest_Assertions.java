package assertions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;



public class Hamcrest_Assertions {
	
	
	
	@Test
	void validateUsingHamcrest1() throws FileNotFoundException {

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
			.body("email", equalTo("lvk3@gmail.com"));
		//.body("email", equalToIgnoringCase("LVK2@gmail.com"));
		
		
	}
	
	@Test
	void validateUsingHamcrest2() throws FileNotFoundException {

			RestAssured
			.when()
			.get("https://api.restful-api.dev/objects")
			.then()
			//.body("name", hasItem("Apple iPad Mini 5th Gen"))
			.body("id", hasItem("6"))
			.log()
			.all();
		
		
	}
	
	@Test
	void validateUsingHamcrest3() throws FileNotFoundException {

			RestAssured
			.when()
			.get("https://api.restful-api.dev/objects")
			.then()
			.body("name", hasItems("Apple iPad Mini 5th Gen","Apple iPad Air","Beats Studio3 Wireless"))
			.log()
			.all();
		
		
	}
	
	
	@Test
	void validateUsingHamcrest4(){

			RestAssured
			.when()
			.get("https://api.restful-api.dev/objects")
			.then()
			.body("name.size()", lessThan(15))
			.log()
			.all();
		
		
	}
	


	@Test
	void softAssert(){

			RestAssured
			.when()
			.get("https://api.restful-api.dev/objects")
			.then()
			.body("[0].name", equalTo("Google Pixel 6 Pro"),
				  "[1].name", equalTo("Apple iPhone 12 Mini, 256GB, Blue"),
				  "[2].name", equalTo("Apple iPhone 12 Pro Max")
				  )
					
			.log()
			.all();
		
		
	}







}
