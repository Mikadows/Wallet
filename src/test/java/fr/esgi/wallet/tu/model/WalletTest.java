package fr.esgi.wallet.tu.model;

import fr.esgi.wallet.stock.model.Stock;
import fr.esgi.wallet.stock.model.StockType;
import fr.esgi.wallet.stock.model.Wallet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WalletTest {
    private Wallet sut;

    @Before
    public void setup() {
        this.sut = new Wallet();
    }

    @Test
    public void walletAddNominalTest() {
        Stock stock = Stock.of(10, StockType.EURO);
        Assert.assertTrue(sut.buyStock(stock));
        Assert.assertEquals(1, sut.stocks().size());
    }

    @Test
    public void walletAddFailTest() {
        Assert.assertFalse(sut.buyStock(null));
    }

    @Test
    public void walletSellWalletNominalTest() {
        Stock stock = Stock.of(10, StockType.EURO);
        this.sut.buyStock(stock);
        Assert.assertEquals(1, this.sut.stocks().size());
        this.sut.sellWallet();
        Assert.assertEquals(0, this.sut.stocks().size());
    }

    @Test
    public void walletSellStockNominalTest() {
        this.sut.buyStock(Stock.of(10, StockType.EURO));
        this.sut.buyStock(Stock.of(4, StockType.YEN));
        this.sut.buyStock(Stock.of(2, StockType.DOLLAR_CANADA));
        this.sut.buyStock(Stock.of(6, StockType.DOLLAR));
        Assert.assertEquals(4, this.sut.stocks().size());
        Assert.assertTrue(this.sut.sellStock(Stock.of(4, StockType.YEN)));
        Assert.assertEquals(3, this.sut.stocks().size());
    }

}
