package requestchaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojolibrary.PojoClassForCreatingProject;
import utility.javaUtility.RandomNumberUtility;

import static io.restassured.RestAssured.*;

public class CreateAndUpdate {
@Test
public void createAndUpdateTest() {
	RandomNumberUtility r=new RandomNumberUtility();
	int x=r.getRandomNumber(1000);
	PojoClassForCreatingProject p=new PojoClassForCreatingProject("AswiniKum", "Whixzlaac"+x, "On Going", 30);
	baseURI="http://rmgtestingserver";
	port=8084;
	Response response = given().body(p).contentType(ContentType.JSON). when().post("/addProject");
	response.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
String proj=response.jsonPath().get("projectId");

PojoClassForCreatingProject p1=new PojoClassForCreatingProject("AswiniKum", "Whixzlaac"+x, "Completed", 30);
given().body(p1).pathParam("projectId", proj).contentType(ContentType.JSON).
when().get("/projects/{projectId}").then().assertThat().statusCode(200).log().all();
}
}
