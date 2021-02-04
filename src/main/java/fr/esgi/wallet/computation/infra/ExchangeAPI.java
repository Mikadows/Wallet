package fr.esgi.wallet.computation.infra;

import fr.esgi.wallet.computation.model.Currency;
import fr.esgi.wallet.computation.model.ExchangeRateService;

public class ExchangeAPI implements ExchangeRateService {

    @Override
    public Double getRate(Currency from, Currency to) {
        return null;
    }
}
