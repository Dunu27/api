package aswini;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetLikesOfShopper {
@Test
	public void getLikesOfShopperTest() {
	baseURI="https://www.shoppersstack.com/shopping";
	
	given().auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkdW51Mjc3QGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNjgxOTI2MzMwLCJpYXQiOjE2ODE4OTAzMzB9.URnoXD6OU-w_wKPkIlHD_ykQFK8U00hTJGUVx52S40s").queryParam("shopperId", 20288).
  when().get("/shoppers/likes").then().log().all();
}
}
