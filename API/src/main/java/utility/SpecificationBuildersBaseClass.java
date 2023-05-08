package utility;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utility.externalFileUtility.PropertyUtility;

public class SpecificationBuildersBaseClass {

	public PropertyUtility propertyUtility=new PropertyUtility();
	public RequestSpecification requestSpecification;
	public ResponseSpecification responseSpecification;
	@BeforeSuite
public void config() {
	RequestSpecBuilder builder=new RequestSpecBuilder();
     builder.setBaseUri(propertyUtility.getPropertyData("baseUri"));
    // builder.setPort(8084);
     builder.setContentType(ContentType.JSON);
     requestSpecification=builder.build();
 	ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
    responseSpecBuilder.expectContentType(ContentType.JSON);
    responseSpecBuilder.expectResponseTime(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS);
    responseSpecification=responseSpecBuilder.build(); 
}
}
