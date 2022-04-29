package com.at.stepdefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json"},
        features = {"src/test/resources"},
        glue = {"com.at.stepdefinitions"},
        tags = {"@Get"})
public class RunCakeTest {
}