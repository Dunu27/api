package withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
@Test
public void deleteProjectTest()
{
	Response response = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_2684");
	response.then().assertThat().statusCode(204).log().all();
}
}
