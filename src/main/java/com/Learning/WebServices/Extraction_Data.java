package com.Learning.WebServices;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Extraction_Data 
{ 
	@BeforeTest
  public void setup()
  {
	  RestAssured.baseURI="https://postman-echo.com";
	  RestAssured.basePath="get";
  }
  @Test
  public void etractData()
  {
	  Response response = given().when().contentType(ContentType.JSON).get().then().extract().response();
	  System.out.println(response.path("headers.x-forwarded-proto"));
  }
}

