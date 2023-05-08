package aswini;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilderBaseClass {
	public RequestSpecification requestSpecification;
	public ResponseSpecification responseSpecification;
	@BeforeSuite
	public void config() {
		RequestSpecBuilder builder=new RequestSpecBuilder();
	     builder.setBaseUri("https://www.shoppersstack.com/shopping");
	     builder.setContentType(ContentType.JSON);
	     requestSpecification=builder.build();
	 	ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
	   // responseSpecBuilder.expectContentType(ContentType.JSON);
	    responseSpecBuilder.expectResponseTime(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS);
	    responseSpecification=responseSpecBuilder.build();
}
}
