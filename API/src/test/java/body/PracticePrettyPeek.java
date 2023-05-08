package body;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class PracticePrettyPeek {
@Test
public void practicePrettyPeekTest() {
	baseURI="http://rmgtestingserver";
	port=8084;
	when().get("/projects").body().prettyPeek();
	//System.out.println(s);
	
}
}
