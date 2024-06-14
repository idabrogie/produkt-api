Feature: Search for product on webpage

  Background:
    Given User visiting webshop
    When User clicks on Meny item "Shop"

  #Scenario: As a user search for product on webpage find true
  #  And User search for product "WD"
  #  Then User can see the search product and expect 2 products


  Scenario: As a user search for product on webpage find false
    And User search for product "Elefant"
    Then Result should be an empty main