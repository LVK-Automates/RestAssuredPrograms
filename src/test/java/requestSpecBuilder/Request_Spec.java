package requestSpecBuilder;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class Request_Spec {
	
	RequestSpecBuilder builder;
	RequestSpecification requestSpec;
	
	
	ResponseSpecBuilder responseSpecBuilder;
	ResponseSpecification responseSpecification;
	
	@BeforeMethod
	void buildRequestSpec() {
		
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8085;
		RestAssured.basePath = "/student";

		builder = new RequestSpecBuilder();
		responseSpecBuilder = new ResponseSpecBuilder();
		builder.addQueryParam("programme", "Computer Science");
		builder.addQueryParam("limit", 2);
		requestSpec = builder.build();
		
		responseSpecBuilder.expectStatusCode(200);
		responseSpecBuilder.expectBody("[0].id", equalTo(3));
		
		responseSpecification = responseSpecBuilder.build();
		
		
		
	}
	
	
	@Test
	void testRequestSpec() {
		
		
		given()
				.when()
				.spec(requestSpec)
				.get("/list")
				.then()
				.spec(responseSpecification)
				.log()
				.all();
				

	}

}
