package withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetProject {

	@Test
	public  void getProjectStatus() {
       RestAssured restAssured=new RestAssured();
       Response response = restAssured.get("http://rmgtestingserver:8084/projects");
       response.then().statusCode(200).log().all();
	}

}
