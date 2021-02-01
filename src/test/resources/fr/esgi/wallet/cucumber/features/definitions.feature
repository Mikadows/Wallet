Feature: Definitions

  @default_stocks
  Scenario: Default stocks
    Then the available stocks should be at least:
      | stockType | quantity |
      | EURO      | 5        |
      | DOLLAR    | 2        |
      | YEN       | 10       |
