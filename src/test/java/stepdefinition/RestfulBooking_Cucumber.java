package stepdefinition;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestfulBooking_Cucumber 
{

String respToken;
Response respCreate;
int createStatusCode;

Response respUpdate;
int updateStatusCode;

Response respDelete;
int deleteStatusCode;

@Given("I am an authorized user")
public void i_am_an_authorized_user() {
String jsonString = "{\"username\": \"admin\",\"password\": \"password123\"}";
	
	RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
	newReq.contentType(ContentType.JSON);
	newReq.baseUri("https://restful-booker.herokuapp.com/auth");
	newReq.body(jsonString);
	Response resp = newReq.post();
	
	//Variable to store the response token
	respToken = resp.getBody().jsonPath().getString("token");	
	System.out.println("Resp token " +respToken);
}



@Given("List of bookings are available")
public void list_of_bookings_are_available() {
	RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
    
    RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
    Response resp = newReq.request(Method.GET,"");
    
    System.out.println(resp.getStatusLine());
    System.out.println(resp.prettyPrint());
}

@When("I create a booking")
public void i_create_a_booking() {
	RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking";
	  
	  String jsonStr = "{\n"
		  		+ "    \"firstname\" : \"Rani\",\n"
		  		+ "    \"lastname\" : \"Nair\",\n"
		  		+ "    \"totalprice\" : 1111,\n"
		  		+ "    \"depositpaid\" : true,\n"
		  		+ "    \"bookingdates\" : {\n"
		  		+ "        \"checkin\" : \"2023-03-01\",\n"
		  		+ "        \"checkout\" : \"2023-03-05\"\n"
		  		+ "    },\n"
		  		+ "    \"additionalneeds\" : \"Breakfast\"\n"
		  		+ "}";
	  
	  
	  RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
	  newReq.body(jsonStr);
	  newReq.cookie("token",respToken);
	  newReq.contentType(ContentType.JSON);
	  
	  respCreate = newReq.post();
	  createStatusCode = respCreate.getStatusCode();
	  
	  
	  System.out.println(respCreate.getStatusCode());
	  System.out.println(respCreate.getStatusLine());
	  System.out.println(respCreate.prettyPrint());
}

@Then("Booking is added")
public void booking_is_added() {
    //Assert that the booking is added (from the status code)
	System.out.println("Create code: "+ createStatusCode);
	assertEquals(200, createStatusCode);
}

@When("I update a booking")
public void i_update_a_booking() {
	RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/10";
	  
	  String jsonStr = "{\n"
		  		+ "    \"firstname\" : \"Rani\",\n"
		  		+ "    \"lastname\" : \"Nair\",\n"
		  		+ "    \"totalprice\" : 2222,\n"
		  		+ "    \"depositpaid\" : true,\n"
		  		+ "    \"bookingdates\" : {\n"
		  		+ "        \"checkin\" : \"2023-04-03\",\n"
		  		+ "        \"checkout\" : \"2023-04-05\"\n"
		  		+ "    },\n"
		  		+ "    \"additionalneeds\" : \"Lunch\"\n"
		  		+ "}";
	  
	  
	  RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
	  newReq.contentType(ContentType.JSON);
	  newReq.cookie("token",respToken);
	  newReq.body(jsonStr);

    
	  respUpdate = newReq.put();
	  updateStatusCode = respUpdate.getStatusCode();
	  System.out.println("Update Status Code: "+ updateStatusCode);
	  System.out.println(respUpdate.getStatusCode());
	  System.out.println(respUpdate.getStatusLine());
	  System.out.println(respUpdate.prettyPrint());
}

@Then("Booking is updated")
public void booking_is_updated() {
	//Status code for update is compared
	assertEquals(200,updateStatusCode);

}

@When("I delete a booking")
public void i_delete_a_booking() {
	//DELETE Method
    RequestSpecification newReq = RestAssured.given().relaxedHTTPSValidation();
    newReq.cookie("token",respToken);
    
    newReq.baseUri("https://restful-booker.herokuapp.com/booking/15");
    
    respDelete = newReq.delete();
	deleteStatusCode = respDelete.getStatusCode();
	System.out.println("Delete Status Code: "+ deleteStatusCode);

    System.out.println(respDelete.getStatusCode());

}

@Then("Booking is deleted")
public void booking_is_deleted() {
	//Compare delete request status code
	System.out.println("Delete Code: " + deleteStatusCode);
	assertEquals(201,deleteStatusCode);

}
}
