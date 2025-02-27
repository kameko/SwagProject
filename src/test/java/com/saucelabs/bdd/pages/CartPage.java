package com.saucelabs.bdd.pages;

public class CartPage {
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

    // Forgive this, it's just a hack I put together while I rushed to make the demo.
    // This is all just to click through the ordering pages to get to the confirmation message.
    public static final String checkoutButtonXPath = "//button[@id='checkout']";
    public static final String firstNameTextboxXPath = "//input[@id='first-name']";
    public static final String lastNameTextboxXPath = "//input[@id='last-name']";
    public static final String zipcodeTextboxXPath = "//input[@id='postal-code']";
    public static final String continueButtonXPath = "//input[@id='continue']";
    public static final String finishButtonXPath = "//button[@id='finish']";
    public static final String checkoutPriceTextXPath = "//div[@class='inventory_item_price']";
}
