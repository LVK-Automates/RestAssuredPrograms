package authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicAuthentication {
	
	
	
	@Test
	void formLogin() {
		
		Response response = RestAssured
			.given()
				.auth()
				.basic("postman", "password")
				.when()
				.get("https://postman-echo.com/basic-auth");
		
		System.out.println(response.asPrettyString());
		
	}
	
	@Test
	void formLoginPreemptive() {
		
		int response = RestAssured
			.given()
				.auth()
				.preemptive()
				.basic("postman", "password")
				.when()
				.get("https://postman-echo.com/basic-auth")
				.getStatusCode();
		
		System.out.println(response);
		
	}
	
	@Test
	void formLoginDigest() {
		
		int response = RestAssured
			.given()
				.auth()
				.digest("postman", "password")
				.when()
				.get("https://postman-echo.com/basic-auth")
				.getStatusCode();
		
		System.out.println(response);
		
	}


	

}
