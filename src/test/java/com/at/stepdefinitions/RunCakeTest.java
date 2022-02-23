package com.at.stepdefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
        features = {"./src/test/resources/"},
        glue = {"com.at.stepdefinitions"},
        tags = "@Get",
        monochrome = false)
public class RunCakeTest {
}
