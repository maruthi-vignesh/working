package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

	import io.restassured.RestAssured;
	import io.restassured.specification.RequestSpecification;
	import io.restassured.response.Response;
	import io.restassured.path.json.JsonPath;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.When;
	import io.cucumber.java.en.Then;

	import org.junit.Assert;

	public class AddPlaceStepDef {

	    
	    RequestSpecification req;   // stores request
	    Response response;          // stores response

	    @Given("add addplace api payload")
	    public void add_addplace_api_payload() {

	        System.out.println("TEST");
	        RestAssured.baseURI = "https://rahulshettyacademy.com";

	        req = RestAssured.given()
	                .log().all()
	                .queryParam("Key", "qaclick123")
	                .header("Content-Type", "application/json")
	                .body("{\r\n"
	                        + "  \"location\": {\r\n"
	                        + "    \"lat\": -38.383494,\r\n"
	                        + "    \"lng\": 33.427362\r\n"
	                        + "  },\r\n"
	                        + "  \"accuracy\": 50,\r\n"
	                        + "  \"name\": \"Frontline house\",\r\n"
	                        + "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
	                        + "  \"address\": \"29, side layout, cohen 09\",\r\n"
	                        + "  \"types\": [\r\n"
	                        + "    \"shoe park\",\r\n"
	                        + "    \"shop\"\r\n"
	                        + "  ],\r\n"
	                        + "  \"website\": \"http://google.com\",\r\n"
	                        + "  \"language\": \"French-IN\"\r\n"
	                        + "}\r\n"
	                        + "");
	    }


	    @When("User calls {string} api with post call")
	    public void user_calls_api_with_post_call(String apiName) {

	        
	        if (apiName.equalsIgnoreCase("addplace")) {

	            response = req.when()
	                    .post("maps/api/place/add/json")
	                    .then()
	                    .log().all()
	                    .extract()
	                    .response();
	        }
	    }


	    
	    @Then("Success reposnse should retrieved with {int} status code")
	    public void success_reposnse_should_retrieved_with_statuc_code(Integer expectedCode) {

	        System.out.println(response.getStatusCode());
	        Assert.assertEquals(expectedCode.intValue(), response.getStatusCode());
	    }


	  
	    @Then("Verify {string} field value is {string}")
	    public void verify_field_value_is(String field, String expectedValue) {

	        JsonPath js = new JsonPath(response.asString());
	        String actualValue = js.getString(field);

	        Assert.assertEquals(expectedValue, actualValue);
	    }


	   
	    }
	

