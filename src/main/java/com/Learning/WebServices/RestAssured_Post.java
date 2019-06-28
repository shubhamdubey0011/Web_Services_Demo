package com.Learning.WebServices;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_Post {

@Test
	public static void postData() {
		RestAssured.baseURI ="http://restapi.demoqa.com/customer/";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("FirstName", "Virender"); // Cast
		 requestParams.put("LastName", "Singh");
		 requestParams.put("UserName", "sdimpleuser2dd2011");
		 requestParams.put("Password", "password1");
		 requestParams.put("Email",  "sample2ee26d9@gmail.com");
		 request.body(requestParams.toJSONString());
		 Response response = request.post("register");
		 
		 int statusCode = response.getStatusCode();
		 System.out.println("statusCode " +statusCode );
		 Assert.assertEquals(statusCode, 200);
		 String successCode = response.jsonPath().get("SuccessCode");
		 System.out.println("successCode : "+successCode);
		 //Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}


}
