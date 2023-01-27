package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestfulBooke_Delete {

	
public static void main (String[] args) {
		 //RestAssured.baseURI="https://gorest.co.in/public/v2/users/";
		  RequestSpecification httpRequest =  RestAssured.given().relaxedHTTPSValidation();
		  httpRequest.cookie("token", "b84030dd5fce331");
		  httpRequest.baseUri("https://restful-booker.herokuapp.com/booking/10");
		  Response response = httpRequest.delete();
		  System.out.println(response.asString());
	}
}
