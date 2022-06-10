
Feature: SignUp Page
  Scenario: Verify Terms and condition link and Privacy statement link opens in new tab


    Given I am on Hotels main page
    When  I click sign in button
    And  I click on sign in button

  @termsAndConditions
  Scenario: Verify Terms And Conditions link open correct page on new tab
    And I click on privacy page link
    Then I verify that link opened privacy page
    Then I close privacy page


  @privacyStatements
  Scenario: Verify Privacy Statements link open correct page on new tab
    And I click on terms and conditions page link
    Then I verify that it is a correct page