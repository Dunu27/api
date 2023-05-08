package body;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PracticeAsString {
@Test
public void practiceAsStringTest() {
baseURI="http://rmgtestingserver";
port=8084;
String s=when().get("/projects").body().asString();
System.out.println(s);
}
}
