package com.Learning.WebServices;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HttpUrlConnectionExample {

	public static void main(String[] args) throws Exception {
		String inline = "";
		String url = "http://services.groupkt.com/country/get/all";
		URL url_request = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) url_request.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int statuscode = conn.getResponseCode();
		System.out.println("Connection code " + conn.getResponseCode());
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("httpResponseCode is not:" + statuscode);
		} else {
			System.out.println("httpResponseCode:" + statuscode);
			Scanner sc = new Scanner(url_request.openStream());
			
			while (sc.hasNext()) {
				inline += sc.nextLine();
			}
			System.out.println("\n :JSON data in string format");
			System.out.println(inline);
			sc.close();
			
		}
		

		JSONParser parser = new JSONParser();
		JSONObject jsonobject = (JSONObject)parser.parse(inline);
		//System.out.println(" json response"+ jsonobject);
		
		JSONArray jsonarray = (JSONArray) jsonobject.get("messages");
	System.out.println(jsonarray);
		
		
		
	
	}
}
