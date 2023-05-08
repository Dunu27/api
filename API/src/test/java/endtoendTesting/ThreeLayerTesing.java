package endtoendTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojolibrary.PojoClassForCreatingProject;
import utility.externalFileUtility.JdbcUtility;
import utility.javaUtility.RandomNumberUtility;

import static io.restassured.RestAssured.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ThreeLayerTesing {
@Test
public void threeLayerTestingTest() {
baseURI="http://rmgtestingserver";
port=8084;
RandomNumberUtility r=new RandomNumberUtility();
JdbcUtility jdbcUtility=new JdbcUtility();
int x=r.getRandomNumber(1000);
PojoClassForCreatingProject p=new PojoClassForCreatingProject("AswiniKum", "Whixzlaac"+x, "On Going", 30);
Response response =given().body(p).contentType(ContentType.JSON).when().post("/addProject");
String projectId=response.jsonPath().get("projectId");
response.then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();

Set<String>s=jdbcUtility.getData("Select * from project;","project_id");
boolean flag=false;
for(String id:s) {
	if(id.equalsIgnoreCase(projectId)) 
		flag=true;
}
if(flag)
System.out.println(projectId+" Project is present in database");
else
	System.out.println(projectId+" Project is not present in database");	
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("http://localhost:8084/");

driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
driver.findElement(By.xpath("//button[text()='Sign in']")).click();
driver.findElement(By.linkText("Projects")).click();


}

}
