package advance.advance;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import com.jayway.restassured.http.ContentType;

public class newTest {

	@Test
	public void exampleRestTestWhichSHould401() {
		given().contentType(ContentType.JSON).when().get("http://www.omdbapi.com/?apikey=cf6d&t=title&y=2017").then()
				.statusCode(401);
<<<<<<< HEAD
		// This test should pass due to the incorrect application of the apikey.
=======
		// This test should fail due to the incorrect application of the apikey.
>>>>>>> f4c84f4bdd2e51a1b3be29a32c910f9c7f60fce6
	}

}
