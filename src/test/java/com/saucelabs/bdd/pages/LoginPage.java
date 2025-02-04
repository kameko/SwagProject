package com.saucelabs.bdd.pages;

import com.saucelabs.DriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static final String URL = "https://www.saucedemo.com/";

    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement usernameTextbox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextbox;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessageHeading;

    public LoginPage() {
        PageFactory.initElements(DriverUtils.driver(), this);
    }
}
