package advance.restAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class IntroStep {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	@Given("^a JSON request$")
	public void a_book_exists_with_isbn() {
		request = given().contentType(ContentType.ANY);
	}

	@When("^a user retrieves the film by the title IT$")
	public void a_user_retrieves_the_book_by_isbn() {
		response = request.when().get("http://www.omdbapi.com/?apikey=cf6d6c63&t=IT&y=2017");
	}

	@Then("^the status code reads (\\d+)$")
	public void verify_status_code(int statusCode) {
		json = response.then().statusCode(200);
	}
	
	@Then("^the Rated Field is equal to R$")
	public void the_Rated_Field_is_equal_to_R() throws Throwable {
		json = response.then().body("Rated", equalTo("R"));
	}
	
	@When("^a user retrieves the film by the title Guardians of the Galaxy Two$")
	public void a_user_retrieves_the_film_by_the_title_Guardians_of_the_Galaxy() {
		response = request.when().get("http://www.omdbapi.com/?apikey=cf6d6c63&t=Guradians of the Galaxy");
	}

	@When("^a user retrieves the film by the title \"([^\"]*)\"$")
	public void a_user_retrieves_the_film_by_the_title(String arg1){
		response = request.when().get("http://www.omdbapi.com/?apikey=cf6d6c63&t="+arg1);
	}

	@Then("^the Rated Field is equal to \"([^\"]*)\"$")
	public void the_Rated_Field_is_equal_to(String arg1){
		json = response.then().body("Rated", equalTo(arg1));
		
	}

}
