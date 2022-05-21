package com.rmgyantra.EndToEndScenario;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.RestAssured.PojoClass.POJOClass;
import com.mysql.cj.jdbc.Driver;
import com.rmgyantra.GenericLibrary.BaseApiClass;
import com.rmgyantra.GenericLibrary.EndPoints;
import com.rmgyantra.GenericLibrary.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class EndToEndScenario extends BaseApiClass{
	

	
	@Test
	public void endToEndScenario() throws Throwable
	{
		JavaUtility javaUtility=new JavaUtility();
		
		 baseURI="http://localhost:8084";
	
		POJOClass p=new POJOClass("Sravya", "Rajkumar"+javaUtility.generateRandom(), "created", 13);
		
		Response rsps = given()
		.contentType(ContentType.JSON)
		.body(p)
		.when()
		.post(EndPoints.createproject);

		
		
		String pron = rsps.jsonPath().get("projectName");
		System.out.println(pron);
	
		String proj = rsps.jsonPath().get("projectId");
		System.out.println(proj);
		
		 Response res = given()
		.pathParam("proID", proj)
		.when()
		.get(EndPoints.getproject+"/{proID}");
		res.then()
		.log().all();
		
		
		res.then()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
		ResultSet rest = dataBaseUtility.executeStatement("select * from project where project_name='"+pron+"'");
      
      //4. Execute the Query
      
      while(rest.next())
      {
			   String proida = rest.getString(1);
			   Assert.assertEquals(proida, proj);
			   System.out.println("Database verified");
      }
		
		
	}

}
