@MenuList
Feature: MenuList feature on Selenium Easy webapplication
  
  @InputForms
  Scenario: Input Forms scenario
    Given user is on Selenium Easy
    And user navigates to Simple form
    When user inputs Message "Raju Krish is a great guy"
    And user clicks on the Show Message
    Then validate the user Message
    

