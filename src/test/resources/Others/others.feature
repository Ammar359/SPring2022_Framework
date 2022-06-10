@others @regression
Feature: Other Automation scenarios

  @guru99
  Scenario: Verify customer is deleted msg is displayed on guru99
    Given I am on Guru landing page
    When I enter the customer id as 100
    And I click on Submit button
    Then I verify 'Customer Successfully Delete!' is displayed