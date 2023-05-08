package waysToPostRequest;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMap {
@Test
public void createProjectUsingHashMapTest() {
	int randomNumber=new Random().nextInt(1000);
	HashMap<String, Object>hashMap=new HashMap<String, Object>();
	hashMap.put("createdBy","AswiniSamal");
	hashMap.put("projectName","Aswini"+randomNumber);
	hashMap.put("status","Created");
	hashMap.put("teamSize",10);
	baseURI="http://rmgtestingserver";
	port=8084;
given().body(hashMap).contentType(ContentType.JSON)
.when().post("/addProject")
.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();

}
}
