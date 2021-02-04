package fr.esgi.wallet.computation.model;

public interface ExchangeRateService {

    Double getRate(Currency from, Currency to);
}
