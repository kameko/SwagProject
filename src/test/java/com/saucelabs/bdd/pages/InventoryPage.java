package com.saucelabs.bdd.pages;

import com.saucelabs.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class InventoryPage {
    public static final String shoppingCartLocator = "//a[@class='shopping_cart_link']";

    public static final String URL = "https://www.saucedemo.com/inventory.html";

    Map<String, Product> products;

    @FindBy(xpath = shoppingCartLocator)
    public WebElement shoppingCartButton;

    public InventoryPage() {
        products = Map.of(
                "Sauce Labs Backpack", new Product("sauce-labs-backpack", "$29.99"),
                "Sauce Labs Bike Light", new Product("sauce-labs-bike-light", "$9.99"),
                "Sauce Labs Bolt T-Shirt", new Product("sauce-labs-bolt-t-shirt", "$15.99"),
                "Sauce Labs Fleece Jacket", new Product("sauce-labs-fleece-jacket", "$49.99"),
                "Sauce Labs Onesie", new Product("sauce-labs-onesie", "$7.99"),
                "Test.allTheThings() T-Shirt (Red)", new Product("test.allthethings()-t-shirt-(red)", "$15.99")
        );
        PageFactory.initElements(DriverUtils.driver(), this);
    }

    /**
     * Get the price of the given item.
     * @param product The item in the inventory.
     * @return The price of the item.
     */
    public String getProductPrice(String product) {
        return products.get(product).price;
    }

    /**
     * If a given product is in the inventory, get it's "Add to cart" button.
     * @param product The name of the product to get the "Add to cart" button of.
     * @return The "Add to cart" button of the given product.
     */
    public WebElement addToCartButton(String product) {
        // //button[@id='add-to-cart-sauce-labs-backpack']
        // //button[@id='add-to-cart-sauce-labs-backpack']/preceding-sibling::div[@class='inventory_item_price']
        var item = products.get(product);
        return DriverUtils.driver().findElement(By.xpath(item.formatAddToCartLocator()));
    }

    /**
     * Get the price of the given item from the web page (*not* the database!)
     * @param product The product to fetch.
     * @return The price of the item from the web page.
     */
    public String getInventoryPagePrice(String product) {
        var item = products.get(product);
        var elm = DriverUtils.driver().findElement(By.xpath(item.formatPriceLocator()));
        return elm.getText();
    }

    /**
     * Get the price of the given item from the web page (*not* the database!) after it's been removed
     * @param product The product to fetch.
     * @return The price of the item from the web page.
     */
    public String getRemovedInventoryPagePrice(String product) {
        var item = products.get(product);
        var elm = DriverUtils.driver().findElement(By.xpath(item.formatRemovedPriceLocator()));
        return elm.getText();
    }

    static class Product {
        public String addToCartLocator;
        public String price;

        public Product(String loc, String price) {
            this.addToCartLocator = loc;
            this.price = price;
        }

        public String formatAddToCartLocator() {
            return "//button[@id='add-to-cart-" + addToCartLocator + "']";
        }

        public String formatRemoveLocator() {
            return "//button[@id='remove-" + addToCartLocator + "']";
        }

        public String formatPriceLocator() {
            return formatAddToCartLocator() + "/preceding-sibling::div[@class='inventory_item_price']";
        }

        public String formatRemovedPriceLocator() {
            return formatRemoveLocator() + "/preceding-sibling::div[@class='inventory_item_price']";
        }
    }
}
