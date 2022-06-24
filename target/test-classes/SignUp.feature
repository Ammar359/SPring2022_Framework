Feature: Sign Up Menu Verification

  Background:
    Given I am on www.hotels.com
    When I click on sign in field

  @Sprint2 @TC-22

  Scenario: Verify invalid data error for sign up form
    And I click on sign up button
    And I enter email #!@### in sign up form
    And I enter first name !@ in sign up form
    And I enter last name %^& in sign up form
    And I enter password qaCareerChange in sign up form
    Then I verify Enter a valid email address sign up error is displayed
    And I verify First name cannot contain special characters sign up error is displayed
    And I verify Last name cannot contain special characters sign up error is displayed
    And I verify that sign up checkbox is enabled and displayed
    And I verify that continue button is displayed and not enabled
    And I quit browser