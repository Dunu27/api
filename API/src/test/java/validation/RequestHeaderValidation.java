package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestHeaderValidation {
@Test
public void requestHeaderValidationTest() {
	baseURI="http://rmgtestingserver";
	port=8084;
	String expStatusLine="HTTP/1.1 200 ";
	String expPragma = "no-cache";
	String expVary="Access-Control-Request-Headers";
	String expTransferEncoding="chunked";
	String expContentType="application/json";
	Response response = when().get("/projects");
	String actStatusLine=response.getStatusLine();
	String actPragma=response.getHeader("Pragma");
	String actVary=response.getHeader("Vary");
	String actTransferEncoding=response.getHeader("Transfer-Encoding");
	String actContentType=response.getHeader("Content-Type");
    Assert.assertEquals(actStatusLine,expStatusLine);
    Assert.assertEquals( actPragma,expPragma);
    Assert.assertEquals(actVary,expVary);
    Assert.assertEquals(actTransferEncoding, expTransferEncoding);
    Assert.assertEquals(actContentType, expContentType);
}
}
