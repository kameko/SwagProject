package com.saucelabs.bddTests.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.saucelabs.bddTests.steps", "com.saucelabs.bddTests.hooks"},
        plugin = "html:target/reports/first.html",
        dryRun = false
)
public class FirstTest extends AbstractTestNGCucumberTests {
}
