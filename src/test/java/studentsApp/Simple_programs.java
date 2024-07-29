package studentsApp;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class Simple_programs extends TestBase{
	
	
	
	//Example for BeforeMethod in Base class using RestAssured.baseURI
	@Test
	void getAllStudents() {
		given()
			.when()
			.get("/list")
			.then()
			.statusCode(200)
			.log()
			.all();
		
	}
	
	@Test
	void getSingleCSStudent() {
		
		
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("programme", "Computer Science");
		mapObj.put("limit", 1);
		 given()
			.when()
			//***approach#1
			.queryParam("programme", "Computer Science")
			.queryParam("limit", 2);
			
			//***approach#2
			
		//	.queryParams("programme", "Computer Science", "limit", 1)
		//	.get("/list");
			
			//***approach#3
			
		//	.queryParams(mapObj)
		//	.get("/list");
			
			
	//	response.prettyPrint();
		
		
	}
	
	@Test
	void pathParameterTest() {
		
		//Approach #1
		Response response = given()
							.when()
							.get("http://localhost:8085/student/2");
		response.prettyPrint();
		
		
		//Approach #2
/*		Response response = given()
				.pathParam("id", 2)
				.when()
				.get("http://localhost:8080/student/{id}");
		
		response.prettyPrint();
		*/
		
	}

	@Test
	void logInfo() {
		
		//Approach #1
		/*Response response = given()
							.when()
							.get("http://localhost:8080/student/2");
		response.prettyPrint();
		*/
		
		//Approach #2
		Response response = given()
				.log()
				//.headers()
				//.params()
				.body()
				.pathParam("id", 2)
				.when()
				.get("http://localhost:8080/student/{id}");

		response.prettyPrint();
		
		
	}

	
	

}
