package restassuredprograms;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.*;


public class TypesOfPOSTINGReqBody {
	
	
	@Test
	void testPostUsingJsonLib() {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("email", "lvk@gmail.com");
		jsonObject.put("first_name", "Kirthi");
		jsonObject.put("last_name", "Vasan");
		
		given()
			.contentType(ContentType.JSON)
			.body(jsonObject.toString())
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all();
		
	}
	
	
	/*** Logging ***/
	@Test
	void testPostUsingJsonFile() throws FileNotFoundException {

		File file = new File(".\\src\\test\\resources\\testData.json");
		FileReader fileReader = new FileReader(file);

		JSONTokener jsonTokener = new JSONTokener(fileReader);

		System.out.println("*** JSON TOKENER ***"+jsonTokener);

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
			.statusCode(201)
			.log().all();
		
	}

	@Test
	void testQueryAndPathParameters(){

			given()
					.pathParam("myPath","users")
					.queryParam("page","2")
					.queryParam("id","7")

					.when()
					.get("https://reqres.in/api/{myPath}")
					.then()
					.statusCode(200)
					.log().all();

	}
	
	

}
