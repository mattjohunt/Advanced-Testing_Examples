package advance.restAssured;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class SimpleRESTAssured {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	@Test
	public void exampleRestTestWhichShould200() {
	    given()
	        .contentType(ContentType.JSON)
	    .when()
	        .get("http://www.omdbapi.com/?apikey=&t=IT&y=2017")
	    .then().statusCode(200).
	    body("Rated", equalTo("R"))
	    ;
	    request = given().contentType(ContentType.JSON);
	    response = request.when().get("http://www.omdbapi.com/?apikey=&t=IT&y=2017");
	    System.out.println("response: " + response.prettyPrint());
	    
	}

}
