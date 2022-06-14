@login @regression
Feature: Facebook login
# Feature name

  # section of feature file that will run before every scenario of this feature-file
  # Background section will be executed before every scenario of this feature file
  Background:
    Given I am on facebook landing page

#  # Scenario name
#  @sanity @invalidLogin
#  Scenario: Verify user cannot login with invalid credentials
#    # steps (Gherkin steps)
#    When I enter $%^&*( in login username
#      And I enter abcd@1234 in login password
#      And I click on login button
#    Then I verify error is displayed
#
#  @sanity @invalidLogin2
#  Scenario: Verify user cannot login with invalid credentials2
#    When I enter var@gmail.com in login username
#    And I enter valkdfjklsdhfkljsdhf;s@1234 in login password
#    And I click on login button
#    Then I verify error is displayed

  @sanity @invalidLogins @ddtLogin
  Scenario Outline: Verify user cannot login with invalid credentials
    When I enter <username> in login username
    And I enter <password> in login password
    And I click on login button
    Then I verify error is displayed
    Examples:
      | username      | password                    |
      | $%^&*(        | abcd@1234                   |
      | var@gmail.com | valkdfjklsdhfkljsdhf;s@1234 |
      | var@test.com  | abcdNoPwd                   |


  # Comment in feature file
  # valid user credentials are not available.
  @validLogin
  Scenario: Verify user can login with valid credentials
    When I enter validUser@gmail.com in login username
    And I enter validPass@1234 in login password
    And I click on login button
    Then I verify Facebook Homepage is displayed

  @emptyLogin
  Scenario: Verify user cannot login with empty credentials
    And I click on login button
    Then I verify error is displayed

