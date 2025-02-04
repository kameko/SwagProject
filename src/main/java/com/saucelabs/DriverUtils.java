package com.saucelabs;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;

public class DriverUtils {
    static WebDriver driver;
    static Scenario scenario;

    /**
     * Initialize the static WebDriverUtil class.
     * @param scenario The scenario to use.
     */
    public static void init(Scenario scenario) {
        switch (TestProperties.BROWSER) {
            case CHROME:
                var options_chrome = new ChromeOptions();
                if (TestProperties.HEADLESS) {
                    options_chrome.addArguments("--headless");
                }
                DriverUtils.driver = new ChromeDriver(options_chrome);
                break;
            case FIREFOX:
                var options_firefox = new FirefoxOptions();
                if (TestProperties.HEADLESS) {
                    // Firefox's headless argument is just one tick.
                    options_firefox.addArguments("-headless");
                }
                DriverUtils.driver = new FirefoxDriver(options_firefox);
                break;
            case EDGE:
                var options_edge = new EdgeOptions();
                if (TestProperties.HEADLESS) {
                    options_edge.addArguments("--headless");
                }
                DriverUtils.driver = new EdgeDriver(options_edge);
                break;
            case SAFARI:
                var options_safari = new SafariOptions();
                if (TestProperties.HEADLESS) {
                    // Not supported.
                    // options_safari.addArguments("--headless");
                    throw new UnsupportedOperationException("Cannot launch Safari in headless mode");
                }
                DriverUtils.driver = new SafariDriver(options_safari);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(0));

        DriverUtils.scenario = scenario;
    }

    /**
     * Quit the WebDriver.
     */
    public static void quit() {
        driver.quit();
    }

    /**
     * Get the static WebDriver instance.
     *
     * @return The current WebDriver instance.
     */
    public static WebDriver driver() {
        return driver;
    }

    /**
     * Take a screenshot of the current page and log it.
     */
    public static void logScreenshot() {
        final byte[] screenshot = ((TakesScreenshot) DriverUtils.driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Attaching screenshots to reports"); // attach to the report
    }
}
