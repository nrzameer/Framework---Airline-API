package com.api.airline.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = "pretty", features = "src/test/resources/features" ,
                   glue = "com.api.airline.test.steps", tags = "@smoke")
public class Runner {
	

}
