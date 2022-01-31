@Get

Feature: Get users information

  Background:
   Given I am working on "QA" environment
   And I am targeting "PokeAPI" service

  Scenario Outline:
    Given I have a pokemon name <name>
    When I send the GET request with name
    And I save the response in an object
    Then the status code should be 200
    Examples:
      | name      |
      | "ditto"   |
      | "pikachu" |
      | "ekans"   |
      | "vaporeon"|
