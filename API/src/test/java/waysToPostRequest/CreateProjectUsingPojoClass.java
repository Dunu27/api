package waysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojolibrary.PojoClassForCreatingProject;

public class CreateProjectUsingPojoClass {
@Test
public void createProjectUsingPojoClassTest() {
	PojoClassForCreatingProject p=new PojoClassForCreatingProject("AswiniKumarSamal", "Whixzlaac7894", "On Going", 30);
	baseURI="http://rmgtestingserver";
	port=8084;
	given().body(p).contentType(ContentType.JSON).
	when().post("/addProject")
	.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
}
}
