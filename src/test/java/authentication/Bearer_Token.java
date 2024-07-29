package authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Bearer_Token {
	
	
	
	@Test
	void bearerToken() {
		
		String bearerToken = "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";
		
		RestAssured
		.given()
			.headers("Authorization","Bearer "+bearerToken)
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
		.log()
		.all();
		
	}

}
