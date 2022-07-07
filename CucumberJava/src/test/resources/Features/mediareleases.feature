Feature: Feature to test the NSW Government media releases for a selected minister

  Scenario Outline: Show media releases filtered by Minister
    Given user is on nsw government media releases page
    When user expands Filter by Minister
    And select a <minister> checkbox from the list
    And click on search button
    Then matching item cards displayed

    Examples: 
      | minister    |
      | The Premier |

  Scenario Outline: Reset filter on media releases
    Given user is on nsw government media releases page
    When user expands Filter by Minister
    And select a <minister> checkbox from the list
    And click on search button
    And click on reset button
    Then all media releases are displayed

    Examples: 
      | minister    |
      | The Premier |
