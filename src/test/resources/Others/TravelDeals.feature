Feature: More Travel and Deal Pages

  Background:
    Given I am on www.hotels.com
    When I click on more travel dropdown

  @Sprint-2 @TC-26

  Scenario: Verify 3 offers and offer titles
    And I click on Deals page link
    Then I verify deal offers are enabled and displayed
    And I click on Manage Booking offer
    Then I verify Search, book and Save on the go! heading is displayed
    And I return to previous page
    And I click on Free Cancellation offer
    Then I verify Amazing deals with free cancellation heading is displayed
    And I return to previous page
    And I click on Great Outdoors offer
    Then I verify Save on your next trip to the great outdoors heading is displayed
    And I quit browser