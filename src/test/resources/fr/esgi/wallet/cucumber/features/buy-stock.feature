@default_stocks
Feature: Buy stock

  Scenario: Buy stock with an empty wallet
    Given an empty wallet
    When I buy a "EUR"
    Then the wallet should contain 1 stocks
    And the stock in the wallet should be "EUR"

  Scenario: Buy stock with wallet containing 2 stocks
    Given a wallet containing a "EUR" and "USD"
    When I buy a "JPY"
    Then the wallet should contain 3 stocks
    And the third one should be equal to "JPY"
