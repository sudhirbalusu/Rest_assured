import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class weather_RA {
  @Test
  //(dataProvider = "dp")
  public void f() {
	// Specify the base URL to the RESTful web service
	  RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
	  
	  // Get the RequestSpecification of the request that you want to sent
	  // to the server. The server is specified by the BaseURI that we have
	  // specified in the above step.
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  // Make a request to the server by specifying the method Type and the method URL.
	  // This will return the Response from the server. Store the response in a variable.
	  Response response = httpRequest.request(Method.GET, "/Hyderabad");
	  
	  int respCode = response.getStatusCode();
	  
	  Assert.assertEquals(200, respCode, "Status code is incorrect "+ respCode);
	  
	  // Now let us print the body of the message to see what response
	  // we have recieved from the server
	  String responseBody = response.getBody().asString();
	  System.out.println("Response Body is =>  " + responseBody);
	  Reporter.getOutput().add(responseBody);
	  
  }
//  @BeforeMethod
//  public void beforeMethod() {
//  }
//
//  @AfterMethod
//  public void afterMethod() {
//  }
//
//
//  @DataProvider
//  public Object[][] dp() {
//    return new Object[][] {
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
//  }
}
