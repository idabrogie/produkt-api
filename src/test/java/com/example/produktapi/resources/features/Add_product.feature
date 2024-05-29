Feature: Test add product function


  Scenario: Verify homepage title
    Given User enters website
    Then User should see the title "This shop is all you need"

  Scenario: As a user add a product to cart
    Given user is on webpage
    When user clicks on add productbutton
    Then a product