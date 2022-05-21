package com.rmgyantra.Validation;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ResponseTimeValidationTest {
	
	@Test
	public void responseTimeValidationTest()
	{
	     when()
	     .get("http://localhost:8084/projects")
	     .then()
	     .assertThat().time(Matchers.lessThan(300L),TimeUnit.SECONDS)
	     .assertThat().body("[6].projectName",Matchers.equalTo("MT_4"))
	     .log()
	     .all();
	     
	}

}
