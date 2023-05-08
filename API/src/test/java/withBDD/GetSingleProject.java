package withBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProject {
@Test
public void getSingleProjectTest() {
   baseURI="http://rmgtestingserver";
   port=8084;
   when().get("/projects/TY_PROJ_2774")
   .then().statusCode(200).contentType(ContentType.JSON).log().all();
}
}
