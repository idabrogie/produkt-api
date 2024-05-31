Feature: Search for product on webpage

  Scenario: As a user search for product on webpage find true
      Given User visiting webshop
      When User clicks on Meny item "Shop"
      And User search for product "WD" on webpage
      Then User can see the search product and expect 2 products


  Scenario: As a user search for product on webpage find false
    Given User visiting webshop
    When User clicks on Meny item "Shop"
    And User search for product "Elefant" on webpage
    Then Result should be an empty main