Feature: wex

  Scenario: Movies Test
    Given path movies
    When I call api
    Then verify the api results

  Scenario: Customer Test
    Given path customer with ID 6
    When I call api
    Then verify the api results