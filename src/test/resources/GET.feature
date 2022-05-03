@Get

Feature: Get users information

  Background:
    Given I am working on "QA" environment
    And I am targeting "at-sce-api" service

    @1 @Bug @Positive
    Scenario: 1 Get a curriculum with an existing ID
      Given I have "4e21eee4-fee1-42a2-9187-0b4531464002" resource ID
      When I send a GET request
      Then the status code should be 200
      And The response is a valid curriculum

