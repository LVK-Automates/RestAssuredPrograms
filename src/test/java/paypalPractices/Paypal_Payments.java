package paypalPractices;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Paypal_Payments {
	
	
	static String accessToken;
	
	public static final String clientID = "AZzzwbjFHC8JLtQibtO2n1tslH0xi4Z2Gog5zh27gveDJSlhAUiVAF1IoDiRpU0aPYp7CvKDqiAoNB_i";
	public static final String clientSecret = "EDsjq2LBtfZNXU1ggWOFGixqkSwlxmCPJNJuGXEDsM_6CYOhP1MVEs-DOpDJb7QMvPeSDIuOnH9Dywvs"; 
	
	@BeforeMethod
	public void getToken() {
		accessToken = 	given()
		.params("grant_type","client_credentials")
		.auth()
		.preemptive()
		.basic(clientID, clientSecret)
		.when()
		.post("https://api-m.sandbox.paypal.com/v1/oauth2/token")
		.then()
		.log()
		.all()
		.extract()
		.path("access_token");
		System.out.println("Access Token is: "+accessToken);
				
	}
	
	
	@Test
	public void createAPaymentUsingJsonFile() throws FileNotFoundException {
		File file = new File(".\\src\\test\\resources\\payments_payload.json");
		FileReader fileReader = new FileReader(file);
		JSONTokener jsonTokener = new JSONTokener(fileReader);
		System.out.println("*** JSON TOKENER ***"+jsonTokener);
		JSONObject jsonObject = new JSONObject(jsonTokener);

		String paymentId =	given()
				.contentType(ContentType.JSON)
				.auth()
				.oauth2(accessToken)
				.when()
				.body(jsonObject.toString())
				.post("https://api-m.sandbox.paypal.com/v1/payments/payment")
				.then()
				.log()
				.all()
				.extract()
				.path("id");
		getPaymentDetails(accessToken, paymentId);
	}

	
	public void getPaymentDetails(String accessToken, String paymentId) {
		
		System.out.println("*** PAYMENT DETAILS IN RESPONSE ***");
		given()
		.auth()
		.oauth2(accessToken)
		.get("https://api-m.sandbox.paypal.com/v1/payments/payment/"+paymentId)
		.then()
		//.body("transactions[0].item_list.items[0]",hasKey("name"))
		.log()
		.all();
	}

}
