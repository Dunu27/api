package aswini;

import static io.restassured.RestAssured.*;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class RegisterShopper {
	@Test
public void registerShopperTest() {
	baseURI="https://www.shoppersstack.com/shopping";
JSONObject j=new JSONObject();
j.put("city", "Bengaluru");
j.put("country", "India");
j.put("email", "dunu77@gmail.com");
j.put("firstName", "Aswini");
j.put("gender", "MALE");
j.put("lastName", "Samal");
j.put("password", "Aswini@786");
j.put("phone", 7008525036l);
j.put("state", "Karnataka");
j.put("zoneId","ALPHA");
given().body(j).contentType(ContentType.JSON).
when().post("/shoppers").then().log().all();

}
}
