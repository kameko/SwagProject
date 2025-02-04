package com.saucelabs.bdd.steps;

import com.saucelabs.DriverUtils;
import com.saucelabs.bdd.pages.CartPage;
import com.saucelabs.bdd.pages.InventoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PurchaseSteps {
    InventoryPage inventoryPage = new InventoryPage();

    @When("adds {string} to the cart")
    public void addsToTheCart(String item) {
        inventoryPage.addToCartButton(item).click();
    }

    @And("clicks the shopping cart icon")
    public void clicksTheShoppingCartIcon() {
        var elm = DriverUtils.driver().findElement(By.xpath(InventoryPage.shoppingCartLocator));
        elm.click();
    }

    @Then("verifies the price of product {string} is {string}")
    public void verifiesThePriceOfProductIs(String product, String price) {
        DriverUtils.logScreenshot();
        Assert.assertEquals(inventoryPage.getRemovedInventoryPagePrice(product), price);
    }

    @And("clicks Checkout")
    public void clicksCheckout() {
        var elm = DriverUtils.driver().findElement(By.xpath(CartPage.checkoutButtonXPath));
        elm.click();
    }

    @And("enters {string} and {string} for first and last names")
    public void entersAndForFirstAndLastNames(String firstName, String lastName) {
        var elm1 = DriverUtils.driver().findElement(By.xpath(CartPage.firstNameTextboxXPath));
        elm1.sendKeys(firstName);
        var elm2 = DriverUtils.driver().findElement(By.xpath(CartPage.lastNameTextboxXPath));
        elm2.sendKeys(lastName);
    }

    @And("enters {string} for the zip code")
    public void entersForTheZipCode(String zipcode) {
        var elm = DriverUtils.driver().findElement(By.xpath(CartPage.zipcodeTextboxXPath));
        elm.sendKeys(zipcode);
    }

    @And("clicks Continue")
    public void clicksContinue() {
        var elm = DriverUtils.driver().findElement(By.xpath(CartPage.continueButtonXPath));
        elm.click();
    }

    @And("clicks Finish")
    public void clicksFinish() {
        var elm = DriverUtils.driver().findElement(By.xpath(CartPage.finishButtonXPath));
        elm.click();
    }

    @Then("verifies the price of the product is {string}")
    public void verifiesThePriceOfProductIs(String price) {
        DriverUtils.logScreenshot();
        var elm = DriverUtils.driver().findElement(By.xpath(CartPage.checkoutPriceTextXPath));
        Assert.assertEquals(elm.getText(), price);
    }

    @Then("verifies the order has been placed")
    public void verifiesTheOrderHasBeenPlaced() {
        DriverUtils.logScreenshot();
        Assert.assertEquals(DriverUtils.driver().getCurrentUrl(), CartPage.COMPLETE_URL);
    }
}
