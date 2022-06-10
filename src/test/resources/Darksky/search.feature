@searchDarkSky @regression
Feature: Search

#  Scenario: Verify user can search temperature using zipcode
#    Given I am on darksky landing page
#    When I search temperature using 10010
#    Then I verify forecast is displayed
#
#  Scenario: Verify user can search temperature using full address
#    Given I am on darksky landing page
#    When I search temperature using 98 11th Ave, New York, NY
#    Then I verify forecast is displayed
#
#  Scenario: Verify user can search temperature using country name
#    Given I am on darksky landing page
#    When I search temperature using Brazil
#    Then I verify forecast is displayed

  @ddtDarksky @search
  Scenario Outline: Verify user can search temperature using <dataType>
    Given I am on darksky landing page
    When I search temperature using <dataValue>
    Then I verify forecast is displayed for <dataType>
    Examples:
      | dataType     | dataValue                 |
      | zipcode      | 10010                     |
      | country name | Brazil                    |
      | full address | 98 11th Ave, New York, NY |