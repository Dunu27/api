package aswini;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class UpdateShoppersLike{
@Test
public void updateShoppersLikeTest() {
	File f=new File("./src/test/resources/shoppers.json");
	baseURI="https://www.shoppersstack.com/shopping";
given().auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkdW51Mjc3QGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNjgxOTI2MzMwLCJpYXQiOjE2ODE4OTAzMzB9.URnoXD6OU-w_wKPkIlHD_ykQFK8U00hTJGUVx52S40s").body(f).queryParam("shopperId", 20288).contentType(ContentType.JSON).when().patch("/shoppers/likes").then().
assertThat().log().all();
}
}
