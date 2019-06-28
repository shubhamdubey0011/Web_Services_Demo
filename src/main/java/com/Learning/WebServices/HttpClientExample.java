package com.Learning.WebServices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;

public class HttpClientExample {

	public static void main(String[] args) throws Exception {
		HttpClientExample http = new HttpClientExample();

		System.out.println("Sending get request ");
		http.sendGet();
		System.out.println("Sending post request ");
		http.sendpost();
	}

		public void sendGet() throws Exception {
			String url = "http://services.groupkt.com/country/get/all";
			HttpClient client = HttpClients.createDefault();
			HttpGet getrequest = new HttpGet(url);
			getrequest.setHeader("Content-Type", "application/json");
		getrequest.setHeader("Accept", "text/plain");
	
			HttpResponse response = client.execute(getrequest);
			//response.getStatusLine().getStatusCode();
			
			System.out.println("***************************" +getrequest.getRequestLine());
			
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + 
	                       response.getStatusLine().getStatusCode());
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) 
			{
			//  result.append(line);
			 // result.append(line + "\n");
			  result.append(line).append('\n');
			 
			 
			}
			 // JSONObject myObject = new JSONObject(response);
			System.out.println("Content "+ result.toString());
			
			
			
		}

	public void sendpost() throws Exception {

		String url = "https://selfsolve.apple.com/wcResults.do";
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		HttpPost postrequest = new HttpPost(url);
		postrequest.setHeader("Content-Type", "application/json");
		postrequest.setHeader("Accept", "text/plain");
		
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
		urlParameters.add(new BasicNameValuePair("cn", ""));
		urlParameters.add(new BasicNameValuePair("locale", ""));
		urlParameters.add(new BasicNameValuePair("caller", ""));
		urlParameters.add(new BasicNameValuePair("num", "12345"));

		postrequest.setEntity(new UrlEncodedFormEntity(urlParameters));
		
		
		CloseableHttpResponse response = client.execute(postrequest);
		
		System.out.println(""+response.getStatusLine().getStatusCode());
		//response.getStatusLine().getStatusCode();
		
	
		
		
	}
}
