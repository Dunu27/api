package waysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJson {
@Test
public void createProjectUsingJsonTest() {
	baseURI="http://rmgtestingserver";
	port=8084;
	int randomNumber=new Random().nextInt(1000);
	JSONObject jsonObject=new JSONObject();
	jsonObject.put("createdBy","AswiniSamal");
	jsonObject.put("projectName","Aswini"+randomNumber);
	jsonObject.put("status","Created");
	jsonObject.put("teamSize",10);
	given().body(jsonObject).contentType(ContentType.JSON)
.when().post("/addProject")
	.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	
}
}
