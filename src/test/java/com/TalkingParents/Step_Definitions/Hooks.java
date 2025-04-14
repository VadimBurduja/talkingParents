package com.TalkingParents.Step_Definitions;

import com.TalkingParents.Utilities.ConfigurationReader;
import com.TalkingParents.Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.time.Duration;

public class Hooks {
    @Before()
    public void setUp() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("TalkingParentsUrl"));
    }

    @After()
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
           final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

}
