@Post
Feature: Get users information

  Background:
    Given I am working on "QA" environment
    And I am targeting "at-cv-application-api" service

    @1 @Positive
    Scenario: Create record with all the required parameters.
      Given I have a curriculum request
      And I have a service path
      When I send a create request
      Then the response status code is 201
      And the response body has attribute "resourceId"
      And the curriculum exists in DB

    @2 @Negative
    Scenario: Create record without mandatory attributes.
      Given I have a curriculum request with no mandatory parameters
      And I have a service path
      When I send a create request
      Then the response status code is 400
      And the response body has attribute "statusMessage"
      And the response body has attribute "errorDetails"
      And the "education" field has error "This field is mandatory"
      And the "education" field has error "This field must contain information"
      And the "email" field has error "This field is mandatory"
      And the "email" field has error "This field must contain information"
      And the "email" field has error "This field cannot be blank"
      And the "firstName" field has error "This field is mandatory"
      And the "firstName" field has error "This field must contain information"
      And the "firstName" field has error "This field cannot be blank"
      And the "lastName" field has error "This field is mandatory"
      And the "lastName" field has error "This field must contain information"
      And the "lastName" field has error "This field cannot be blank"
      And the "languages" field has error "This field is mandatory"
      And the "languages" field has error "This field must contain information"
      And the "phoneNumber" field has error "This field is mandatory"
      And the "phoneNumber" field has error "This field must contain information"
      And the "phoneNumber" field has error "This field cannot be blank"
      And the "skills" field has error "This field is mandatory"
      And the "skills" field has error "This field must contain information"
      And the "workexperience" field has error "This field is mandatory"
      And the "workexperience" field has error "This field must contain information"
      And the "workexperience" field has error "This field cannot be blank"

    @3 @Positive
    Scenario: Create record only with the mandatory parameters.
      Given I have a curriculum request with mandatory parameters only
      And I have a service path
      When I send a create request
      Then the response status code is 201
      And the response body has attribute "resourceId"

    @4 @Positive
    Scenario: Create record with a challenge containing date and description but no name nor url.
      Given I have a curriculum request with required parameters where challenge contains date and description only
      And I have a service path
      When I send a create request
      Then the response status code is 201
      And the response body has attribute "resourceId"

    @5 @Positive
    Scenario: Create record with an education containing all education parameters except for name.
      Given I have a curriculum request with required parameters where education contains all fields but name
      And I have a service path
      When I send a create request
      Then the response status code is 201
      And the response body has attribute "resourceId"

    @6 @Positive
    Scenario: Create record with string parameters containing special characters (!#$%&/).
      Given I have a curriculum request with required parameters where string fields are all special characters
      And I have a service path
      When I send a create request
      Then the response status code is 201
      And the response body has attribute "resourceId"

    @7 @Negative
    Scenario: Create record with language parameter containing an empty list.
      Given I have a curriculum request with required parameters where language contains an empty list
      And I have a service path
      When I send a create request
      Then the response status code is 400
      And the response body has attribute "statusMessage"
      And the response body has attribute "errorDetails"

    @8 @Negative
    Scenario: Create record by sending an empty object.
      Given I have a request with an empty curriculum
      And I have a service path
      When I send a create request
      Then the response status code is 400
      And the response body has attribute "statusMessage"
      And the response body has attribute "errorDetails"

    @9 @Positive
    Scenario: Create record with an existing resourceId.
      Given I have a curriculum request with an existing resourceId
      And I have a service path
      When I send a create request
      Then the response status code is 201
      And the response body has attribute "resourceId"

    @10 @Positive
    Scenario: Create record with very long strings.
      Given I have a curriculum request with very long strings
      And I have a service path
      When I send a create request
      Then the response status code is 201
      And the response body has attribute "resourceId"