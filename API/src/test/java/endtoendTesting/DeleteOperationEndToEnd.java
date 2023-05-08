package endtoendTesting;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import utility.externalFileUtility.JdbcUtility;

public class DeleteOperationEndToEnd {
	@Test
	public void deleteOperationEndToEndTest() {
		baseURI="http://rmgtestingserver";
		port=8084;
		String proj="TY_PROJ_3475";
		JdbcUtility jdbcUtility=new JdbcUtility();
		given().pathParam("projectId",proj).
		when().delete("/projects/{projectId}").
		then().assertThat().statusCode(204).log().all();

		Set<String>s=jdbcUtility.getData("Select * from project;","project_id");
		boolean flag=false;
		for(String id:s) {
			if(id.equalsIgnoreCase(proj)) 
				flag=true;
		}  
		if(flag)
			System.out.println(proj+" Project is not deleted in database");
		else
			System.out.println(proj+" Project is deleted in database");	
	}
}

