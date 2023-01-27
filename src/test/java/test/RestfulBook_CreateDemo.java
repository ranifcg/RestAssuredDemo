package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestfulBook_CreateDemo {
  @Test
  public void createBooking() {
	  
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
	  
	  RestAssured.given()
	  .relaxedHTTPSValidation()
	  .baseUri("https://restful-booker.herokuapp.com/booking")
	  .cookie("token","fee12d1a820d6f0")
	  .contentType(ContentType.JSON)
	  .body(json_string)
	  .when()
	  .post()
	  .then()
	  .assertThat()
	  .statusCode(200);
	  
  }
}
