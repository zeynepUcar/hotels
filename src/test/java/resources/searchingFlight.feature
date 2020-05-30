Feature: search a flight
  Scenario: searching a flight

    Given Navigate to website
    And Type to "destination"
    And Type to "check-in" and "check-out" date
    And Close the date field
    Then Click on search button