package fr.esgi.wallet.cucumber.features;

import fr.esgi.wallet.model.Stock;
import fr.esgi.wallet.model.StockType;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;

public class DefaultStocksSteps {
    private final StocksContext stocksContext;

    public DefaultStocksSteps(StocksContext stocksContext) {
        this.stocksContext = stocksContext;
    }

    @Before("@default_stocks")
    public void defaultStocksAreUsed() {
        final Stock euro = new Stock(5, StockType.EURO);
        final Stock dollar = new Stock(2, StockType.DOLLAR);
        final Stock yen = new Stock(10, StockType.YEN);
        this.stocksContext.addDefaultStock(euro);
        this.stocksContext.addDefaultStock(dollar);
        this.stocksContext.addDefaultStock(yen);
    }

    @Then("the available stocks should be at least:")
    public void theAvailableStocksShouldBeAtLeast(List<Stock> stocks) {
        Assertions.assertThat(stocksContext.defaultStocks()).containsAll(stocks);
    }

    @DataTableType
    public Stock convert(Map<String, String> table) {
        return new Stock(Integer.parseInt(table.get("quantity")), StockType.valueOf(table.get("stockType")));
    }

}
