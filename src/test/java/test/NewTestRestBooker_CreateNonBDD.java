package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NewTestRestBooker_CreateNonBDD {
  @Test
  public void createBooking() {
	  
	  RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
	  String json_string = "{\n"
		  		+ "    \"firstname\" : \"Jim\",\n"
		  		+ "    \"lastname\" : \"Brown\",\n"
		  		+ "    \"totalprice\" : 111,\n"
		  		+ "    \"depositpaid\" : true,\n"
		  		+ "    \"bookingdates\" : {\n"
		  		+ "        \"checkin\" : \"2023-02-05\",\n"
		  		+ "        \"checkout\" : \"2019-02-07\"\n"
		  		+ "    },\n"
		  		+ "    \"additionalneeds\" : \"Breakfast\"\n"
		  		+ "}";

	  RequestSpecification newReq =  RestAssured.given().relaxedHTTPSValidation();;
		newReq.body(json_string);
		newReq.cookie("token", "fee12d1a820d6f0");
		newReq.contentType(ContentType.JSON);
	  Response resp = newReq.post();
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.prettyPrint());
		
		  
  }
}
