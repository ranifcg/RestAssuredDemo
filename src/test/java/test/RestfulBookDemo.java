package test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestfulBookDemo {
	public static void main(String[] args) {
//Get base URI
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
		RequestSpecification newReq =  RestAssured.given().relaxedHTTPSValidation();;
		Response resp = newReq.request(Method.GET,"");
		System.out.println(resp.getStatusLine());
		System.out.println(resp.prettyPrint());
		

	}

}
