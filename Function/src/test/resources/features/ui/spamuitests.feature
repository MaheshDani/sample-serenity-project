@spamui
Feature: Spam UI Test

  Scenario Outline: Searching for a Text <SearchText> and Findword <FindWord> in gov.uk home page
    Given I open Gov.uk home page
    When I search for "<SearchText>"
    Then I am on search result page
    And I should find "<SearchText>" related results
    Examples:
      | SearchText  | FindWord  |
      | Settlement  | FindWord1 |
      | Citizen     | FindWord2 |
      | HMRC        | FindWord3 |
      | DVLA        | FindWord4 |
      | Passport    | FindWord5 |
      | Europe      | FindWord6 |
      | Immigration | FindWord6 |
      | Visa        | FindWord7 |
