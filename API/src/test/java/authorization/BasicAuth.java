package authorization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuth {

	@Test
	public void basicAuthTest() {
		baseURI="http://localhost";
		port=8084;
		when().get("/login").then().assertThat().statusCode(200).log().all();
		
	}
}
