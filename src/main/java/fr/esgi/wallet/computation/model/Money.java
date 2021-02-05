package fr.esgi.wallet.computation.model;


import java.util.Objects;

public class Money {
    private final Integer value;
    private final Currency currency;

    public Money(Integer value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public static Money of(Integer value, Currency currency) {
        return new Money(value, currency);
    }

    public Currency currency() {
        return currency;
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value) && currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}
