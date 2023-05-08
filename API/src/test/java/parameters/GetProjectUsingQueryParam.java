package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetProjectUsingQueryParam {
@Test
public void GetProjectUsingQueryParamTest() {
  baseURI="https://reqres.in/api";
  given().queryParam("page", 2)
  .when().get("/users")
  .then().assertThat().statusCode(200).log().all();
}
}
