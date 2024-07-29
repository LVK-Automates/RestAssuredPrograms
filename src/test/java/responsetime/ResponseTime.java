package responsetime;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class ResponseTime {
	
	
	@Test
	void getTime() {
		
		Response response = RestAssured.when()
				.get("https://reqres.in/api/users?page=2");
		when()
		.get("https://reqres.in/api/users?page=2").
		then()
		.time(lessThan(1000L), TimeUnit.MILLISECONDS);
		
		
		
		
		long responseTime = response.getTime();
		
		System.out.println("*** RESPONSE TIME USING GET TIME ()"+responseTime);
		
		long responseTimeInMillis = response.getTimeIn(TimeUnit.MILLISECONDS);
		
		long responseTimeUsingTime = response.time();
		System.out.println("*** RESPONSE TIME ***"+responseTimeInMillis);
		
		System.out.println("*** RESPONSE TIME USING TIME()***"+responseTimeUsingTime);


	}

}
