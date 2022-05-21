package com.rmgyantra.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth2Test {
	
	@Test
	public void oAuth()
	{
		Response rsps = given()
		.formParams("client_id", "SDET_6")
		.formParams("client_secret", "9ed0abba5104e6748f0fb9956422b3e9")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.post("http://coop.apps.symfonycasts.com/token");
		
		rsps.prettyPrint();
		
		String token = rsps.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth()
		.oauth2(token)
		.pathParam("userId", "3271")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{userId}/eggs-collect")
		.then()
		.log()
		.all();
		
		
		
		
	}

}
