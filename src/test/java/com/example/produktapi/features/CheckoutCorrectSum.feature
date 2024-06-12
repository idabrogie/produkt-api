Feature: Check for correct sum

  Background:
    Given User visiting webshop
    And user clicks on Menu item shop

  Scenario: Check the cart for the amount
    Given user have added following products in cart
      | Product       | Quantity   | Price   |
      #| <Product>     | <Quantity> | <Price> |
      | Fjallraven                                               | 1          | 109,95    |
      | Cotton Jacket                                     | 1          |  55,99    |
      | SolGold Petite Micropave                                 | 1          | 168,00    |
      | Short Sleeve Moisture                      | 1          |   7,95    |
    And User has clicked on checkoutButton
    Then the amount should be "$341.89"

