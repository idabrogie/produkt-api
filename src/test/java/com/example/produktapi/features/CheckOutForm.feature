
Feature: User wants to checkout shopcart

  Background:
    Given there are items in the shopCart
    And the user is on CheckoutPage

  Scenario: Form is missing data
    When user does not fill in the form
    And user clicks the continue to checkout-button
    Then the user cannot continue to checkout