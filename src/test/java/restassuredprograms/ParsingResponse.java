package restassuredprograms;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;


@Test
public class ParsingResponse {


    @Test
    void testParsing(){
    	Response res =  given()
    			.contentType(ContentType.JSON)
    			.when()
    			.get("http://localhost:8085/student/list");

    	System.out.println(res.asPrettyString());
    	JSONObject jsonObject = new JSONObject(res);

    	for (int i = 0; i<jsonObject.getJSONArray("["+i+"]").length(); i++){
    		String lastName = jsonObject.getJSONArray("["+i+"]").getJSONObject(i).get("firstName").toString();
    		System.out.println(lastName);

    	}

    }


}
