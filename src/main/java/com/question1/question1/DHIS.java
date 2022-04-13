package com.question1.question1;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class DHIS {



    public static String getProjects (){
        String json = null;

        try {
            // request url
            String url = "https://ophidcldapp.southafricanorth.cloudapp.azure.com:8080/dhis/api";

            // create auth credentials
            String authStr = "devuser:#Pass1234";
            String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

            // create headers
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);

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

        System.out.println(getProjects());




    }
}
