  @spamui
Feature: Spam UI Test

  Scenario Outline: Searching for a Text in gov.uk home page
    Given I open Gov.uk home page
    When I search for "<SearchText>"
    Then I am on search result page
    And I should find "<SearchText>" related results
    Examples:
      | SearchText  |
      | Settlement  |
      | Citizen     |
      | HMRC        |
      | DVLA        |
      | Passport    |
      | Europe      |
      | Immigration |
      | Visa        |
