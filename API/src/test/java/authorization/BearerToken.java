package authorization;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void bearerTokenTest() {
		baseURI = "https://api.github.com";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "aswiniii");
		given().auth().oauth2("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").body(jsonObject).contentType(ContentType.JSON)
				.when().post("/user/repos").then().assertThat().statusCode(201).log().all();
	}
}
