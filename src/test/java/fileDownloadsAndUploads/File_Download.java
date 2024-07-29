package fileDownloadsAndUploads;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class File_Download {
	
	
	
	@Test
	 void fileDownloadAndValidate() throws IOException {
		
		Response response = given()
			.when()
				.get("https://reqres.in/api/users").andReturn();
			
		byte [] bytes = response.getBody().asByteArray();
		File file = new File("src/test/resources/download.json");
		Files.write(file.toPath(), bytes);
		

		
		
	}
	
	
	

}
