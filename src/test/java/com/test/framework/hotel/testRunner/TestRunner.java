package com.test.framework.hotel.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;

import java.util.Map;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/featureFiles" },
		glue = {"com/test/framework/hotel/webDriver", "com/test/framework/hotel/stepDefinition", "com/test/framework/hotel/testRunner"},
		tags = { "~@ignore"},
		plugin = {"pretty", "html:target/cucumber"},
		monochrome = true)
public class TestRunner {
	
	public static Map<String, String> config;
	public static Scenario scenario;
}
