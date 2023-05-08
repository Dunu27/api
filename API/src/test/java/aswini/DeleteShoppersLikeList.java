package aswini;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteShoppersLikeList{
@Test
public void deleteShoppersLikeListTest() {
	baseURI="https://www.shoppersstack.com/shopping";
	given().auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkdW51Mjc3QGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNjgxOTI2MzMwLCJpYXQiOjE2ODE4OTAzMzB9.URnoXD6OU-w_wKPkIlHD_ykQFK8U00hTJGUVx52S40s").queryParam("zoneId", "ALPHA").contentType(ContentType.JSON).when().get("/products/alpha").then().
	assertThat().log().all();
	
	given().auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkdW51Mjc3QGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNjgxOTI2MzMwLCJpYXQiOjE2ODE4OTAzMzB9.URnoXD6OU-w_wKPkIlHD_ykQFK8U00hTJGUVx52S40s").queryParam("category", "electronics").queryParam("shopperId", 10797).when().delete("/shoppers/likes").then().assertThat().statusCode(200).log().all();
}
}
