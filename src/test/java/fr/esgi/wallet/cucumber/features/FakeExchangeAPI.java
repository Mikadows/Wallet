package fr.esgi.wallet.cucumber.features;

import fr.esgi.wallet.computation.model.Currency;
import fr.esgi.wallet.computation.model.ExchangeRateService;

public class FakeExchangeAPI implements ExchangeRateService {
    private final Double rate;

    public FakeExchangeAPI(Double rate) {
        this.rate = rate;
    }

    @Override
    public Double getRate(Currency from, Currency to) {
        return rate;
    }
}