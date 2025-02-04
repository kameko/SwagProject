package com.saucelabs.bdd.steps;

import com.saucelabs.DriverUtils;
import com.saucelabs.bdd.pages.CartPage;
import com.saucelabs.bdd.pages.InventoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PurchaseSteps {
    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();

    @When("adds {string} to the cart")
    public void addsToTheCart(String item) {
        inventoryPage.addToCartButton(item).click();
    }

    @And("clicks the shopping cart icon")
    public void clicksTheShoppingCartIcon() {
        inventoryPage.shoppingCartButton.click();
    }

    @Then("verifies the price of product {string} is {string}")
    public void verifiesThePriceOfProductIs(String product, String price) {
        Assert.assertEquals(inventoryPage.getInventoryPagePrice(product), price);
    }

    @And("clicks Checkout")
    public void clicksCheckout() {
        cartPage.checkoutButton.click();
    }

    @And("enters {string} and {string} for first and last names")
    public void entersAndForFirstAndLastNames(String firstName, String lastName) {
        cartPage.firstNameTextbox.sendKeys(firstName);
        cartPage.lastNameTextbox.sendKeys(lastName);
    }

    @And("enters {string} for the zip code")
    public void entersForTheZipCode(String zipcode) {
        cartPage.zipcodeTextbox.sendKeys(zipcode);
    }

    @And("clicks Continue")
    public void clicksContinue() {
        cartPage.continueButton.click();
    }

    @And("clicks Finish")
    public void clicksFinish() {

    }

    @Then("verifies the price of the product is {string}")
    public void verifiesThePriceOfProductIs(String price) {
        Assert.assertEquals(cartPage.checkoutPriceText.getText(), price);
    }

    @Then("verifies the order has been placed")
    public void verifiesTheOrderHasBeenPlaced() {
        Assert.assertEquals(DriverUtils.driver().getCurrentUrl(), CartPage.COMPLETE_URL);
    }
}
