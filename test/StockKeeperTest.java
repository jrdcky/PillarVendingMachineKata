import org.junit.Test;

import static org.junit.Assert.*;

public class StockKeeperTest {

    @Test
    public void productInStockWhenMoreThan1ReturnTrue() {
        StockKeeper stockKeeper = new StockKeeper(10, 10, 10);
        assertTrue(stockKeeper.isPopInStock());
        assertTrue(stockKeeper.isChipsInStock());
        assertTrue(stockKeeper.isCandyInStock());
    }

    @Test
    public void productInStockWhen0ReturnFalse() {
        StockKeeper stockKeeper = new StockKeeper(0, 0, 0);
        assertFalse(stockKeeper.isPopInStock());
        assertFalse(stockKeeper.isChipsInStock());
        assertFalse(stockKeeper.isCandyInStock());
    }

    @Test
    public void whenProductAvailableBuyReturnsTrue() {
        StockKeeper stockKeeper = new StockKeeper(1,10,20);
        assertTrue(stockKeeper.buyPop());
        assertTrue(stockKeeper.buyChips());
        assertTrue(stockKeeper.buyCandy());
    }
}