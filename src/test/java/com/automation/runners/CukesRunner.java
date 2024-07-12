package com.automation.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {},
        features = "src/test/resources/features",
        glue = "com/automation/stepDefinitions",
        tags = "@smoke",
        dryRun = false,
        publish = true
)
public class CukesRunner {
}
