@default_stocks
Feature: Compute wallet

  Scenario: Compute wallet in euro
    Given a wallet containing a "USD" and "JPY" stocks
    And "EURO" currency rate at 2
    When I compute the wallet value
    Then I should have a computed wallet value at 24 "EURO"

  Scenario: Compute an empty wallet in euro
    Given "EURO" currency rate at 2
    And an empty wallet.
    When I compute the wallet value
    Then I should have a computed wallet value at 0 "EURO"
