package requestchaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetAndDelete {
@Test
public void getAndDeleteTest() {
	baseURI="http://rmgtestingserver";
	port=8084;
	Response response = when().get("/projects");
	response.then().assertThat().statusCode(200).log().all();
       String proj=response.jsonPath().get("[1].projectId");
       
       given().pathParam("projectId", proj).when().delete("/projects/{projectId}").then().assertThat().statusCode(204).log().all();
}
}
