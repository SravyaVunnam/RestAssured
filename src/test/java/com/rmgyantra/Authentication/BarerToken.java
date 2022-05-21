package com.rmgyantra.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BarerToken {
	
	@Test
	public void barerToken()
	{
		given()
		.auth()
		.oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.log()
		.all();
		
	}

}
