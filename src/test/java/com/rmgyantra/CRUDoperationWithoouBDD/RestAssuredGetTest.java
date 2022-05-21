package com.rmgyantra.CRUDoperationWithoouBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class RestAssuredGetTest {
	
	@Test
	public void restAssuredGetTest()
	{
		Response rsps = RestAssured.get("http://localhost:8084/projects");
		ValidatableResponse vres = rsps.then();
		vres.assertThat().statusCode(200);
		vres.assertThat().contentType(ContentType.JSON);
		vres.log().all();
	}

}
