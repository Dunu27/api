package validation;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ValidateResponseTime {
@Test
public void validateResponseTimeTest() {
baseURI="http://rmgtestingserver";
port=8084;
when().get("/projects")
.then().assertThat().time(Matchers.lessThan(1000l),TimeUnit.MILLISECONDS).log().all();
}
}
