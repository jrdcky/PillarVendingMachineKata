import org.junit.Test;

import static org.junit.Assert.*;

public class StockKeeperTest {

    @Test
    public void productInStockWhenMoreThan1ReturnTrue() {
        StockKeeper stockKeeper = new StockKeeper(10, 10, 10);
        assertTrue(stockKeeper.isProductInStock(Product.POP));
        assertTrue(stockKeeper.isProductInStock(Product.CHIPS));
        assertTrue(stockKeeper.isProductInStock(Product.CANDY));
    }

    @Test
    public void productInStockWhen0ReturnFalse() {
        StockKeeper stockKeeper = new StockKeeper(0, 0, 0);
        assertFalse(stockKeeper.isProductInStock(Product.POP));
        assertFalse(stockKeeper.isProductInStock(Product.CHIPS));
        assertFalse(stockKeeper.isProductInStock(Product.CANDY));
    }

    @Test
    public void whenProductAvailableBuyReturnsTrue() {
        StockKeeper stockKeeper = new StockKeeper(1,10,20);
        assertTrue(stockKeeper.buyProduct(Product.POP));
        assertTrue(stockKeeper.buyProduct(Product.CHIPS));
        assertTrue(stockKeeper.buyProduct(Product.CANDY));
    }

    @Test
    public void whenProductUnavailableBuyReturnsFalse() {
        StockKeeper stockKeeper = new StockKeeper(1,1,1);
        assertTrue(stockKeeper.buyProduct(Product.POP));
        assertFalse(stockKeeper.buyProduct(Product.POP));
        assertTrue(stockKeeper.buyProduct(Product.CHIPS));
        assertFalse(stockKeeper.buyProduct(Product.CHIPS));
        assertTrue(stockKeeper.buyProduct(Product.CANDY));
        assertFalse(stockKeeper.buyProduct(Product.CANDY));
    }
}