package com.rmgyantra.Validation;

import static  io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class StaticResponseTest {
	
	@Test
	public void staticResponse()
	{
	   String expData="deepak_pro-2";
	   
	   Response resp = when().get("http://localhost:8084/projects");
	   
	    String ActData = resp.jsonPath().get("[0].projectName");
	    
	   Assert.assertEquals(ActData, expData);
	}

	@Test
	public void dynamicResponse()
	{
	   String expData="MT806";
	   
	   Response resp = when().get("http://localhost:8084/projects");
	   
	    List<String> list = resp.jsonPath().get("projectName");
	    for(String s:list)
	    {
	      if(s.equals(expData))
	      {
	    	  System.out.println("name matching");
	      }
	    }
	    
	//   Assert.assertEquals(ActData, expData);
	}

	
	
}
