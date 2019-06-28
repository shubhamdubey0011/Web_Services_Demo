package com.Learning.WebServices;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Delete_ResrAssured 
{
	@Test
 public static void testDelete()
 {
	 
	 RestAssured.baseURI="http://jsonplaceholder.typicode.com";
	 RestAssured.basePath="/posts/";
	 
	 given().when().contentType(ContentType.JSON).delete("1").then().assertThat().header("Expires", equalTo("-1"));
	 
	 
 }
}
