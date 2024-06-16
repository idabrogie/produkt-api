Feature: Remove product from shopping

    Background:
        Given User visiting webshop
        And user clicks on Menu item shop

    Scenario: Checking for empty shopping cart
        And user clicks on add productButton
        And User has clicked on checkoutButton
        When User remove the product from the shopping cart
        Then the product should be removed from shopping cart

    Scenario: Checking for removing only one product from shopping cart
        Given user have added following products in cart
            | Product                              | Quantity   | Price   |
            | Fjallraven                           | 1          | 109,95    |
            | Cotton Jacket                        | 1          |  55,99    |
            | SolGold Petite Micropave             | 1          | 168,00    |
            | Short Sleeve Moisture                | 1          |   7,95    |
        And User has clicked on checkoutButton
        When User remove the product from the shopping cart
        Then the product should be removed from shopping cart and the other product should still be in the shopping cart