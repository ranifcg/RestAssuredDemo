package test;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestfulBookDemo_POST {
	public static void main(String[] args) {
//Get base URI
		/*
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/auth";
		RequestSpecification newReq =  RestAssured.given().relaxedHTTPSValidation();
		Response resp = newReq.request(Method.GET,"");
		System.out.println(resp.getStatusLine());
		System.out.println(resp.prettyPrint());
		*/
		
		String json_string = "{\"username\": \"admin\", \"password\": \"password123\"}";
		RequestSpecification newReq =  RestAssured.given().relaxedHTTPSValidation();
		newReq.contentType(ContentType.JSON);
		newReq.baseUri("https://restful-booker.herokuapp.com/auth");
		newReq.body(json_string);
		Response resp = newReq.post();
		System.out.println(resp.asString());
		ValidatableResponse vresp = resp.then();
		vresp.statusCode(200); //validate response code
		vresp.body("token", Matchers.notNullValue());
		vresp.body("token", Matchers.matchesRegex("^[a-z0-9]+$")); //validate token is alphanumeric


	}

}
