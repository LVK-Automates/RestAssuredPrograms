package twitterProgram;


import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.restassured.RestAssured;

public class TwitterTest {
	
	String consumerKey = "anB6dHRTY3dlTjZTZnNKSFU2M2g6MTpjaQ";
		
	String consumerSecret = "iKzl0q4yFlvjJUenPwS5RQnzmXzqwD_QH4Sn3aPNKKUPgUdb0q";
	String  secretToken = "1766503160456343552-ltRkICajs98XTV3tdNQqaKPJWoQ9Hz";
	String accessTokenSecret = "n9PQqta6CtA86tRxYUY349sNEuPcn3NrPIpuB6rjCaNro";
	
	@BeforeMethod
	public static void init(){
		RestAssured.baseURI="https://api.twitter.com";
		RestAssured.basePath="/1.1/statuses";
	}

	
	@Test
	public void createTweet(){
		given()
		.auth()
		.oauth(consumerKey, consumerSecret, accessTokenSecret, secretToken)
		.queryParam("status","This is my first tweet from Rest Assured")
		.log()
		.all()
		.when()
		.post("https://api.twitter.com/oauth/authorize?oauth_token="+accessTokenSecret)
		.then()
		.log()
		.all();
	}
	@Test
	public void getTweets(){
		given()
		.auth()
		.oauth(consumerKey, consumerSecret, accessTokenSecret, secretToken)
		.queryParam("screen_name","lvktechstuff")
		.log()
		.all()
		.when()
		.get("/user_timeline.json")
		.then()
		.log()
		.all();
	}

}
