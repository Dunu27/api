package waysToPostRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJsonFile {
@Test
public void createProjectUsingJsonFileTest() {
	File f=new File("./src/test/resources/body.json");
	baseURI="http://rmgtestingserver";
	port=8084;
	given().body(f).contentType(ContentType.JSON)
	.when().post("/addProject")
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
		
}
}
