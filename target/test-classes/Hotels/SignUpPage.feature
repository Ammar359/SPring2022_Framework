
Feature: SignUp Page
  Scenario: Verify Terms and condition link and Privacy statement link opens in new tab


    Given I am on www.hotels.com
    When  I click sign in button
    And  I click on sign in button

    @SignUp

      Scenario:Verify error message for invalid data in SignUp form
      Given I am on www.hotels.com
      When I click on sign in field
      And I click sign in button

  @termsAndConditions
  Scenario: Verify Terms And Conditions link open correct page on new tab
    And I click on privacy page link
    Then I verify that link opened in new tab
    Then I close privacy page


  @privacyStatements
  Scenario: Verify Privacy Statements link open correct page on new tab
    And I click on terms and conditions page link
    Then I verify that it is a correct page