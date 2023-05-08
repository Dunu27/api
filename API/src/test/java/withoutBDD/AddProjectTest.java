package withoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest {

	@Test
	public void addProjectTest() {
		int x=new Random().nextInt(1000);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("createdBy", "Aswini");
		jsonObject.put("projectName", "Aswini"+x);
		jsonObject.put("status", "Created");
		jsonObject.put("teamSize", 10);
	    RestAssured restAssured=new RestAssured();
	    RequestSpecification requestSpecification = restAssured.given();
	    requestSpecification.body(jsonObject);
	    requestSpecification.contentType(ContentType.JSON);
	    Response response = requestSpecification.post("http://rmgtestingserver:8084/addProject");
	    ResponseBody body = response.getBody();
	    String s=body.jsonPath().get("projectId");
	    System.out.println(s);
	    ValidatableResponse validateResponse = response.then();
	    validateResponse.assertThat().statusCode(201).and().contentType(ContentType.JSON).log().all();
	}
}
