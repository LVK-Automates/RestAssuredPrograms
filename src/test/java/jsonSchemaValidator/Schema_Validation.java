package jsonSchemaValidator;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class Schema_Validation {
	
	
	@Test
	void schemaValidation() {
		
		File file = new File("src/test/resources/schema.json");
		RestAssured
			.given()	
			.get("https://reqres.in/api/users?page=2")
			.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"))
			//.assertThat().body(JsonSchemaValidator.matchesJsonSchema(file))
			.statusCode(200);
		
	}

}
