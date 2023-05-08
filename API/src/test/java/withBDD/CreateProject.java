package withBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import utility.SpecificationBuildersBaseClass;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProject extends SpecificationBuildersBaseClass {
@Test
public void createProjectTest() {
	JSONObject jsonObject=new JSONObject();
    jsonObject.put("username", "Aswini");
    jsonObject.put("email", "Aswini475521");
    jsonObject.put("password", "123456");
	given().spec(requestSpecification).body(jsonObject).
when().post("/register")
	.then().spec(responseSpecification).log().all();

}
}
