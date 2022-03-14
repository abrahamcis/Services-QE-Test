@DELETE
Feature: Post users information

  Background: validate a data from a get request
    Given I am working on "QA" environment
    And I am targeting "at-sce-api" service
    @test1
    Scenario: Delete user by resourceID
      Given I want to retrieve a user by his resourceID "157a6b59-f89a-4a7e-8250-b8f25b75ffec"
      When I send Delete request
      Then the status code should be "200"
    @test2
    Scenario: Delete user by incorrect resourceID
      Given I want to retrieve a user by his resourceID "157a6b59-f89a-4a7e-8250-b8f25b75ffec"
      When I send Delete request
      Then the status code should be "404"