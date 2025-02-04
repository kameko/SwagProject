package com.saucelabs.bdd.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.saucelabs.bdd.steps", "com.saucelabs.bdd.hooks"},
        plugin = "html:target/reports/first.html",
        dryRun = false
)
public class LoginRunner extends AbstractTestNGCucumberTests {
}
