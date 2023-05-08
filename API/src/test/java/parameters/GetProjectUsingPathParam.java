package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetProjectUsingPathParam {
@Test
public void getProjectUsingPathParamTest() {
	baseURI="http://rmgtestingserver";
	port=8084;
given().pathParam("projectId", "TY_PROJ_2947").
when().get("/projects/{projectId}")
.then().assertThat().statusCode(200).log().all();
}
}
