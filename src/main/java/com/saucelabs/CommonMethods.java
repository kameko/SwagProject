package com.saucelabs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class CommonMethods {
    /**
     * Select a date on a calendar.
     *
     * @param element The element to select. Must be a calendar.
     * @param date The date (in a string format) to use.
     */
    public static void selectDateByJS(WebElement element, String date) {
        // Given:
        // <input id="dob" name="dob" placeholder="" type="text" class="form-control date" value="" autocomplete="off">
        // The value will be set to the argument.
        JavascriptExecutor js = (JavascriptExecutor) DriverUtils.driver;
        js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);
    }
}
