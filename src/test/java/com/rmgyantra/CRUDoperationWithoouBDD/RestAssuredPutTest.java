package com.rmgyantra.CRUDoperationWithoouBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestAssuredPutTest {
	
	@Test
	public void restAssuredPutTest()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "laxmi");
		jobj.put("projectName", "SDET_6_RA");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 13);
		
		RequestSpecification reqspe = RestAssured.given();
		reqspe.contentType(ContentType.JSON);
		 reqspe.body(jobj);
 	     Response reps = reqspe.put("http://localhost:8084/projects/TY_PROJ_602");
 	    ValidatableResponse vres=reps.then();
		vres.assertThat().statusCode(200);
		vres.assertThat().contentType(ContentType.JSON);
		vres.log().all();
	}

}
