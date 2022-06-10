
Feature: SignIn Page Verification

  Scenario: Verify verification message for invalid sign in credentials is displayed
    Given I am on Hotels Landing page
    When  I click on sign in button
    And  I click on sign in button
    And  I enter email in sign in form
    And  I enter password in sign in form
    And I click sign in button
    Then I verify sign in error is displayed

