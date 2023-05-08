package requestchaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojolibrary.PojoClassForCreatingProject;
import utility.javaUtility.RandomNumberUtility;

public class CreateAndDelete {
@Test
public void createAndDeleteTest() {
	RandomNumberUtility r=new RandomNumberUtility();
	int x=r.getRandomNumber(1000);
	PojoClassForCreatingProject p=new PojoClassForCreatingProject("AswiniKumarSamal", "Whixzlaac7894", "On Going", 30);
	baseURI="http://rmgtestingserver";
	port=8084;
	Response response = given().body(p).contentType(ContentType.JSON).when().post("/addProject");
	response.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
     String proj = response.jsonPath().get("projectId");
     given().pathParam("projectId", proj).when().delete("/projects/{projectId}").then().assertThat().statusCode(204).log().all();
}
}
