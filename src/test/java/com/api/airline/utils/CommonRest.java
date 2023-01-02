package com.api.airline.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class CommonRest  {
	
	RequestSpecification request;
	Response response;
	
	public String processConfFile(String filepath, String key) throws IOException {
		Properties prop = new Properties();
	    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filepath);
	    if (inputStream == null) {
	        throw new FileNotFoundException("Property File '" + filepath + "' not found in the classpath");
	    }
	    prop.load(inputStream);
	    String value = prop.getProperty(key);
	    inputStream.close();
		return value;
	}
	
	public RequestSpecification createRequestWithContentType(String uri) throws IOException {
		return request = SerenityRest.given().baseUri(uri).contentType("application/json");
	}
	
	public RequestSpecification createRequestWithoutContentType(String uri) throws IOException {
		return request = SerenityRest.given().baseUri(uri);
	}
	
	public Response validatePostResponse(Object body, String uri,String key) {
		response = SerenityRest.given().contentType("application/json").and().body(body).post("api.baseurl"+uri);
		JsonPath jp = response.jsonPath();
		return jp.get(key);
	}
	
	public int validatePostStatusCode(Object body, String uri) throws IOException {
		response = SerenityRest.given().contentType("application/json").and().body(body).post(uri);
		return response.getStatusCode();
	}
	
	public Response returnpostResponse(Object body, String uri) {
		response = SerenityRest.given().contentType("application/json").and().body(body).post(uri);
		return response;
	}
	
	public Response returnpostWitoutContentResponse(Object body, String uri) {
		response = SerenityRest.given().and().body(body).post(uri);
		return response;
	}
	
	public int validateGetStatusCode(Object body, String uri) {
		response = SerenityRest.given().contentType("application/json").and().get();
		return response.getStatusCode();
	}
	
}
