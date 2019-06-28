package com.Learning.WebServices;

import static io.restassured.RestAssured.given;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class RestTest {

	public static Response doGetRequest(String endpoint) {
		RestAssured.defaultParser = Parser.JSON;
		return given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().get(endpoint).then()
				.contentType(ContentType.JSON).extract().response();
	}

	public static void main(String[] args) {

		Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");

		List<String> jsonResponse = response.jsonPath().getList("$");

		System.out.println(jsonResponse.size());
		
		String usernames = response.jsonPath().getString("username");
		System.out.println(usernames);
		
		String username = response.jsonPath().getString("username[0]");
		System.out.println(username);
		
		List<String> jsonResponses = response.jsonPath().getList("username");
		System.out.println(jsonResponses.get(0));
	}
}
