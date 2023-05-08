package authorization;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2 {
@Test
public void getOAuth2Test() {
	baseURI="http://coop.apps.symfonycasts.com";
	Response response = given().formParam("client_id", "Sdet466666").
	formParam("client_secret", "7b4f8793d10b35c9e87c596275aa5759").
	formParam("grant_type","client_credentials" ).
	formParam("redirect_uri","http://page.com").
	formParam("code", "4470").
	when().post("/token");
	String token=response.jsonPath().get("access_token");
}
}
