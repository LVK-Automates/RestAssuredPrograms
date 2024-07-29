package jacksonPractices;

import java.io.FileWriter;
import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseToJSONFile {

	public static void main(String[] args) {

		
		Response response = RestAssured.when()
		.get("https://reqres.in/api/users?page=2");
		
	      // create instance of the FileWriter class by passing the path of the file in the constructor  
        try (FileWriter file = new FileWriter("src/test/resources/response.json")) {  
              
            // use write() method to add JSONObject into file   
            file.write(response.asString());  
            file.flush();  
  
        }  
        catch (IOException e) {  
            e.printStackTrace();  
        }  

        
		

		
	}

}
