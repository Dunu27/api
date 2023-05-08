package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetProjectUsingFormParam {
@Test
public void GetProjectUsingQueryParamTest() {
	baseURI="http://rmgtestingserver";
	port=8084;
given().formParam("createdBy", "AswiniKumarSamal").
formParam("projectName", "Aswinishdalfhl").
formParam("status", "On Going").
formParam("teamSize", 20).when().post("/addProject").then().assertThat().statusCode(201).log().all();
}
}
