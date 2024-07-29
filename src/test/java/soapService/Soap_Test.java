package soapService;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Soap_Test {
	

	
	
	@Test
	void soapPostUsingFileObj() {
		File payload = new File("src/test/resources/numberconversion.xml");
		Response response = RestAssured.given()
			.contentType("text/xml")
			.body(payload)
			.post("https://www.dataaccess.com/webservicesserver/NumberConversion.wso");
		
		System.out.println(response.asPrettyString());
	}
	
	
	@Test
	void soapPost() {
		String url = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";
		String payload = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <ubiNum>500</ubiNum>\r\n"
				+ "    </NumberToWords>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		Response response = RestAssured.given()
			.contentType("text/xml")
			.body(payload)
			.post(url);
		
		System.out.println(response.asPrettyString());
	}
	
	@Test
	void soapNumberToDollars() {
		String url = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";
		String payload = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToDollars xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <dNum>500</dNum>\r\n"
				+ "    </NumberToDollars>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";
		 RestAssured.given()
			.contentType("text/xml")
			.body(payload)
			.post(url)
			.then()
			.log()
			.all();
		
	//	System.out.println(response.asPrettyString());
		
	}
	
	@Test
	void soapListCountries() {
		String url = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
		String payload = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap12:Envelope xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
				+ "  <soap12:Body>\r\n"
				+ "    <ListOfContinentsByName xmlns=\"http://www.oorsprong.org/websamples.countryinfo\">\r\n"
				+ "    </ListOfContinentsByName>\r\n"
				+ "  </soap12:Body>\r\n"
				+ "</soap12:Envelope>";
		Response response = RestAssured.given()
			.contentType("text/xml")
			.body(payload)
			.post(url);
		
		System.out.println(response.asPrettyString());
		
	}


}
