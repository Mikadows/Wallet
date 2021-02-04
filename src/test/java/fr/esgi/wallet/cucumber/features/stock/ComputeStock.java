package fr.esgi.wallet.cucumber.features.stock;

import fr.esgi.wallet.computation.model.ComputationController;
import fr.esgi.wallet.computation.model.Currency;
import fr.esgi.wallet.computation.model.ExchangeRateService;
import fr.esgi.wallet.computation.model.Money;
import fr.esgi.wallet.stock.model.Stock;
import fr.esgi.wallet.stock.model.StockType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class ComputeStock {
    private Currency currency = null;
    private Double rate = null;
    private Stock stock;
    private Money money;

    @Given("a {string} currency rate at {int}")
    public void aCurrencyRateAt(String currency, int rate) {
        this.currency = Currency.valueOf(currency);
        this.rate = (double) rate;
    }

    @And("the stock {string} {int}")
    public void theStock(String stockType, int quantity) {
        this.stock = Stock.of(quantity, StockType.valueOf(stockType));
    }

    @When("I compute the stock value")
    public void iComputeTheStockValue() {
        ComputationController computationController = new ComputationController(new FakeExchangeAPI(this.rate));
        this.money = computationController.compute(this.stock, this.currency);
    }

    @Then("I should have a computed stock value at {int}")
    public void iShouldHaveAComputedStockValueAt(int moneyValue) {
        Assert.assertEquals(Integer.valueOf(moneyValue), this.money.value());
    }

    @Given("no currency")
    public void noCurrency() {
        this.currency = null;
    }

}
