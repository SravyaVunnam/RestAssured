package com.rmgyantra.CRUDoperationWithBDD;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RestAssured.PojoClass.POJOClass;

import io.restassured.http.ContentType;

public class CreatingProjectWithDataProvider {
	
	@Test(dataProvider = "multipleData")
	public void creatingProjectWithDataProvider(String createdBy, String projectName, String status, int teamSize) 
	{
		POJOClass p=new POJOClass(createdBy, projectName, status, teamSize);
		
		
		given()
		.contentType(ContentType.JSON)
		.body(p)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log()
		.all();
		
	}
		
		@DataProvider
       public Object multipleData()
       {
    	   Object[][] obj=new Object[2][4];
    	   obj[0][0]="RajKumar";
    	   obj[0][1]="rajKumar_1";
    	   obj[0][2]="created";
    	   obj[0][3]=14;
    	   
    	   
    	   obj[1][0]="RajKumar1";
    	   obj[1][1]="rajKumar_123";
    	   obj[1][2]="created";
    	   obj[1][3]=14;
    	   
    	   
    	   
		return obj;
    	   
       }
	

}
