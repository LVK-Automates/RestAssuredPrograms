package fileDownloadsAndUploads;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class File_Upload {
	
	
	
	
	@Test
	void testUpload() {
		
		
		File file = new File("src/test/resources/testupload.txt");
		
		int response = RestAssured
							.given()
								.multiPart("file", file)
								.post("https://the-internet.herokuapp.com/upload")
								.thenReturn()
								.statusCode();
								;
		
		System.out.println(response);
								
	}
	
	@Test
	void testUpload2() {
		
		
		File file = new File("src/test/resources/testupload.txt");
		
		RestAssured
							.given()
								.multiPart("file", file)
								.post("https://the-internet.herokuapp.com/upload")
								.then()
								.log()
								.all();
	}


}
