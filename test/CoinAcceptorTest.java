import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinAcceptorTest {

    @Test
    void insertQuarterReturnsTrue() {
        CoinAcceptor coinAcceptor = new CoinAcceptor();
        assertTrue(coinAcceptor.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth()));
    }

    @Test
    void insertDimeReturnsTrue() {
        CoinAcceptor coinAcceptor = new CoinAcceptor();
        assertTrue(coinAcceptor.insertCoin(Coin.DIME.getWeight(), Coin.DIME.getDiameter(), Coin.DIME.getWidth()));
    }

    @Test
    void insertNickelReturnsTrue() {
        CoinAcceptor coinAcceptor = new CoinAcceptor();
        assertTrue(coinAcceptor.insertCoin(Coin.NICKEL.getWeight(), Coin.NICKEL.getDiameter(), Coin.NICKEL.getWidth()));
    }

    @Test
    void insertPennyOrOtherReturnsFalse() {
        CoinAcceptor coinAcceptor = new CoinAcceptor();
        assertFalse(coinAcceptor.insertCoin(Coin.NICKEL.getWeight(), Coin.NICKEL.getDiameter(), Coin.QUARTER.getWidth()));
    }


}