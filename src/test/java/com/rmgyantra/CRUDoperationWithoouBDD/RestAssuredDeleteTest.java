package com.rmgyantra.CRUDoperationWithoouBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class RestAssuredDeleteTest {
	
	@Test
	public void restAssuredDeleteTest()
	{
		Response rsps = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_003");
		ValidatableResponse vres = rsps.then();
		vres.assertThat().statusCode(204);
		vres.assertThat().contentType(ContentType.JSON);
		vres.log().all();
	}

}
