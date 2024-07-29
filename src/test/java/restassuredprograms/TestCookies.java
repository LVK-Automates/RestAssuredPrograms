package restassuredprograms;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class TestCookies {

    @Test
    void testCookies(){
    	
    	
        when()
                .get("https://www.google.com")
        .then()
                .cookie("AEC","Ae3NU9OmoK2vJXEg5xozlWEwsvQ3AidM4nekud4JZwxsZVbNl4TZ96YE1g")
                .log().all();
    }

    @Test
    void getCookiesInfo(){

        Response res = 
        		given()
                .when()
                .get("https://www.google.com");
        res.prettyPrint();
        String cookie_value = res.getCookie("AEC");
        System.out.println("Cookie Value: "+cookie_value);


    }

    @Test
    void getAllCookiesInfo(){
        Response res = given()
                        .when()
                            .get("https://www.google.com");
        Map<String, String> hashMap =  res.getCookies();
        System.out.println(hashMap.keySet());
        for(String key : hashMap.keySet()){
            String cookieValue = res.getCookie(key);
            System.out.println(cookieValue);
        }

    }
    @Test
    void getHeadersInfo(){


        Response response =   given()
                .when()
                .get("https://reqres.in/api/users?page=2");
        String headerValue = response.getHeader("Content-Type");
        System.out.println(headerValue);

        Headers headers = response.getHeaders();
        for(Header header : headers){

            System.out.println(header.getName() +":" + header.getValue());
        }




    }


}
