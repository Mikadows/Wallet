package fr.esgi.wallet.cucumber.features;

import fr.esgi.wallet.computation.model.ComputationController;
import fr.esgi.wallet.computation.model.Currency;
import fr.esgi.wallet.computation.model.Money;
import fr.esgi.wallet.stock.model.Stock;
import fr.esgi.wallet.stock.model.Wallet;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SellStock {
    private Wallet wallet;
    private final StocksContext stocksContext;
    private Money money;
    private Currency currency;
    private ComputationController computationController;

    public SellStock(StocksContext stocksContext) {
        this.stocksContext = stocksContext;
    }

    @Given("a vacant wallet")
    public void aVacantWallet() {
        this.wallet = new Wallet();
    }

    @Given("a wallet containing {string} and {string}")
    public void aWalletContainingAnd(String stock1, String stock2) {
        this.aVacantWallet();
        this.wallet.buyStock(this.getStock(stock1));
        this.wallet.buyStock(this.getStock(stock2));
    }

    @When("I sell {string} stock of my wallet in currency {string}")
    public void iSellOfMyWallet(String stockType, String currency) {
        Stock stockToSell = this.getStock(stockType);
        this.computationController = new ComputationController(new FakeExchangeAPI(2.0));
        Currency curr = Currency.valueOf(currency);
        this.money = Money.of(0, curr);
        if(this.wallet.sellStock(stockToSell)){
            this.money = computationController.compute(stockToSell, curr);
        }
    }

    @Then("I should have {int} stocks in my wallet")
    public void iShouldHaveStocksInMyWallet(int quantity) {
        Assert.assertEquals(quantity, this.wallet.stocks().size());
    }

    @And("I should receive {int} {string}")
    public void iShouldReceive(int moneyValue, String moneyCurrency) {
        Assert.assertEquals(Integer.valueOf(moneyValue), this.money.value());
        Assert.assertEquals(Currency.valueOf(moneyCurrency), this.money.currency());
    }

    @Given("a wallet containing {string} {string} and {string}")
    public void aWalletContainingAnd(String stock1, String stock2, String stock3) {
        this.aVacantWallet();
        this.wallet.buyStock(this.getStock(stock1));
        this.wallet.buyStock(this.getStock(stock2));
        this.wallet.buyStock(this.getStock(stock3));
    }

    @And("a currency {string} rate at {int}")
    public void aCurrencyRateAt(String currency, int rate) {
        this.computationController = new ComputationController(new FakeExchangeAPI((double) rate));
        this.currency = Currency.valueOf(currency);
    }

    @When("I sell the wallet content")
    public void iSellTheWalletContent() {
        this.money = this.computationController.compute(this.wallet, this.currency);
        this.wallet.sellWallet();
    }

    private Stock getStock(final String stockType) {
        return stocksContext.getStock(stockType)
                .orElseThrow(() -> new IllegalArgumentException(stockType + " does not exist in default stocks"));
    }

}
