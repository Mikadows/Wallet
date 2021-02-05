@default_stocks
Feature: Sell stock

  Scenario: Sell stock of an empty wallet
    Given a vacant wallet
    When I sell "EUR" stock of my wallet in currency "EURO"
    Then I should have 0 stocks in my wallet
    And I should receive 0 "EURO"

  Scenario: Sell a euro stock
    Given a wallet containing "EUR" and "USD"
    When I sell "EUR" stock of my wallet in currency "EURO"
    Then I should have 1 stocks in my wallet
    And I should receive 10 "EURO"

  Scenario: Sell an vacant wallet
    Given a vacant wallet
    And a currency "EURO" rate at 2
    When I sell the wallet content
    Then I should have 0 stocks in my wallet
    And I should receive 0 "EURO"

  Scenario: Sell a wallet with 3 stocks
    Given a wallet containing "USD" "JPY" and "CAD"
    And a currency "EURO" rate at 2
    When I sell the wallet content
    Then I should have 0 stocks in my wallet
    And I should receive 32 "EURO"

