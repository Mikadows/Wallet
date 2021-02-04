package fr.esgi.wallet.computation.model;


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
}
