package com.Learning.WebServices;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathExtraction {

	public static Response response;

	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "https://postman-echo.com";
		RestAssured.basePath = "GET";
		response = given().when().get();
	}

	@Test
	public void veifyPostNumber() {
		String json = response.getBody().asString();
		JsonPath path = new JsonPath(json);
		String port = path.getJsonObject("headers.x-forwarded-port");
		System.out.println("Post number is : " + port);
		Assert.assertEquals(port, "443");
	}

}
