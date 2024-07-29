package authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;

public class FormAuthentication {
	
	
	
	
	@Test
	void getAllStudents() {
		
		SessionFilter filter = new SessionFilter();
		
		RestAssured
			.given()
				.auth()
				.form("user", "user", new FormAuthConfig("/login", "uname", "pwd"))
				.filter(filter)
				.get("http://localhost:8085/student/list")
				.then()
				.log()
				.all();
	}

}
