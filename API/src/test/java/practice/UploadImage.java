package practice;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.File;

public class UploadImage {
@Test
public void uploadImageTest() {
	File f=new File("./src/test/resources/image.jpg");
	baseURI="https://petstore.swagger.io/v2";
given().multiPart(f).
when().post("/pet/1/uploadImage").then().assertThat().statusCode(200).log().all();
}
}
 