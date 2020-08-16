package advance.RESTAssuredWithSwagger;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import org.junit.Ignore;
import org.junit.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.json.simple.JSONObject;

public class Swagger {

	@Test
	@Ignore
	public void exampleRestWithOMDB() {

		// example with OMDBApi

		given().contentType(ContentType.JSON).when().get("http://www.omdbapi.com/?apikey=cf6d6c63&t=IT&y=2017").then()
				.statusCode(200).body("Rated", equalTo("R"));
	}

	@Test
@Ignore
	public void basicGetForOneID() {
		// works to find a single hotel with an ID
		// the system or whatever is bost at the moment as there is no hotel with the ID
		// of 1
		Response response = given().contentType(ContentType.JSON).when()
				.get("http://localhost:8090/example/v1/hotels/7");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
	}

	@Test
@Ignore
	public void basicGetAll() {
		Response response = given().contentType(ContentType.JSON).when()
				.get("http://localhost:8090/example/v1/hotels?page=0&size=100");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());

	}

	@Test
	@Ignore
	public void deleteRequestSolo() {
		Response response = given().contentType(ContentType.JSON).when()
				.delete("http://localhost:8090/example/v1/hotels/1");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
	}

	@Test

	public void postSwagger() {

		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels";
		
		// set the base URI we are communicating with
		
		RequestSpecification request = RestAssured.given();
		
		//setup our request

		request.header("Content-Type", "application/json");
		
		//define the type of content we are dealing with - JSON

		JSONObject requestParams = new JSONObject();
		
		//start building the request parameters

		requestParams.put("city", "Manchester");
		requestParams.put("description", "This is a test");
		requestParams.put("name", "ANTHIA");
		requestParams.put("rating", 10);

		System.out.println(request.body(requestParams.toString()));
		
		// finally send the request we have built up
		Response response = request.post("/");

		System.out.println(response.getStatusCode());

	}

	@Test
	@Ignore
	public void postThatWorks() {

		// this is with the demoqa rest api

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");

		requestParams.put("UserName", "simpleuser001");
		requestParams.put("Password", "password1");
		requestParams.put("Email", "someuser@gmail.com");

	}

	@Test
	@Ignore
	public void putRequestSolo() {

		RestAssured.baseURI = "http://localhost:8090/example/v1/hotels";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		JSONObject requestParams = new JSONObject();

		requestParams.put("city", "Manchester");
		requestParams.put("description", "This is a test of the put method");
		requestParams.put("name", "Royal Manchester");
		requestParams.put("id", 7);
		requestParams.put("rating", 10);

		System.out.println(request.body(requestParams.toString()));
		Response response = request.put("/7");

		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
	}

}
