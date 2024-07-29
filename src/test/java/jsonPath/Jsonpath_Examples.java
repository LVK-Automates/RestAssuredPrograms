package jsonPath;

import static org.hamcrest.Matchers.hasItem;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Jsonpath_Examples {
	
	
	@Test
	void jsonPath1() {

		LinkedHashMap<String, String> value = RestAssured
			.when()
			.get("https://api.restful-api.dev/objects")
			.then()
			.extract()
			.path("[4].data");
			
		float pricevalue = RestAssured
				.when()
				.get("https://api.restful-api.dev/objects")
				.then()
				.extract()
				.path("[4].data.price");

		System.out.println("*** USING JSON PATH ***:"+value);
		System.out.println("*** USING JSON PATH ***:"+pricevalue);
		
		
	}
	
	@Test
	void jsonPath2() throws FileNotFoundException {

		int page = RestAssured
			.when()
			.get("https://reqres.in/api/users")
			.then()
			.extract()
			.path("page");
			
		
		System.out.println("*** USING JSON PATH ***:"+page);
		
		
	}
	
	
	@Test
	void jsonPath3() throws FileNotFoundException {

		String email = RestAssured
			.when()
			.get("https://reqres.in/api/users")
			.then()
			.extract()
			.path("data[1].email");
			
		
		System.out.println("*** USING JSON PATH ***:"+email);

	
		
	}
	
	
	@Test
	void jsonPath4() throws FileNotFoundException {

		int size = RestAssured
			.when()
			.get("https://reqres.in/api/users")
			.then()
			.extract()
			.path("data.size()");
			
		
		System.out.println("*** USING JSON PATH ***:"+size);

	
		
	}
	
	
	@Test
	void jsonPath5() {

		List<String> firstNames = RestAssured
			.when()
			.get("https://reqres.in/api/users")
			.then()
			.extract()
			.path("data.first_name");
			
		
		System.out.println("*** USING JSON PATH ***:"+firstNames);

		for(int i=0;i<firstNames.size(); i++) {
			
			System.out.println(firstNames.get(i));
		}
	
		
	}
	

	@Test
	void jsonPath6() throws FileNotFoundException {

	List<HashMap<String, Object>> values =	RestAssured
			.when()
			.get("https://reqres.in/api/users")
			.then()
			.extract()
			.path("data.findAll{it.email == 'emma.wong@reqres.in'}");
			
		
		System.out.println("*** USING JSON PATH ***:"+values);
		
	/*	for(int i = 0; i<values.size(); i++) {
			
			
			System.out.println(values.get(i));
			
			
			
		}
		
		*/

		for(Map<String, Object> mapObj : values) {
			
			for(String key : mapObj.keySet()) {
				
				
				System.out.println("Key:"+key);
				Object val = mapObj.get(key);
				System.out.println("Value:"+val);
				
			}
		}
		
	}







	
}
