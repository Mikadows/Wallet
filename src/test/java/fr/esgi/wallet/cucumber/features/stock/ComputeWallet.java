package fr.esgi.wallet.cucumber.features.stock;

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

public class ComputeWallet {
    private final Wallet wallet;
    private final StocksContext stocksContext;
    private Money money;
    private Currency currency = null;
    private Double rate = null;

    public ComputeWallet(StocksContext stocksContext) {
        this.stocksContext = stocksContext;
        this.wallet = new Wallet();
    }

    @Given("a wallet containing a {string} and {string} stocks")
    public void aWalletContainingAAndStocks(String stock1, String stock2) {
        this.wallet.buyStock(this.getStock(stock1));
        this.wallet.buyStock(this.getStock(stock2));
    }

    @And("an empty wallet.")
    public void anEmptyWallet(){
    }

    @And("{string} currency rate at {int}")
    public void currencyRateAt(String currencyName, int rate) {
        this.currency = Currency.valueOf(currencyName);
        this.rate = (double) rate;
    }

    @When("I compute the wallet value")
    public void iComputeTheWalletValue() {
        ComputationController computationController = new ComputationController(new FakeExchangeAPI(this.rate));
        this.money = computationController.compute(this.wallet, this.currency);
    }

    @Then("I should have a computed wallet value at {int} {string}")
    public void iShouldHaveAComputedWalletValueAt(int moneyValue, String currency) {
        Assert.assertEquals(Integer.valueOf(moneyValue), this.money.value());
        Assert.assertEquals(this.currency.iso4217(), Currency.valueOf(currency).iso4217());
    }

    private Stock getStock(final String stockType) {
        return stocksContext.getStock(stockType)
                .orElseThrow(() -> new IllegalArgumentException(stockType + " does not exist in default stocks"));
    }
}
