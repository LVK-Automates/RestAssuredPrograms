package studentsApp;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import javax.swing.text.AbstractDocument;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class CreateNewStudentUsingStringPayload {


    @Test
    void createNewStudent(){
    String payload = "{\r\n"
    		+ "    \"id\": 2,\r\n"
    		+ "    \"firstName\": \"Anand\",\r\n"
    		+ "    \"lastName\": \"Holmes\",\r\n"
    		+ "    \"email\": \"faucibus.orci.luctus@Duisac.net\",\r\n"
    		+ "    \"programme\": \"Financial Analysis\",\r\n"
    		+ "    \"courses\": [\r\n"
    		+ "        \"Accounting\",\r\n"
    		+ "        \"Statistics\"\r\n"
    		+ "    ]\r\n"
    		+ "}";
        given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post("http://localhost:8085/student")
                .then()
                .statusCode(201);
                

    }
}
