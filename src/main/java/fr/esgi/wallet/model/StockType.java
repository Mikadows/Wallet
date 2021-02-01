package fr.esgi.wallet.model;

public enum StockType {
    DOLLAR("USD"),
    EURO("EUR"),
    YEN("JPY");

    /**
     * La norme ISO 4217 est une norme internationale définissant
     * les codes pour la représentation des devises utilisées dans le monde.
     */
    private final String iso4217;

    StockType(String iso4217) {
        this.iso4217 = iso4217;
    }

    public String iso4217() {
        return iso4217;
    }
}
