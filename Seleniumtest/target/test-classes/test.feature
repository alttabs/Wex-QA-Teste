Feature: wex

  Scenario: WEX Brazil QA Test
    Given I navigate to “www.amazon.com”.
    When I select the option “Books” in the dropdown next to the search text input criteria.
    Then I search for “Test automation”.
    And I select the cheapest book of the page without using any sorting method available.
    When I reach the detailed book page, I check if the name in the header is the same name of the book that I select previously.