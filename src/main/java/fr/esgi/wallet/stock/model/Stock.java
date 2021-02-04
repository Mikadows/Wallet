package fr.esgi.wallet.stock.model;

import java.util.Objects;

public class Stock {
    private final Integer quantity;
    private final StockType stockType;

    public Stock(Integer quantity, StockType stockType) {
        this.quantity = quantity;
        this.stockType = stockType;
    }

    public Integer quantity() {
        return quantity;
    }

    public StockType stockType() {
        return stockType;
    }

    public static Stock of(Integer quantity, StockType stockType) {
        return new Stock(quantity, stockType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(quantity, stock.quantity) && stockType == stock.stockType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, stockType);
    }
}
