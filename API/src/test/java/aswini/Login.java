package aswini;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;


public class Login  {
@Test
public void loginTest()  {
	baseURI="https://www.shoppersstack.com/shopping";
	JSONObject j=new JSONObject();
	j.put("email","dunu277@gmail.com");
	j.put("password","Aswini@786");
	j.put("role", "SHOPPER");
	given().body(j).contentType(ContentType.JSON).
when().post("/users/login").then().assertThat().log().all();
}
}
