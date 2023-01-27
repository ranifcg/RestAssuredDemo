package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ResponseBodyValidation {
  @Test
  public void bodyPrint() {
	  RestAssured.baseURI="https://gorest.co.in/public/v2/users/";
	  RequestSpecification httpRequest =  RestAssured.given().relaxedHTTPSValidation();
	  Response response = httpRequest.get("/users");
	  ResponseBody respbody = response.getBody();
	  System.out.println(respbody);
	  System.out.println(respbody.asString());

  }
  
}
