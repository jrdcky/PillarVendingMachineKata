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
}