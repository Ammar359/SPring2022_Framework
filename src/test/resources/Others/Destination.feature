Feature: Destination Booking Verification
  Background:

    Given I am on www.hotels.com
  Scenario: Verify search error is displayed if search with no destination

  @TC-23

  Scenario: Verify search results using star rating and price
    When I click search bar
    And I type destination Manhattan
    And I click on Manhattan from destination suggestion
    And I click on Check In field
    And I select check in date 10 August 2022
    And I select check out date 15 August 2022
    And I click calendar done button
    And I click destination search button
    And I select 5 star rating filter
    Then I verify star filter is correct
    And I verify price filter is correct
    And I quit browser