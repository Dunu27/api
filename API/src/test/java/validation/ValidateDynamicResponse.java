package validation;

import javax.annotation.meta.When;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ValidateDynamicResponse {
@Test
public void validateDynamicResponseTest() {
String exProjectId="TY_PROJ_2939";
	baseURI="http://rmgtestingserver";
port=8084;
Response response = when().get("/projects");
response.then().log().all();
List<String> projects = response.jsonPath().get("projectId");
boolean flag=false;
for(String project:projects) {
	if(project.equalsIgnoreCase(exProjectId)) {
		flag=true;
	}
}
if(flag)
	System.out.println("Data verified");
Assert.assertTrue(flag);
}
}
