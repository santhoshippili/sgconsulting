Feature: Testing Alerts and PopUps

  Scenario: Testing Alerts
    Given I navigate to a Test App
    And I click on Simple Alert button

  Scenario: Testing PopUp Alerts
    Given I navigate to a Test App
    And I click on Simple PopUp button
    And I click "Yes" on the PopUp alert