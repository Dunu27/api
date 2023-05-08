package dataDrivenTesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojolibrary.PojoClassForCreatingProject;
import utility.externalFileUtility.ExcelUtility;
import utility.javaUtility.RandomNumberUtility;

public class UsingGenericUtility {
	@Test(dataProvider = "getData")
	public void dataproviderTest(String createdBy,String projectName,String status,String teamSize) {
		baseURI="http://rmgtestingserver";
		port=8084;
		int tsize=Integer.parseInt(teamSize);
		RandomNumberUtility randomNumberUtility=new RandomNumberUtility();
		int r=randomNumberUtility.getRandomNumber(1000);
		PojoClassForCreatingProject pojoClassForCreatingProject=new PojoClassForCreatingProject(createdBy, projectName+r, status,tsize);
		given().body(pojoClassForCreatingProject).contentType(ContentType.JSON).
	when().post("/addProject").then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();	
	}
	@DataProvider
	public Object[][] getData() {
		ExcelUtility e=new ExcelUtility();
		Object[][]a=e.getExcelData("Sheet1");
		return a;
	}

}
