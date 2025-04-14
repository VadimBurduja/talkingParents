package com.TalkingParents.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",              // Feature files
        glue = "com.TalkingParents.Step_Definitions",          // Step Definitions
        dryRun = false,                                        // True: checks steps only
        tags = "",                                       // You can change to @regression, etc.
        publish = true                                         // Publishes to reports.cucumber.io
)
public class CukesRunner {
}
