package com.at.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.at.models.Curriculum;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

public class ApiTools {

    public ResponseEntity<String> response;
    public ResponseEntity<String> requestBody;
    public MediaType contentType = MediaType.APPLICATION_JSON;
    public RestTemplate restTemplate = new RestTemplate();
    public HttpHeaders headers = new HttpHeaders();
    public String hostName;
    public String stringCredentials;

    public ApiTools(String environment, String service){
        try {
            this.hostName=getFromProperties("config.properties",environment+"."+service);
        }
        catch (Exception exc){
            exc.printStackTrace();
        }

    }

    public ResponseEntity<String> retrieve(String apiPath) {
//		SSLCertificateValidation.disable();
        try {

//			headers.add("Authorization", null);
            headers.add("User-Agent", "cheese");
            headers.setContentType(contentType);

            restTemplate.setErrorHandler(new ResponseErrorHandler() {

                @Override
                public boolean hasError(ClientHttpResponse response) throws IOException {
                    return false;
                }

                @Override
                public void handleError(ClientHttpResponse response) throws IOException {
                }
            });
            HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
            response = restTemplate.exchange(apiPath, HttpMethod.GET, requestEntity, String.class);
        } catch (HttpClientErrorException e) {

            System.out.println(e.getMessage());
            response = new ResponseEntity<String>(((HttpStatusCodeException) e).getResponseBodyAsString(),((HttpStatusCodeException) e).getStatusCode());

        }

        return response;
    }


    public ResponseEntity<String> PUTMethod(String apiPath, Curriculum requestBody) {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add("OUser-Agent", "User-Agent");
            headers.add("Content-Type", "application/json");

            restTemplate.setErrorHandler(new ResponseErrorHandler() {

                @Override
                public boolean hasError(ClientHttpResponse response) throws IOException {
                    return false;
                }

                @Override
                public void handleError(ClientHttpResponse response) throws IOException {
                }
            });

            HttpEntity<Curriculum> requestEntity = new HttpEntity<>(requestBody, headers);
            response = restTemplate.exchange(apiPath, HttpMethod.PUT, requestEntity, String.class);

        } catch (HttpClientErrorException e) {
            System.out.println(e.getMessage());
            response = new ResponseEntity<String>(((HttpStatusCodeException) e).getResponseBodyAsString(),
                    ((HttpStatusCodeException) e).getStatusCode());

        }
        return response;
    }

    public ResponseEntity<String> POSTMethod(String hostName, String apiPath, Curriculum requestBody) {
//		SSLCertificateValidation.disable();
        try {
//			headers.add("Authorization", null);
            //headers.add("User-Agent", "cheese");
            //headers.setContentType(contentType);

            HttpHeaders headers = new HttpHeaders();
            //headers.add("OUser-Agent", "User-Agent");
            //headers.add("Content-Type", "application/json");
            headers.setContentType(MediaType.APPLICATION_JSON);

            restTemplate.setErrorHandler(new ResponseErrorHandler() {

                @Override
                public boolean hasError(ClientHttpResponse response) throws IOException {
                    return false;
                }

                @Override
                public void handleError(ClientHttpResponse response) throws IOException {
                }
            });
            //HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(map, headers);
            HttpEntity<Curriculum> requestEntity = new HttpEntity<>(requestBody, headers);
            System.out.println("\n\tRequest body: " + requestBody );
            //System.out.println("\n\tFULL PATH " + hostName + "" + apiPath + "" + HttpMethod.POST + "" + requestEntity + "" + String.class);
            //response = restTemplate.exchange(hostName + apiPath, HttpMethod.PUT, , String.class);
            //System.out.println("Api route from post method"+hostName+apiPath);
            response = restTemplate.exchange(hostName + apiPath, HttpMethod.POST, requestEntity, String.class);
            //System.out.println("statuscode  "+response.getStatusCode()+"  body  "+ response.getBody()+" status code value "+response.getStatusCodeValue());
        } catch (HttpClientErrorException e) {
            System.out.println(e.getMessage());
            response = new ResponseEntity<String>(((HttpStatusCodeException) e).getResponseBodyAsString(),((HttpStatusCodeException) e).getStatusCode());

        }
        return response;
    }

    public ResponseEntity<String> retrieveDelete(String hostName, String apiPath ) {
        //		SSLCertificateValidation.disable();
        try {
            //			headers.add("Authorization", null);

            headers.setContentType(contentType);
            restTemplate.setErrorHandler(new ResponseErrorHandler() {


                public boolean hasError(ClientHttpResponse responseDelete) throws IOException {
                    return false;
                }


                public void handleError(ClientHttpResponse responseDelete) throws IOException {
                }
            });
            HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
            response = restTemplate.exchange(hostName + apiPath, HttpMethod.DELETE, requestEntity, String.class);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getMessage());
            response = new ResponseEntity<String>(((HttpStatusCodeException) e).getResponseBodyAsString(),((HttpStatusCodeException) e).getStatusCode());
        }
        return response;
    }

    /**
     * Methods
     * */
    public String getFromProperties(String fileName, String property) throws Exception{
        Properties prop = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        try{
            if(inputStream==null){
                throw new FileNotFoundException("Property file :"+fileName+ "not found");
            }
            prop.load(inputStream);
        } catch (Exception exc){
            exc.printStackTrace();
        }
        return prop.getProperty(property);
    }

}