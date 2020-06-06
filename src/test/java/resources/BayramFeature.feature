Feature: Filtering the search
  Background:
    Given Navigate to website
    And Type to "destination"
    And Type to "check-in" and "check-out" date
    And Close the date field
    Then Click on search button

    Scenario:
      When move the sliders as you desired
      Then the prices found has to be in the range



