package paypalPractices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.recording.SnapshotRecordResult;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PayapalWiremock {

	int port;
	static String accessToken;
	
	public static final String clientID = "AZzzwbjFHC8JLtQibtO2n1tslH0xi4Z2Gog5zh27gveDJSlhAUiVAF1IoDiRpU0aPYp7CvKDqiAoNB_i";
	public static final String clientSecret = "EDsjq2LBtfZNXU1ggWOFGixqkSwlxmCPJNJuGXEDsM_6CYOhP1MVEs-DOpDJb7QMvPeSDIuOnH9Dywvs"; 

	
	@Test
	public void testRecorder() throws InterruptedException, FileNotFoundException {

		// Client instance
		WireMockServer wireMockServer = new WireMockServer(Options.DYNAMIC_PORT);
		wireMockServer.start();
		wireMockServer.startRecording("https://api-m.sandbox.paypal.com");
		port = wireMockServer.port();
		System.out.println(port);
		String bearerToken = getTokenFromPaypal();
		System.out.println("Bearer Token is: "+bearerToken);
		createOrder(bearerToken);
		SnapshotRecordResult recordedMappings = wireMockServer.stopRecording();

		List<StubMapping> mappings = recordedMappings.getStubMappings();
		System.out.println("Mappings of the API:"+mappings);


	}

	public String getTokenFromPaypal() {
		RestAssured.baseURI = "http://localhost:"+port;
		accessToken = RestAssured.given()
				.params("grant_type", "client_credentials")
				.auth()
				.preemptive()
				.basic(clientID, clientSecret)
				.post("/v1/oauth2/token")
				.then()
				.log()
				.all()
				.extract()
				.path("access_token");
		System.out.println("ACCESS TOKEN: "+accessToken);
		return accessToken;


	}

	public void createOrder(String bearerToken) throws FileNotFoundException {

		RestAssured.baseURI = "http://localhost:"+port;
		
		File file = new File(".\\src\\test\\resources\\payments_payload.json");
		FileReader fileReader = new FileReader(file);
		JSONTokener jsonTokener = new JSONTokener(fileReader);
		System.out.println("*** JSON TOKENER ***"+jsonTokener);
		JSONObject jsonObject = new JSONObject(jsonTokener);
		RestAssured.given()
				.contentType(ContentType.JSON)
				.auth()
				.oauth2(accessToken)
				.when()
				.body(jsonObject.toString())
				.post("/v1/payments/payment")
				.then()
				.log()
				.all();
				
	}
	




}
