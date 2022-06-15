Feature:


  Background:
    Given I am on www.hotels.com
    When  I type Bora Bora in destination box
    And  I enter checkin and checkout dates
    And  I click search button


  @shareFeedbackDisplayed
  Scenario: Verify share feedback button is displayed for the user
    Then I verify share feedback button is displayed

  @shareFeedbackEnabled
  Scenario: Verify share feedback button is enabled for the user
    Then I verify share feedback button is displayed

  @improveOurSiteTextIsDisplayed
  Scenario: Verify tell us how we can improve our site text is displayed for the user
    Then I verify tell us how we can improve our site text is displayed