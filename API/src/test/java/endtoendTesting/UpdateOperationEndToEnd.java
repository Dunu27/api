package endtoendTesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojolibrary.PojoClassForCreatingProject;
import utility.externalFileUtility.JdbcUtility;
import utility.javaUtility.RandomNumberUtility;

public class UpdateOperationEndToEnd {
@Test
public void updateOperationEndToEndTest() {
	baseURI="http://rmgtestingserver";
	port=8084;
	RandomNumberUtility r=new RandomNumberUtility();
	int x=r.getRandomNumber(1000);
	int teamSize=18;
	String proj="TY_PROJ_3503";
	PojoClassForCreatingProject p1=new PojoClassForCreatingProject("AswiniKum", "Whixzlaac"+x, "Completed", teamSize);
	given().body(p1).pathParam("projectId", proj).contentType(ContentType.JSON).
	when().put("/projects/{projectId}").then().assertThat().statusCode(200).log().all();
	String query="Select team_size from project where project_id='"+proj+"'";
	JdbcUtility jdbcUtility=new JdbcUtility();
	Set<Integer>s=jdbcUtility.getData(query,1);
boolean flag=false;
	for(Integer tsize:s) {
	if(tsize==teamSize)
		flag=true;
		
}
	if(flag)
		System.out.println("Data updated in database");
	else
		System.out.println("Data not updated in database");
}
}
