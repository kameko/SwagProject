Feature: Buy everything from Swag Labs

  @Purchase
  Scenario Outline: Buy one of everything from Swag Labs
    Given the user navigates to the Swag Labs login page
    When the user enters the username "standard_user" into the username textbox
    And enters the password "secret_sauce" into the password textbox
    And clicks on the login button
    And adds "<Item>" to the cart
    And clicks the shopping cart icon
    Then verifies the price of product "<Item>" is "<Price>"
    And clicks Checkout
    And enters "Foxy" and "Pirate" for first and last names
    And enters "00000-88888" for the zip code
    And clicks Continue
    Then verifies the price of the product is "<Price>"
    And clicks Finish
    Then verifies the order has been placed
    Examples:
      | Item                              | Price |
      | Sauce Labs Backpack               | $29.99 |
      | Sauce Labs Bike Light             | $9.99  |
      | Sauce Labs Bolt T-Shirt           | $15.99 |
      | Sauce Labs Fleece Jacket          | $49.99 |
      | Sauce Labs Onesie                 | $7.99  |
      | Test.allTheThings() T-Shirt (Red) | $15.99 |