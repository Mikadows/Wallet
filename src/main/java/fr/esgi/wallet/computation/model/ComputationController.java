package fr.esgi.wallet.computation.model;

import fr.esgi.wallet.stock.model.Stock;
import fr.esgi.wallet.stock.model.Wallet;

import java.util.Map;

public class ComputationController {
    private final ExchangeRateService exchangeRateService;
    private final Map<String, String> map = Map.of(
            "USD", "DOLLAR",
            "CAD", "DOLLAR_CANADA",
            "EUR", "EURO",
            "JPY", "YEN"
    );


    public ComputationController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public Money compute(Stock from, Currency to) {
        Double rate = this.exchangeRateService.getRate(Currency.valueOf(map.get(from.stockType().iso4217())), to);
        return Money.of((int) (from.quantity() * rate), to);
    }

    public Money compute(Wallet from, Currency to) {
        Money result = Money.of(0, to);
        for (Stock stock : from.stocks()) {
            result = Money.of(this.compute(stock, to).value() + result.value(), to);
        }
        return result;
    }

}
