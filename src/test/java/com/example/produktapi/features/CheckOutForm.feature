
Feature: User wants to checkout shopcart

  Background:
    Given there are items in the shopCart
    And User has clicked on checkoutButton

  Scenario: Form is missing data
    When user clicks the continue to checkout-button without filling out the form
    Then the user gets validation errors and cant continue
    And the user is still on checkout page

  Scenario: when user fills out the form correct
    When the user fill out the form
    And clicks on the continue button
    Then the user should be redirected to https://webshop-agil-testautomatiserare.netlify.app/checkout?paymentMethod=on