package com.saucelabs.bddTests.steps;

import com.saucelabs.DriverUtils;
import com.saucelabs.bddTests.pages.InventoryPage;
import com.saucelabs.bddTests.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @When("the user navigates to the Swag Labs login page")
    public void the_user_navigates_to_the_swag_labs_login_page() {
        DriverUtils.driver().get(LoginPage.URL);
        DriverUtils.logScreenshot();
    }

    @When("the user enters the username {string} into the username textbox")
    public void theUserEntersTheUsernameIntoTheUsernameTextbox(String username) {
        loginPage.usernameTextbox.sendKeys(username);
    }

    @And("enters the password {string} into the password textbox")
    public void theUserEntersThePasswordIntoThePasswordTextbox(String password) {
        loginPage.passwordTextbox.sendKeys(password);
    }

    @And("clicks on the login button")
    public void clicksOnTheLoginButton() {
        DriverUtils.logScreenshot();
        loginPage.loginButton.click();
    }

    @Then("the user is navigated to the inventory page")
    public void theUserIsNavigatedToTheInventoryPage() {
        DriverUtils.logScreenshot();
        Assert.assertEquals(DriverUtils.driver().getCurrentUrl(), InventoryPage.URL);
    }

    @Then("the user sees the login failure message {string}")
    public void theUserSeesTheLoginFailureMessage(String message) {
        DriverUtils.logScreenshot();
        Assert.assertEquals(loginPage.errorMessageHeading.getText().trim(), message);
    }
}
