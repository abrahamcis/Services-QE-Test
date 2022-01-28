@Get

Feature: Get users information

  Background:
   Given I am working on "QA" environment
   And I am targeting "PokeAPI" service

  Scenario:
    Given I have a pokemon name "ditto"
    When I send the GET request with name
    Then the status code should be 200