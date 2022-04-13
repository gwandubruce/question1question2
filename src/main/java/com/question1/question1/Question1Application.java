package com.question1.question1;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.List;

public class Question1Application {




	public static String getProjects (){
		String json = null;

		try {
			// request url
			String url = "https://v1.forms.southafricanorth.cloudapp.azure.com/";

			// create auth credentials
			String authStr = "dataviewer@ophid.co.zw:pass";
			String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

			// create headers
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + base64Creds);
			headers.add("status","OPEN");



			// create request
			HttpEntity request = new HttpEntity(headers);

			// make a request
			ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class);

			// get JSON response
			json = response.getBody();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return json;}


	public static void main(String[] args) {


        String projects = getProjects();

		System.out.println(projects);

	}

}


