package authentication;


import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.restassured.RestAssured;

public class TwitterTest {
	
	String consumerKey = "anB6dHRTY3dlTjZTZnNKSFU2M2g6MTpjaQ";
	String consumerSecret = "DieNR_d8A_a08hHx9ISLJE8rsTtMYmlXE0lqkgWDu-3ZD5QEzd";
	String accessTokenSecret = "1766503160456343552-P4NQNk4VQa3TLkuguLiPBipRMRtc1r";
	String secretToken = "ob4fEbUejQGjleEfPTv6GPPB6mHYjXrlcmp9JJ8dvC4sT";
	
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
		.post("/update.json")
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
