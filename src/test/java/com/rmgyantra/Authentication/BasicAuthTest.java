package com.rmgyantra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthTest {
	
	@Test
	public void basicAuth()
	{
		given()
		.auth()
		.basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.log()
		.all();
	}
	
	
	@Test
	public void preEmptive()
	{
	    given()
	    .auth()
	    .preemptive().basic("rmgyantra", "rmgy@9999")
	    .when()
	    .get("http://localhost:8084/login")
	    .then()
	    .log()
	    .all();
	}
	
	
	@Test
	public void digest() {
		given()
		.auth()
	    .digest("rmgyantra", "rmgy@9999")
	    .when()
	    .get("http://localhost:8084/login")
	    .then()
	    .log().all();
	    
	}
	
	
	
	
	
	
	

}
