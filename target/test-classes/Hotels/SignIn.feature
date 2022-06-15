
Feature: SignIn Page Verification

  Scenario: Verify verification message for invalid sign in credentials is displayed
    Given I am on www.hotels.com
    When  I click on sign in button
    And  I click on sign in button
    And  I enter invalid email address <string>
    And  I enter password in sign in form
    And I click sign in button
    Then I verify sign in error is displayed

