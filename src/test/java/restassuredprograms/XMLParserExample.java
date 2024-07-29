package restassuredprograms;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class XMLParserExample {


    @Test
    void testXMLResponse(){
        given()
                .when()
                    .get("");

    }
}
