@Get
Feature: Get users information

  Background: validate a data from a get request
    Given I am working on "QA" environment
    And I am targeting "at-sce-api" service
  @test1
   Scenario: Validate status response with correct ResourceID
     Given I query in the mongoDB an Aleatory document and print it
     And I want to retrieve a user with the mongoDB document
      And I want to retrieve all users
   When I send a GET request
     Then I get response for GET request
     #Then the status code should be "200"
      And I compare both json response and expect to be similar

  Scenario: Validate status response with Incorrect ResourceID
    #hacer el id dinamico
    And I want to retrieve a user by his resourceID "157a6b59-f89a-4a7e-8250-b8"
    When I send a GET request
    Then I get response for GET request
    Then the status code should be "404"

  Scenario: Validate status response with Empty ResourceID
    And I want to retrieve a user by his resourceID ""
    When I send a GET request
    Then I get response for GET request
    Then the status code should be "404"