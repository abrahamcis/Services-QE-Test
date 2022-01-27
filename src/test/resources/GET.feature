@Get

Feature: Get users information

  Background:
   Given I am working on "QA" environment
   And I am targeting "PokeAPI" service
    
  Scenario:
  	Given I have a pokemon name 
  	When I send a GET request
  	Then the status code should be "ok"