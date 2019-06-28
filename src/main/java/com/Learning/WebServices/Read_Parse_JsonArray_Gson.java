package com.Learning.WebServices;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import com.Learning.pojo.Cities;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Read_Parse_JsonArray_Gson 
{
	@Test
	public void verifyJSONArrayResponse() {
		JsonArray jsonArray = new JsonArray();
		//Get the response as jsonArray.
		jsonArray = given().baseUri("https://jsonplaceholder.typicode.com")
				.basePath("users")
				.get().as(JsonArray.class);

		//Loop through the array and get each element.
		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
			System.out.println(jsonObject.get("id").getAsString());

		}
		
		
		
		
		 
	}
}
