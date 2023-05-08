package requestchaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojolibrary.PojoClassForCreatingProject;
import utility.javaUtility.RandomNumberUtility;

import static io.restassured.RestAssured.*;

public class CreateAndGetProject {
@Test
public void createAndGetProjectTest() {
baseURI="http://rmgtestingserver";
port=8084;
RandomNumberUtility r=new RandomNumberUtility();
int x=r.getRandomNumber(1000);
PojoClassForCreatingProject p=new PojoClassForCreatingProject("AswiniKumarSamal", "Whixzlaac7"+x, "On Going", 30);
Response response = given().body(p).contentType(ContentType.JSON).when().post("/addProject");
response.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
String proj=response.jsonPath().get("projectId");
//System.out.println(proj);
given().pathParam("projectId", proj).when().get("/projets/{projectId}").then().contentType(ContentType.JSON).statusCode(200).log().all();
}
}
