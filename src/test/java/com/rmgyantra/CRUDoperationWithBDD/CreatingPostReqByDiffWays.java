package com.rmgyantra.CRUDoperationWithBDD;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.RestAssured.PojoClass.POJOClass;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class CreatingPostReqByDiffWays {
	
	@Test
	public void creatingPostReqByDiffWays() 
	{
		HashMap hp=new HashMap();
		hp.put("createdBy", "laxmi");
		hp.put("projectName", "SDET_6_S");
		hp.put("status", "On Going");
		hp.put("teamSize", 13);
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
	
	
	@Test
	public void creatingProjectByJsonFile() 
	{
		File f=new File("./Rest.json");
		given()
		.contentType(ContentType.JSON)
		.body(f)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
	
	
	@Test
	public void CreatingProjectWithPOJOClass()
	{
		POJOClass pojo=new POJOClass("Sravya", "SDET_6_Assure", "Created", 16);
		
		given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log()
		.all();
	}
}
