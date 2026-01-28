Feature: API

  Scenario: Create a new user
    Given base is set
    When I send Post request
    Then status code should be 201
    And print response