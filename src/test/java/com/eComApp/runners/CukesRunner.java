package com.eComApp.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        monochrome=true,
        features = "src/test/resources/features",
        glue = "com/eComApp/steps",
        tags = "@wip",
        dryRun = false,
        publish = true
)
public class CukesRunner {
}
