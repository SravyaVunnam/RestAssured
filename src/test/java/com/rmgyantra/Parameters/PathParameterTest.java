package com.rmgyantra.Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class PathParameterTest {

	@Test
	public void pathParameterTest() {

		given()
		.pathParam("proID", "TY_PROJ_220")
		.when()
		.get("http://localhost:8084/projects/{proID}")
		.then()
		.log().all();

	}


	@Test
	public void queryParameter()
	{
		given()
		.queryParam("page", 2)
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.log()
		.all();
	}


	@Test
	public void gitParameter()
	{
		given()
		.pathParam("username", "SravyaVunnam")
		.queryParam("sort", "full_name")
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.log().all();
	}


	@Test
	public void postProject() {
		HashMap hp=new HashMap();
		hp.put("createdBy", "laxmi");
		hp.put("projectName", "SDET_6_Rajku");
		hp.put("status", "On Going");
		hp.put("teamSize", 13);
		Response rsps = given()
				.contentType(ContentType.JSON)
				.body(hp)
				.when()
				.post("http://localhost:8084/addProject");
		String proID = rsps.jsonPath().get("projectId");
		rsps.then().log().all();

		







	}


}
