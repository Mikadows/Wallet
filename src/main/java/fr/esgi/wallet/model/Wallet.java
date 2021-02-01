package fr.esgi.wallet.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wallet {
    private final List<Stock> stocks;

    public Wallet() {
        this.stocks = new ArrayList<>();
    }

    public Wallet(final List<Stock> stocks) {
        this.stocks = stocks;
    }

    public boolean buyStock(Stock stock) {
        return this.stocks.add(stock);
    }

    public List<Stock> stocks() {
        return stocks;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "stocks=" + stocks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(stocks, wallet.stocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stocks);
    }
}
