@MongoDB

  Feature: user validates data has been successfully added

    Scenario: I search the ResourceID in the database to validate if it exist
      Given I set up environment "env" and database name "db"
      And I set up collection name "Curriculum"
      When I query by field "resourceId" and value "6b1f92eb-d107-44d0-978b-c666453a61af"
      Then I expect the field "resourceId" has the value "6b1f92eb-d107-44d0-978b-c666453a61af"