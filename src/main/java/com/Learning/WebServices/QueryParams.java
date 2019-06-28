package com.Learning.WebServices;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class QueryParams 
{
	 Response response ;
	@BeforeTest
	public void setup() {
		RestAssured.baseURI="http://jsonplaceholder.typicode.com";
		 RestAssured.basePath="comments";
	}
	@Test(priority = 0)
	public void verifyAllComments() 
	{
      response=given().when().contentType(ContentType.JSON).get().then().extract().response();
      System.out.println(" : "+response.asString());
	}

	@Test(priority = 1)
	public void verifyFilterdComments() {
        response=given().queryParam("postId", "1").when().contentType(ContentType.JSON).get().then().extract().response();
        System.out.println("=============================Beginning of TEST 2 =================");
        System.out.println(" : "+response.asString());
        
        
	}
}
