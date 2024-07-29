package authentication;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;

public class CSRFTokenAuth {
	SessionFilter filter;
	
	@BeforeMethod
	void testCsrfToken() {

		filter = new SessionFilter();
		RestAssured.baseURI = "http://localhost:8085";
		RestAssured.
		given().
		csrf("/login").
		formParam("uname", "user").
		formParam("pwd", "user").
		filter(filter).
		get();

	}
	
	@Test
	void getStudentsList() {
		
	Response response = RestAssured
			.given()
			.sessionId(filter.getSessionId())
			.when()
			.get("http://localhost:8085/student/list");
		System.out.println(response.asPrettyString());
	}

}
