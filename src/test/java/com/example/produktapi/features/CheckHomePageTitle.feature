Feature: Check homepage


  Scenario: Verify homepage title
    Given User visiting webshop
    Then User should see the title "This shop is all you need"