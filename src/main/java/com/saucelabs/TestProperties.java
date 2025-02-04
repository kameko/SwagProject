package com.saucelabs;

public class TestProperties {
    /**
     * Which web browser to use in this test.
     */
    public static final BrowserChoice BROWSER = BrowserChoice.CHROME;

    /**
     * If the browser should run in headless mode.
     */
    public static final Boolean HEADLESS = false;

    /**
     * Allows selecting a web browser to use to test with.
     */
    public enum BrowserChoice {
        /**
         * Use Google Chrome.
         */
        CHROME,
        /**
         * Use Mozilla Firefox.
         */
        FIREFOX,
        /**
         * Use Microsoft Edge.
         */
        EDGE,
        /**
         * Use Apple Safari.
         */
        SAFARI,
    }
}
