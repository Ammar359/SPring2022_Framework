Feature: Feedback Form Verification

  Scenario: Verify error is displayed when user submits empty feedback form
    Given I am on www.hotels.com
    When I click on feedback link
    And I click on feedback submit button
    Then I verify empty form submission error is displayed
    Then I verify red dotted border around star rating section



