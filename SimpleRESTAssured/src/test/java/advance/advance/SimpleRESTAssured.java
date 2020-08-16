package advance.advance;

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
		
		//Please replace ?????????? with a valid apikey		
		
	    given()
	        .contentType(ContentType.JSON)
	    .when()
	        .get("http://www.omdbapi.com/?apikey=??????????&t=IT&y=2017")
	    .then().statusCode(200).
<<<<<<< HEAD
	    body("Rated", equalTo("R"));
	    
	    request = given().contentType(ContentType.JSON);
	    
=======
	    body("Rated", equalTo("R"))
	    ;
	    request = given().contentType(ContentType.JSON);
>>>>>>> f4c84f4bdd2e51a1b3be29a32c910f9c7f60fce6
	    response = request.when().get("http://www.omdbapi.com/?apikey=?????????&t=IT&y=2017");
	    System.out.println("response: " + response.prettyPrint());
	    
	}

}
