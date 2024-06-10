
Feature: User wants to checkout shopcart

  Background:
    Given there are items in the shopCart
    And the user is on CheckoutPage

  Scenario: Form is missing data
    When user clicks the continue to checkout-button without filling out the form
    Then the user gets validation errors and cant continue
    And the user is still on checkout page