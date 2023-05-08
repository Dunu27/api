package withBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
@Test
public void updateProjectTest() {
	JSONObject jsonObject=new JSONObject();
	jsonObject.put("createdBy", "Aswini");
	jsonObject.put("projectName", "Aswini951");
	jsonObject.put("status", "Completed");
	jsonObject.put("teamSize", 10);
    baseURI="http://rmgtestingserver";
    port=8084;
    given().body(jsonObject).contentType(ContentType.JSON)
    .when().put("/projects/TY_PROJ_2774") 
    .then().assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
    
}
}
