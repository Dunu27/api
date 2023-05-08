package withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
@Test
public void getSingleProjectTest() {
	Response response = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_2707");
	response.then().statusCode(200).log().all();
	
}
}
