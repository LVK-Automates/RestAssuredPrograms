package authentication;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

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
	public void createAPayment() {

		String payload = "{\r\n"
				+ "  \"intent\": \"sale\",\r\n"
				+ "  \"payer\": {\r\n"
				+ "    \"payment_method\": \"paypal\"\r\n"
				+ "  },\r\n"
				+ "  \"transactions\": [\r\n"
				+ "    {\r\n"
				+ "      \"amount\": {\r\n"
				+ "        \"total\": \"30.11\",\r\n"
				+ "        \"currency\": \"USD\",\r\n"
				+ "        \"details\": {\r\n"
				+ "          \"subtotal\": \"30.00\",\r\n"
				+ "          \"tax\": \"0.07\",\r\n"
				+ "          \"shipping\": \"0.03\",\r\n"
				+ "          \"handling_fee\": \"1.00\",\r\n"
				+ "          \"shipping_discount\": \"-1.00\",\r\n"
				+ "          \"insurance\": \"0.01\"\r\n"
				+ "        }\r\n"
				+ "      },\r\n"
				+ "      \"description\": \"The payment transaction description.\",\r\n"
				+ "      \"custom\": \"EBAY_EMS_90048630024435\",\r\n"
				+ "      \"invoice_number\": \"48787589673\",\r\n"
				+ "      \"payment_options\": {\r\n"
				+ "        \"allowed_payment_method\": \"INSTANT_FUNDING_SOURCE\"\r\n"
				+ "      },\r\n"
				+ "      \"soft_descriptor\": \"ECHI5786786\",\r\n"
				+ "      \"item_list\": {\r\n"
				+ "        \"items\": [\r\n"
				+ "          {\r\n"
				+ "            \"name\": \"hat\",\r\n"
				+ "            \"description\": \"Brown hat.\",\r\n"
				+ "            \"quantity\": \"5\",\r\n"
				+ "            \"price\": \"3\",\r\n"
				+ "            \"tax\": \"0.01\",\r\n"
				+ "            \"sku\": \"1\",\r\n"
				+ "            \"currency\": \"USD\"\r\n"
				+ "          },\r\n"
				+ "          {\r\n"
				+ "            \"name\": \"handbag\",\r\n"
				+ "            \"description\": \"Black handbag.\",\r\n"
				+ "            \"quantity\": \"1\",\r\n"
				+ "            \"price\": \"15\",\r\n"
				+ "            \"tax\": \"0.02\",\r\n"
				+ "            \"sku\": \"product34\",\r\n"
				+ "            \"currency\": \"USD\"\r\n"
				+ "          }\r\n"
				+ "        ],\r\n"
				+ "        \"shipping_address\": {\r\n"
				+ "          \"recipient_name\": \"Brian Robinson\",\r\n"
				+ "          \"line1\": \"4th Floor\",\r\n"
				+ "          \"line2\": \"Unit #34\",\r\n"
				+ "          \"city\": \"San Jose\",\r\n"
				+ "          \"country_code\": \"US\",\r\n"
				+ "          \"postal_code\": \"95131\",\r\n"
				+ "          \"phone\": \"011862212345678\",\r\n"
				+ "          \"state\": \"CA\"\r\n"
				+ "        }\r\n"
				+ "      }\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"note_to_payer\": \"Contact us for any questions on your order.\",\r\n"
				+ "  \"redirect_urls\": {\r\n"
				+ "    \"return_url\": \"https://example.com/return\",\r\n"
				+ "    \"cancel_url\": \"https://example.com/cancel\"\r\n"
				+ "  }\r\n"
				+ "}";
		String paymentId =	given()
				.contentType(ContentType.JSON)
				.auth()
				.oauth2(accessToken)
				.when()
				.body(payload)
				.post("https://api-m.sandbox.paypal.com/v1/payments/payment")
				.then()
				.log()
				.all()
				.extract()
				.path("id");

		getPaymentDetails(accessToken, paymentId);


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
		.log()
		.all();
	}

}
