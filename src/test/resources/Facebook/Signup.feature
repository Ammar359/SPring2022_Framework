@signup @regression
Feature: Facebook Sign Up

  Background:
    Given I am on facebook landing page
    When I click on Create New Account button

  @sanity @createNewActBtn
  Scenario: Verify user can sign up
    And I submit Sign up form
    Then I verify account is created

  @sanity @dob
  Scenario: Verify dob on sign up is current date
    Then I verify dob is current date

  @sanity @genderBtn
  Scenario: Verify no gender is selected on Sign Up form
    Then I verify no gender is selected

  Scenario: User cannot submit form without entering all mandatory field
    And I fill form except gender
    And I click on the submit button
    Then I verify error is displayed