package fr.esgi.wallet.tu.model;

import fr.esgi.wallet.computation.model.Currency;
import fr.esgi.wallet.computation.model.Money;
import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {

    @Test
    public void moneyNominalTest(){
        Money sut = Money.of(50, Currency.valueOf("EURO"));
        Assert.assertEquals(50, sut.value().intValue());
        Assert.assertEquals(Currency.EURO, sut.currency());
        Assert.assertEquals(Currency.EURO.iso4217(), sut.currency().iso4217());
    }

}
