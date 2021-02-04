package fr.esgi.wallet.cucumber.features.stock;

import fr.esgi.wallet.stock.model.Stock;
import fr.esgi.wallet.stock.model.Wallet;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BuyStock {
    private Wallet wallet;
    private StocksContext stocksContext;

    public BuyStock(StocksContext stocksContext) {
        this.stocksContext = stocksContext;
    }

    @Given("an empty wallet")
    public void anEmptyWallet() {
        this.wallet = new Wallet();
    }

    @When("I buy a {string}")
    public void iBuyA(String stock) {
        Stock euro = this.getStock(stock);
        this.wallet.buyStock(euro);
    }

    @Then("the wallet should contain {int} stocks")
    public void theWalletShouldContainOnlyTheStock(int stock) {
        Assert.assertEquals(stock, this.wallet.stocks().size());
    }

    @And("the stock in the wallet should be {string}")
    public void theStockInTheWalletShouldBe(String stock) {
        Assert.assertEquals(this.getStock(stock), this.wallet.stocks().get(0));
    }

    private Stock getStock(final String stockType) {
        return stocksContext.getStock(stockType)
                .orElseThrow(() -> new IllegalArgumentException(stockType + " does not exist in default stocks"));
    }

    @Given("a wallet containing a {string} and {string}")
    public void aWalletContainingAAnd(String stock1, String stock2) {
        this.anEmptyWallet();
        this.wallet.buyStock(this.getStock(stock1));
        this.wallet.buyStock(this.getStock(stock2));
    }

    @And("the third one should be equal to {string}")
    public void theThirdOneShouldBeEqualTo(String expectedStock) {
        Assert.assertEquals(this.getStock(expectedStock), this.wallet.stocks().get(2));
    }
}
