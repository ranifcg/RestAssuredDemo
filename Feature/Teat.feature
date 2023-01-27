#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Rest API tests
  I want to use this to test all API methods
Background: Generate token for authorization
Given I am an authorized user

  Scenario: User is able to create a booking, update a booking and delete a booking
    Given List of bookings are available  
    When I create a booking
    Then Booking is added
    When I update a booking
    Then Booking is updated
    When I delete a booking
    Then Booking is deleted
  