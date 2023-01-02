package com.api.airline.test.steps;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.airline.pojo.CreateAirlineRequest;
import com.api.airline.utils.CommonRest;
import com.api.airline.utils.Endpoints;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Steps;

public class CreateAirlineSteps{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreateAirlineSteps.class);
	
	@Steps
	CreateAirlineRequest createAirlinerequest;
	
	@Steps
	CommonRest commonRest;
	
	@Steps
	Endpoints endPoint;
	
	RequestSpecification request;
	Response response;
	
	@Given("I create a request for creation of airport")
	public void i_create_a_request_for_creation_of_airport(DataTable data) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<String> details = data.asList(String.class);
		createAirlinerequest.setId(Integer.parseInt(details.get(0))); 
		createAirlinerequest.setName(details.get(1));
		createAirlinerequest.setCountry(details.get(2));
		createAirlinerequest.setLogo(details.get(3));
		createAirlinerequest.setSlogan(details.get(4));
		createAirlinerequest.setHeadQuaters(details.get(5));
		createAirlinerequest.setWebsite(details.get(6));
		createAirlinerequest.setEstablished(details.get(7));
		
		try {
			LOGGER.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createAirlinerequest));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@When("I hit the post request for createAirline API")
	public void i_hit_the_post_request_for_airline() throws IOException {
		System.out.println("value is " + commonRest.processConfFile("config.properties", "baseurl"));
		String baseUri = commonRest.processConfFile("config.properties", "baseurl");
		LOGGER.info("baseurl is " + baseUri) ;
	//	String baseUri = "https://api.instantwebtools.net/v1/airlines";
		response = commonRest.returnpostResponse(createAirlinerequest,baseUri+Endpoints.createAirlineEndpoint);
		LOGGER.info("repsonse is " + response);
	}
	@Then("I should see the airline is created successfully with success code")
	public void i_should_see_the_airline_is_created_successfully() {
	  Assert.assertEquals(200,response.getStatusCode());
	
	}

}
