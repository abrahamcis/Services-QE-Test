package com.at.stepdefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json"},
        features = {"src/test/resources"},
        glue = {"com.at.stepdefinitions"},
        tags = "@Positive and @1")
public class RunCakeTest {
}