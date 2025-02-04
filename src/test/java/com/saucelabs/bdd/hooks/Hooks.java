package com.saucelabs.bdd.hooks;

import com.saucelabs.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void start(Scenario scenario) {
        DriverUtils.init(scenario);
    }

    @After
    public void stop() {
        DriverUtils.quit();
    }
}
