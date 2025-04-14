package com.TalkingParents.Runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com.TalkingParents/Step_Definitions"
)
public class FailedTestRunner{

}

