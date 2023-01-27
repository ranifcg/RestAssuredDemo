package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HeaderValidationDemo {
  @Test
  public void headerPrint() {
	  RestAssured.baseURI="https://gorest.co.in/public/v2/users/";
	  RequestSpecification httpRequest =  RestAssured.given().relaxedHTTPSValidation();
	  Response response = httpRequest.get("");
	  String contentype = response.header("Content-Type");
	  String conn = response.header("Connection");
	  System.out.println(conn);
/*	  Headers headers = response.getHeaders();

	  for(Header header: headers) 
	  {
		  System.out.println("key: "+ header.getName()+ " value: "+ header.getValue());
	  }
	  
*/
	  
  }
}
