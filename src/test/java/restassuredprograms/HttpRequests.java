package restassuredprograms;


import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;


public class HttpRequests {
	
	
	int id;
	
	
	@Test(priority = 0)
	public void getUser() {
		
		
		RestAssured.when()
			.get("https://reqres.in/api/users?page=2")
			.then()
			.statusCode(200)
			//.body("page",equalTo(2))
			.log().all();
			
		
		
		
		/***
		 * 
		 * Writing the response into a JSON file 
		 * 
		 */
		
	/*	Response response = RestAssured.when()
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
	*/
		
	}
	
	@Test(priority = 1)
	public void postUser() {
		
		HashMap<String, String> hmObj = new HashMap<String, String>();
		 
		hmObj.put("name", "LVKTechOne");
		hmObj.put("job", "Automation Architect");
		
		given()
			.contentType("application/json")
			.body(hmObj)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().all();
			
	}
	

	@Test(priority = 2)
	public void get_User_ID() {
		HashMap<String, String> hmObj = new HashMap<String, String>();
		hmObj.put("name", "LVKTechTwo");
		hmObj.put("job", "Automation Architect");
		
		 id = given()
			.contentType("application/json")
			//.body(hmObj)
		.when()
			.get("https://reqres.in/api/users")
			.jsonPath().getInt("id");
	System.out.println("*** ID ***"+id);
			
	}
	
	
	//@Test(priority = 3)
/*	void update_user() {
		
		HashMap<String, String> hmObj = new HashMap<String, String>();
		 
		hmObj.put("name", "LVK");
		hmObj.put("job", "Cricketer");
		
		given()
			.contentType("application/json")
			.body(hmObj)
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
	}
	*/
	
	@Test(priority = 3)
	void delete_user() {
		
		when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			
			.statusCode(204)
			
			.log().all();
	}
	


}
