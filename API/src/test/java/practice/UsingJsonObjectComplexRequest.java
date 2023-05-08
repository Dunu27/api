package practice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UsingJsonObjectComplexRequest {
@Test
public void usingJsonObjectComplexRequestTest() {
	baseURI="https://petstore.swagger.io/v2";
	JSONObject jsonObject=new JSONObject();
	jsonObject.put("id", 0);
	JSONObject jsonObject2=new JSONObject();
	jsonObject2.put("id",0);
	jsonObject2.put("name", "Aswini");
	jsonObject.put("category", jsonObject2);
	jsonObject.put("name", "doggie");
	JSONArray jsonArray=new JSONArray();
	jsonArray.add("Url");
	jsonObject.put("photoUrls",jsonArray);
	JSONArray jsonArray2=new JSONArray();
	JSONObject jsonObject3=new JSONObject();
	jsonObject3.put("id", 0);
	jsonObject3.put("name", "string");
	jsonArray2.add(jsonObject3);
	jsonObject.put("tags", jsonArray2);
	jsonObject.put("status", "available");
	given().body(jsonObject).contentType(ContentType.JSON).
	when().put("/pet").then().assertThat().statusCode(200).log().all();
}
}
