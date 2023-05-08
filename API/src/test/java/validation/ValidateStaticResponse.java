package validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ValidateStaticResponse {
@Test
public void validateStaticResponseTest() {
	String expProjectId="06/01/2023";
	baseURI="http://rmgtestingserver";
	port=8084;
	Response response = when().get("/projects");
	String actProjectid= response.jsonPath().get("[0].projectId");
	Assert.assertEquals(actProjectid,expProjectId);
	response.then().log().all();
}
}
