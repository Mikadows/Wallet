# BDD - Projet - Wallet

Gwendal SIWIOREK - Étudiant 4AL1

## Sujet

Given a Wallet containing Stocks, build a function that compute the value of wallet in a currency. 

The Stocks have a quantity and a StockType. The StockType can be for example petroleum, Euros, bitcoins and Dollars. 

To value the portfolio in a Currency you can use external api to provide rate exchanges



## Scenarios

### Feature : Compute stock value

As a user I want compute my stock in another currency



<u>RULES :</u> 

* The stock value can be computed in a  given currency rate
* The stock computed value is the stock value multiplied by the currency rate



* <u>Scenario 1</u>

**GIVEN** a euro currency rate at 2

**AND** a wallet containing a dollar stock with value 5

**WHEN** I compute the stock value

**THEN** I should have a computed stock value at 10

* <u>Scenario 2</u>

**GIVEN** no currency

**AND** a wallet containing a dollar stock with value 5

**WHEN** I compute the stock value

**THEN** an error should be thrown



### Feature : Compute wallet value

As a user I want to compute my wallet value in a given currency rate. The wallet value is the addition of all stocks computed values. 



<u>RULES :</u> 

* The wallet value can be computed in a given currency
* The wallet value is the addition of all sotcks values



* <u>Scenario 1</u>

**GIVEN** a wallet containing two Stocks (5, USD), (10, JPY)

**AND** a currency euro rate at 2

**WHEN** when I compute the value of the wallet

**THEN** I should have a wallet value at 30 euros

* <u>Scenario 2</u>

**GIVEN** an empty wallet

**AND** a currency euro rate at 2

**WHEN** when I compute the value of the wallet

**THEN** I should have a wallet value at 0 euros

* <u>Scenario 3</u>

**GIVEN** an empty wallet

**AND** no currenct

**WHEN** when I compute the value of the wallet

**THEN** an error should be thrown

* <u>Scenario 4</u>

**GIVEN** a wallet containing two Stocks (5, USD), (10, JPY)

**AND** no currenct

**WHEN** when I compute the value of the wallet

**THEN** an error should be thrown



### Feature :  Buy a stock 

As a user I want to buy a Stock and add it to my Wallet.



<u>RULES :</u>

* A valid stock contain a value in a given currency
* When a user buy a stock, the stock is added to the user wallet 



* <u>Scenario 1</u>

**GIVEN** an empty wallet

**WHEN** I buy a "EUR" 

**THEN** the wallet should contain 1 stocks

**AND** the stock in the wallet should be "EUR"



* <u>Scenario 2</u>

**GIVEN** a wallet containing a "EUR" and "USD"

**WHEN** I buy a "JPY"

**THEN** the wallet should contain 3 stocks

**AND** the third one should be equal to "JPY"



### Feature : Sell a stock

As a user I want to sell a Stock of my wallet.



<u>RULES :</u> 

* A stock can be sold is a given currency
* When a user sold a Stock, he received the sotck value in the given currency
* When a user sold a Stock, he received his wallet without the solded stock



* <u>Scenario 1</u>

**GIVEN** an empty wallet

**WHEN** I sell a stock of the wallet

**THEN** the wallet should be unchanged 



* <u>Scenario 2</u>

**GIVEN** a wallet containing 2 Stocks

**WHEN** I sell a stock of the wallet

**THEN** I should have 1 stocks in my wallet



### Feature :  Sell wallet

As a user I want to sell the content wallet. Selling a wallet is selling all stocks inside



<u>RULES :</u> 

* When a user sold his wallet, he received an empty wallet
* A wallet can be sold in a given currency
* When a user sold his wallet, he received the wallet value in the given currency



* <u>Scenario 1</u>

**GIVEN** an empty wallet

**AND** a currency euro rate at 2

**WHEN** I sell the wallet content

**THEN** I should not recieve money

**AND** the content should not be changed 



* <u>Scenario 2</u>

**GIVEN** a wallet containing 3 Stocks  (5, USD), (10, JPY), (2, CAD)

**AND** a currency euro rate at 2

**WHEN** I sell the wallet content

**THEN** I should receive 34 euros 

**AND** the content of the wallet should be empty 