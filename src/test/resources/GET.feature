@Get
Feature: Get users information

  Background: validate a data from a get request
    Given I am working on "QA" environment
    And I am targeting "at-sce-api" service

   Scenario: Validate status response with correct ResourceID
   Given I want to retrieve a user by his resourceID "157a6b59-f89a-4a7e-8250-b8f25b75ffec"
   When I send a GET request
     Then I get response for GET request
     Then the status code should be "200"

  Scenario: Validate status response with Incorrect ResourceID
    And I want to retrieve a user by his resourceID "157a6b59-f89a-4a7e-8250-b8"
    When I send a GET request
    Then I get response for GET request
    Then the status code should be "404"

  Scenario: Validate status response with Empty ResourceID
    And I want to retrieve a user by his resourceID ""
    When I send a GET request
    Then I get response for GET request
    Then the status code should be "404"