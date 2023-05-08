package withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	public void updateProjectTest()
	{
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("createdBy", "Aswini");
		jsonObject.put("projectName", "Aswini872");
		jsonObject.put("status", "Completed");
		jsonObject.put("teamSize", 10);
		RestAssured restAssured=new RestAssured();
		RequestSpecification requestSpecification = restAssured.given();
         requestSpecification.body(jsonObject);
         requestSpecification.contentType(ContentType.JSON);
         Response response = requestSpecification.put("http://rmgtestingserver:8084/projects/TY_PROJ_2707");
         response.then().assertThat().statusCode(200).log().all();  
	}
}
