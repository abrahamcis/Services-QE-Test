@MongoDB

  Feature: user validates data has been successfully added

    @test1
    Scenario: I search the ResourceID in the database to validate if it exist
      Given I set up environment "envi" and database name "db"
      And I set up collection name "Curriculum"
      When I query by field "_id" and value "4ffd0df5-3cbf-4ed0-ab92-a1c0ba5b96ab"
      Then I expect the field "_id" has the value "4ffd0df5-3cbf-4ed0-ab92-a1c0ba5b96ab"

    @test2
    Scenario: I search the ResourceID in the database to validate if it exist
      Given I set up environment "env" and database name "db"
      And I set up collection name "Curriculum"
      When I query by field "_id" and value "6b1f92eb-d107-44d0-978b-c666453a61afjk"
      Then I expect the field "_id" has the value "6b1f92eb-d107-44d0-978b-c666453a61afjk"
      Then I expect the field "email" has the value "Jose@gmail.com"