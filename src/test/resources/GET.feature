@Get

Feature: Get users information

  Background:
   Given I am working on "QA" environment
   And I am targeting "PokeAPI" service

  Scenario Outline:
    Given I have a pokemon name <name>
    When I send the GET request with name
    Then the status code should be <status>
    And I save the response in an object
    Examples:
      | name      | status |
      | "ditto"   | 200    |
      | "pikachu" | 200    |
      | "ekans"   | 200    |
      | "vaporeon"| 200    |
      | "invalid" | 404    |