package com.saucelabs.bdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    InventoryPage inventoryPage = new InventoryPage();

    /**
     * The URL of the checkout cart landing page, which shows an overview of all items in the cart.
     */
    public static final String LANDING_URL = "https://www.saucedemo.com/cart.html";
    /**
     * The URL of the personal information input page of the checkout process.
     */
    public static final String INFORMATION_URL = "https://www.saucedemo.com/checkout-step-one.html";
    /**
     * The URL of the page where the order overview is presented to the user, and the user can give
     * final approval of the order.
     */
    public static final String OVERVIEW_URL = "https://www.saucedemo.com/checkout-step-two.html";
    /**
     * The URL of the page where the user can view their completed order.
     */
    public static final String COMPLETE_URL = "https://www.saucedemo.com/checkout-complete.html";

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement firstNameTextbox;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement lastNameTextbox;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement zipcodeTextbox;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public WebElement checkoutPriceText;
}
