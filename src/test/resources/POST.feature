@POST
Feature: Post users information

  Background: validate a data from a get request
    Given I am working on "QA" environment
    And I am targeting "at-sce-api" service

    @test1
  Scenario: Validate status response with required properties
    Given I want to Post a new client
    When I set up user personal info firstName "Jose" lastName "Gonzalez" email "GonzalezPeralta@gmail.com" phone number "898989834" country "Meixoc" city "Monterrey"
      And I set up user skills
      And I set up user languages Language "English" with a level "Middle"
      And I set up user Work Experience
      And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
      And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
      And I set up user Config color "blue" font family "comicsan" generic font "italic"
      And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
      And I send the Curriculum in a POST request
    Then the status code should be "201"
      And I validate the ResourceID has been created in the database
      And I validate the RequestBody matches with the BD data

  @test2
    Scenario: Validate status response without a required field
      Given I want to Post a new client
      When I send the invalid Post request
        And I send the invalid Post request
        And I get a invalid Json response
      Then the status code should be "400"

  @test3
    Scenario: I Validate incorrect json without a required field Education
      Given I want to Post a new client
      And I set up Curriculum to blank
    When I set up user personal info firstName "Jose" lastName "Gonzalez" email "GonzalezPeralta@gmail.com" phone number "898989834" country "Meixoc" city "Monterrey"
      And I set up user skills
      And I set up user languages Language "English" with a level "Middle"
      And I set up user Work Experience
      And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
      And I set up user Config color "blue" font family "comicsan" generic font "italic"
      And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
      And I send the Curriculum in a POST request
      And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "education"
      And the status code should be "400"

  @test4
  Scenario: I Validate incorrect json without a required field FirstName
    Given I want to Post a new client
      And I set up Curriculum to blank
    When I set up user personal info firstName "" lastName "Gonzalez" email "GonzalezPeralta@gmail.com" phone number "898989834" country "Meixoc" city "Monterrey"
      And I set up user skills
      And I set up user languages Language "English" with a level "Middle"
      And I set up user Work Experience
      And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
      And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
      And I set up user Config color "blue" font family "comicsan" generic font "italic"
      And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
      And I send the Curriculum in a POST request
      And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "firstName"
      And the status code should be "400"

  @test5
  Scenario: I Validate incorrect json without a required field lastName
    Given I want to Post a new client
    And I set up Curriculum to blank
    When I set up user personal info firstName "Alvarado" lastName "" email "GonzalezPeralta@gmail.com" phone number "898989834" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Work Experience
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    And I send the Curriculum in a POST request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "lastName"
    And the status code should be "400"

  @test6
  Scenario: I Validate incorrect json without a required field Email
    Given I want to Post a new client
    And I set up Curriculum to blank
    When I set up user personal info firstName "Alvarado" lastName "Mariano" email "" phone number "898989834" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Work Experience
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    And I send the Curriculum in a POST request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "email"
    And the status code should be "400"

  @test7
  Scenario: I Validate incorrect json without a required field phoneNumber
    Given I want to Post a new client
    And I set up Curriculum to blank
    When I set up user personal info firstName "Alvarado" lastName "Mariano" email "Gozalo@gmail.com" phone number "" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Work Experience
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    And I send the Curriculum in a POST request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "phoneNumber"
    And the status code should be "400"

  @test8
  Scenario: I Validate incorrect json without a required field Languages
    Given I want to Post a new client
    And I set up Curriculum to blank
    When I set up user personal info firstName "Alvarado" lastName "Mariano" email "Gozalo@gmail.com" phone number "898786854889" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user Work Experience
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    And I send the Curriculum in a POST request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "languages"
    And the status code should be "400"

  @test9
  Scenario: I Validate incorrect json without a required field Skills
    Given I want to Post a new client
    And I set up Curriculum to blank
    When I set up user personal info firstName "Alvarado" lastName "Mariano" email "Gozalo@gmail.com" phone number "67098808008" country "Meixoc" city "Monterrey"
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Work Experience
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    And I send the Curriculum in a POST request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "skills"
    And the status code should be "400"

  @test10 @Bugg
  Scenario: I Validate incorrect json without a required field WorkExperience
    Given I want to Post a new client
    And I set up Curriculum to blank
    When I set up user personal info firstName "Alvarado" lastName "Mariano" email "Gozalo@gmail.com" phone number "898989906" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    And I send the Curriculum in a POST request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "workexperience"
    And the status code should be "400"

  @test11 @Bugg
  Scenario: I Validate no incorrect data format in personal data should be Post
    Given I want to Post a new client
      And I set up Curriculum to blank
      And I set up user personal info firstName "Alvarado45" lastName "Marian55@o" email "Gozal@gmail.co" phone number "898786854rrf@889" country "Meixoc" city "Monterrey"
      And I set up user skills
      And I set up user Work Experience
      And I set up user languages Language "English" with a level "Middle"
      And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
      And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
      And I set up user Config color "blue" font family "comicsan" generic font "italic"
      And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    When I send the Curriculum in a POST request
    Then I recieve the Json response
      And the status code should be "400"

  @test12 @Regression
  Scenario: I Validate a complete json with Post
    Given I want to Post a new client
    And I set up Curriculum to blank
    And I set up user personal info firstName "Alvarado" lastName "Marian55@outlook.com" email "Gozal@gmail.com" phone number "859799889" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user Work Experience
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    When I send the Curriculum in a POST request
    Then I recieve the Json response
    And the status code should be "200"