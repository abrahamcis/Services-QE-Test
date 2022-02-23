@Get

Feature: Get users information

  Background: validate a data from a get request
    Given I am working on "QA" environment
    And I am targeting "at-sce-api" service

   Scenario: test
   And I want to retrieve a user by his resourceID "157a6b59-f89a-4a7e-8250-b8f25b75ffec"
   When I send a GET request
     Then I get response for GET request