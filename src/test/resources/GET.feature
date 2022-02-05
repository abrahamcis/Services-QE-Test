@Get

Feature: Get users information

  Background:
    Given I am working on "QA" environment
    And I am targeting "PokeApi" service

    @test
    Scenario: Get Ditto Information
      Given I want to retrieve "ditto" information
      When I send a GET request
      And the status code should be "200"
      And I build the response object



