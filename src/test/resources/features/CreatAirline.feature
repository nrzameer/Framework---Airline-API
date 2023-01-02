@CreateAirline
Feature: To create Airline
  I want to this feature to create the airline for the given test data

  @Smoke
  Scenario: Verify that user is able to create a airline
    Given I create a request for creation of airport
    | 33333456 | 
    | Roshan | 
    | India   | 
    | Star | 
    | Fly High | 
    | India      | 
    | https://qacrunch.com |
    | 1986|
    
    And I hit the post request for createAirline API
    Then I should see the airline is created successfully with success code

  Scenario: 
    Given I create a request for creation of airport
    When I enter the already existing data
    Then I should get the error message
