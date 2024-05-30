Feature: Check homepage


  Scenario: Verify homepage title
    Given User visitning webshop
    Then User should see the title "This shop is all you need"