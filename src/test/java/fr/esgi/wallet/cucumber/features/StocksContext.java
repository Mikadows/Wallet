package fr.esgi.wallet.cucumber.features;

import fr.esgi.wallet.stock.model.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StocksContext {
    private List<Stock> defaultStocks = new ArrayList<>();

    public void addDefaultStock(Stock stock){
        this.defaultStocks.add(stock);
    }

    public List<Stock> defaultStocks() {
        return defaultStocks;
    }

    public Optional<Stock> getStock(String stock) {
        return defaultStocks.stream()
                .filter(p -> p.stockType().iso4217().equals(stock)).findAny();
    }
}
