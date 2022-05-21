package com.rmgyantra.CRUDoperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GettingProjectTest {
	
	@Test
	public void gettingProjectTest()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON);
	}
	
	
	@Test
	public void PostProject()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("created by", "sravya");
		jobj.put("projectname", "SDET_6_Sra");
		jobj.put("status", "Created");
		jobj.put("teamSize", 14);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
	
	@Test
	public void putProject()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "sravya");
		jobj.put("projectName", "SDET_6_Sravya");
		jobj.put("status", "Created");
		jobj.put("teamSize", 13);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_603")
		.then()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
	
	@Test
	public void patchProject()
	{
		JSONObject request=new JSONObject();

		request.put("createdBy", "soumya");
		request.put("projectName", "RestAssured-Maven20");
//		request.put("status", "created");
//		request.put("teamSize", 14);
		
		given()
		.contentType(ContentType.JSON)
		.body(request)
		.when()
		.patch("https://reqres.in/api/users/2")
		.then()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
	
	
	@Test
	public void deleteProject()
	{
	  when()
	  .delete("http://localhost:8084/projects/TY_PROJ_405")
	  .then()
	  .assertThat().statusCode(204)
	  .and()
	  .assertThat().contentType(ContentType.JSON)
	  .log().all();
	}

}
