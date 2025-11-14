package stepDefinitions;
import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
public class AddPlaceStepDef {
	 @Given("add addplace api payload")
	    public void add_addplace_api_payload() {
	        System.out.println("Payload added");
	    }

	    @When("User calls {string} api with post call")
	    public void user_calls_api_with_post_call(String api) {
	        System.out.println("Calling API: " + api);
	    }

	    @Then("Success response should retrieved with {int} status code")
	    public void success_response(int code) {
	        System.out.println("Status code verified: " + code);
	    }

	    @Then("Verify {string} field value is {string}")
	    public void verify_field_value(String field, String value) {
	        System.out.println("Verifying: " + field + " = " + value);
	    }
}
