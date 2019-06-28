package com.Learning.WebServices;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Learning.pojo.Cities;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GET_Req_RestAssured_ {
	
	private static final JsonParser JSON = null;


	public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {
		given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));
	}
	 
	public void test_ResponseHeaderData_ShouldBeCorrect() {

		given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().header("Content-Length", equalTo("4551"));
	}
	 
	public void test_Md5CheckSumForTest_ShouldBe098f6bcd4621d373cade4e832627b4f6() {

		String originalText = "test";
		String expectedMd5CheckSum = "098f6bcd4621d373cade4e832627b4f6";

		given().param("text", originalText).when().get("http://md5.jsontest.com").then().assertThat().body("md5",
				equalTo(expectedMd5CheckSum));
	}
	 
	public void test_NumberOfCircuits_ShouldBe20_Parameterized() {
	        
	    String season = "2017";
	    int numberOfRaces = 20;
	        
	    given().
	        pathParam("raceSeason",season).
	    when().
	        get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
	    then().
	        assertThat().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(numberOfRaces));
	}
	/*@DataProvider(name="seasonsAndNumberOfRaces")
	public Object[][] createTestDataRecords() {
	    return new Object[][] {
	        {"2017",20},
	        {"2016",21},
	        {"1966",9}
	    }; 
	}
	
	 (dataProvider="seasonsAndNumberOfRaces")
	public void test_NumberOfCircuits_ShouldBe_DataDriven(String season, int numberOfRaces) {
	                
	    given().
	        pathParam("raceSeason",season).
	    when().
	        get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
	    then().
	        assertThat().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(numberOfRaces));
	}*/
	 
	public void test_APIWithBasicAuthentication_ShouldBeGivenAccess() {
	        
	    given().
	        auth().
	        preemptive().
	        basic("username", "password").
	    when().
	        get("http://path.to/basic/secured/api").
	    then().
	        assertThat().
	        statusCode(200);
	}
	 
	public void test_ScenarioRetrieveFirstCircuitFor2017SeasonAndGetCountry_ShouldBeAustralia() {
	        
	    // First, retrieve the circuit ID for the first circuit of the 2017 season
	    String circuitId = given().
	    when().
	        get("http://ergast.com/api/f1/2017/circuits.json").
	    then().
	        extract().
	        path("MRData.CircuitTable.Circuits.circuitId[0]");
	        
	    // Then, retrieve the information known for that circuit and verify it is located in Australia
	    given().
	        pathParam("circuitId",circuitId).
	    when().
	        get("http://ergast.com/api/f1/circuits/{circuitId}.json").
	    then().
	        assertThat().
	        body("MRData.CircuitTable.Circuits.Location[0].country",equalTo("Australia"));
	}
	
	ResponseSpecification checkStatusCodeAndContentType = 
		    new ResponseSpecBuilder().
		        expectStatusCode(200).
		        expectContentType(ContentType.JSON).
		        build();
	public void test_verifyStatusUsinfSpex()
	{
		  given().
		    when().
		        get("http://ergast.com/api/f1/2017/circuits.json").
		    then().
		        assertThat().
		        spec(checkStatusCodeAndContentType).
		    and().
		        body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
	}
	
	
	 @Test
	public void DisplayAllNodesInWeatherAPI() throws JsonParseException, JsonMappingException, IOException
	{
	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	 RequestSpecification httpRequest = RestAssured.given().log().uri();
	 Response response = httpRequest.get("pune");
	 
	 // First get the JsonPath object instance from the Response interface
	 JsonPath jsonPathEvaluator = response.jsonPath();
	 
	 System.out.println(response.statusCode());
	 // Let us print the city variable to see what we got
	 System.out.println("City received from Response " + jsonPathEvaluator.get("City"));
	 
	 // Print the temperature node
	 System.out.println("Temperature received from Response " + jsonPathEvaluator.get("Temperature"));
	 
	 // Print the humidity node
	 System.out.println("Humidity received from Response " + jsonPathEvaluator.get("Humidity"));
	 
	 // Print weather description
	 System.out.println("Weather description received from Response " + jsonPathEvaluator.get("Weather"));
	 
	 // Print Wind Speed
	 System.out.println("City received from Response " + jsonPathEvaluator.get("WindSpeed"));
	 
	 // Print Wind Direction Degree
	 System.out.println("City received from Response " + jsonPathEvaluator.get("WindDirectionDegree"));
	 
	
	 Cities[] cities = ((ResponseOptions<Response>) ((RequestSpecification) given()
             .when()
             .get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
             .then())
             .response())
             .getBody()
             .as(Cities[].class);
		 
		 
	Cities cities1 = given().when().get("http://restapi.demoqa.com/utilities/weather/city/pune").then().extract().response().getBody().as(Cities.class);
			 System.out.println(cities1.getcity());
			 
			
	}
}
