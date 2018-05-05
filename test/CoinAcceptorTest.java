import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinAcceptorTest {

    @Test
    void insertQuarterReturnsTrue() {
        CoinAcceptor coinAcceptor = new CoinAcceptor();
        assertTrue(coinAcceptor.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth()));
    }
}