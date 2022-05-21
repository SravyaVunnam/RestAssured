package com.rmgyantra.CRUDoperationWithoouBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestAssuredPostTest {
	
	@Test
	public void restAssuredPostTest()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("created by", "sravya");
		jobj.put("projectname", "SDET_6_rA");
		jobj.put("status", "Created");
		jobj.put("teamSize", 14);
		
		RequestSpecification reqspe = RestAssured.given();
		reqspe.contentType(ContentType.JSON);
		 reqspe.body(jobj);
 	     Response reps = reqspe.post("http://localhost:8084/addProject");
 	    ValidatableResponse vres=reps.then();
		vres.assertThat().statusCode(201);
		vres.assertThat().contentType(ContentType.JSON);
		vres.log().all();
	}

}
