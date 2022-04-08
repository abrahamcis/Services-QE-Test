@PUT
Feature: Post users information

  Background: validate a data from a get request
    Given I am working on "QA" environment
    And I am targeting "at-sce-api" service

    @test1 @Regression
  Scenario: I validate PUT method with correct data
    Given I create a new user and return his resourceID
      And I want to Update user by his ResourceID
    And I set up Curriculum to blank
    And I set up user personal info firstName "Alvarado" lastName "Marian55@outlook.com" email "Gozal@gmail.com" phone number "859799889" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user Work Experience
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    When I send a PUT request
    Then I recieve the Json response
    And the status code should be "202"

  @test2
  Scenario: I validate PUT method with incorrect data
    Given I want to retrieve a user by his resourceID "157a6b59-f89a-4a7e-8250-b85"
    And I set up Curriculum to blank
    And I set up user personal info firstName "Alvarado" lastName "Marian55@outlook.com" email "Gozal@gmail.com" phone number "859799889" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user Work Experience
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    When I send a PUT request
    Then I recieve the Json response
    And the status code should be "404"

    @test3 @BUGG
  Scenario: I Validate Put method incorrect json without a required field Education
  Given I create a new user and return his resourceID
    And I want to Update user by his ResourceID
    And I set up Curriculum to blank
    When I set up user personal info firstName "Jose" lastName "Gonzalez" email "GonzalezPeralta@gmail.com" phone number "898989834" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Work Experience
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
      When I send a PUT request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "education"
    And the status code should be "400"

  @test4
  Scenario: I Validate incorrect json without a required field FirstName
    Given I create a new user and return his resourceID
    And I want to Update user by his ResourceID
    When I set up user personal info firstName "" lastName "Gonzalez" email "GonzalezPeralta@gmail.com" phone number "898989834" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Work Experience
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    When I send a PUT request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "firstName"
    And the status code should be "400"

  @test5
  Scenario: I Validate incorrect json without a required field lastName
    Given I create a new user and return his resourceID
    And I want to Update user by his ResourceID
    And I set up Curriculum to blank
    When I set up user personal info firstName "Alvarado" lastName "" email "GonzalezPeralta@gmail.com" phone number "898989834" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Work Experience
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    When I send a PUT request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "lastName"
    And the status code should be "400"

  @test6
  Scenario: I Validate incorrect json without a required field Email
    Given I create a new user and return his resourceID
    And I want to Update user by his ResourceID
    And I set up Curriculum to blank
    When I set up user personal info firstName "Alvarado" lastName "Mariano" email "" phone number "898989834" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Work Experience
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    When I send a PUT request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "email"
    And the status code should be "400"

  @test7
  Scenario: I Validate incorrect json without a required field phoneNumber
    Given I create a new user and return his resourceID
    And I want to Update user by his ResourceID
    And I set up Curriculum to blank
    When I set up user personal info firstName "Alvarado" lastName "Mariano" email "Gozalo@gmail.com" phone number "" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Work Experience
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    When I send a PUT request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "phoneNumber"
    And the status code should be "400"

  @test8
  Scenario: I Validate incorrect json without a required field Languages
    Given I create a new user and return his resourceID
    And I want to Update user by his ResourceID
    And I set up Curriculum to blank
    When I set up user personal info firstName "Alvarado" lastName "Mariano" email "Gozalo@gmail.com" phone number "898786854889" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user Work Experience
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    When I send a PUT request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "languages"
    And the status code should be "400"

  @test9
  Scenario: I Validate incorrect json without a required field Skills
    Given I create a new user and return his resourceID
    And I want to Update user by his ResourceID
    And I set up Curriculum to blank
    When I set up user personal info firstName "Alvarado" lastName "Mariano" email "Gozalo@gmail.com" phone number "67098808008" country "Meixoc" city "Monterrey"
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Work Experience
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    When I send a PUT request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "skills"
    And the status code should be "400"

  @test10 @Bugg
  Scenario: I Validate incorrect json without a required field WorkExperience
    Given I create a new user and return his resourceID
    And I want to Update user by his ResourceID
    And I set up Curriculum to blank
    When I set up user personal info firstName "Alvarado" lastName "Mariano" email "Gozalo@gmail.com" phone number "898989906" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2022" description "eat a lot of tacos" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    When I send a PUT request
    And I recieve the Json response
    Then I validate Json response and missing field should be displaying in response "workexperience"
    And the status code should be "400"

    @test11
  Scenario: I validate PUT method with correct data
      Given I query in the mongoDB an Aleatory document and print it
      And I want to retrieve a user with the mongoDB document
    And I want to Update user by his ResourceID
    And I set up Curriculum to blank
    And I set up user personal info firstName "Alvarado" lastName "flkfdjdlfkjflkd" email "Gozal@gmail.com" phone number "859799889" country "Meixoc" city "Monterrey"
    And I set up user skills
    And I set up user Work Experience
    And I set up user languages Language "English" with a level "Middle"
    And I set up user Education With Bachelor "University" to "2022" forever "none" from "2018"
    And I set up user Challenges date start "2021" description "mermelada" name "Tacos Challenge" url "www.youtube.com"
    And I set up user Config color "blue" font family "comicsan" generic font "italic"
    And I set up user Social Media facebook "String" instagram "String" linkedin "String" pinterest "String" snapchat "String" twitter "String"
    When I send a PUT request
    Then I recieve the Json response
    And the status code should be "202"
      And I validate the RequestBody matches with the BD data