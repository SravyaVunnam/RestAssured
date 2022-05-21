package com.rmgyantra.CRUDoperationWithoouBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestAssuredPatchTest {
    
	@Test
	public void restAssuredPatchTest()
	{
		JSONObject request=new JSONObject();

		request.put("createdBy", "soumya");
		request.put("projectName", "RestAssured-Maven31");
//		request.put("status", "created");
//		request.put("teamSize", 14);
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(request);
		Response reps = reqspec.patch("https://reqres.in/api/users/2");
		ValidatableResponse vres=reps.then();
		vres.assertThat().statusCode(200);
		vres.assertThat().contentType(ContentType.JSON);
		vres.log().all();

	}

}
