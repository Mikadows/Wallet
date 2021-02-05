package fr.esgi.wallet.tu.model;

import fr.esgi.wallet.stock.model.Stock;
import fr.esgi.wallet.stock.model.StockType;
import org.junit.Assert;
import org.junit.Test;

public class StockTest {

    @Test
    public void stockOfTest() {
        Stock sut = Stock.of(10, StockType.EURO);
        Assert.assertEquals(Integer.valueOf(10), sut.quantity());
        Assert.assertEquals(StockType.EURO, sut.stockType());
        Assert.assertEquals("EUR", sut.stockType().iso4217());
    }

}
