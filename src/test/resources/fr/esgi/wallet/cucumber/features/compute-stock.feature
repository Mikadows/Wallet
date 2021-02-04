Feature: Compute stock

  Scenario: Compute Dollar stock in euro
    Given a "EURO" currency rate at 2
    And the stock "DOLLAR" 5
    When I compute the stock value
    Then I should have a computed stock value at 10

  Scenario: Compute euro stock in yen
    Given a "YEN" currency rate at 100
    And the stock "DOLLAR" 5
    When I compute the stock value
    Then I should have a computed stock value at 500

#  Scenario: Compute stock with error #not simple to implement
#    Given no currency
#    And the stock "DOLLAR" 5
#    When I compute the stock value
#    Then an error should be thrown