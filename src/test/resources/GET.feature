@Get

Feature: Get users information

  Background:
    Given I am working on "QA" environment
    And I am targeting "at-sce-api" service


@US_001 @1
  Scenario: Get all users
  Given I want to retrieve all users
  When I send a GET request
  Then the status code should be "200"
  And information retrieved from service should match with DB