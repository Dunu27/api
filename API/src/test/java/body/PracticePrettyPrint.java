package body;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class PracticePrettyPrint {
@Test
public void practicePrettyPrintTest() {
	baseURI="http://rmgtestingserver";
	port=8084;
	String s=when().get("/projects").body().prettyPrint();
	//System.out.println(s);

}
}
