import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CoinAcceptorTest {

    private CoinAcceptor coinAcceptor;

    @Before
    public void setUp() {
        coinAcceptor = new CoinAcceptor();
    }

    @Test
    public void insertQuarterReturnsTrue() {
        assertTrue(coinAcceptor.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth()));
    }

    @Test
    public void insertDimeReturnsTrue() {
        assertTrue(coinAcceptor.insertCoin(Coin.DIME.getWeight(), Coin.DIME.getDiameter(), Coin.DIME.getWidth()));
    }

    @Test
    public void insertNickelReturnsTrue() {
        assertTrue(coinAcceptor.insertCoin(Coin.NICKEL.getWeight(), Coin.NICKEL.getDiameter(), Coin.NICKEL.getWidth()));
    }

    @Test
    public void insertPennyOrOtherReturnsFalse() {
        assertFalse(coinAcceptor.insertCoin(Coin.NICKEL.getWeight(), Coin.NICKEL.getDiameter(), Coin.QUARTER.getWidth()));
    }

    @Test
    public void getInsertedValueAfterQuarter() {
        assertTrue(coinAcceptor.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth()));
        assertEquals(.25, coinAcceptor.getInsertedValue());
    }

    @Test
    public void getInsertedValueAfterDime() {
        assertTrue(coinAcceptor.insertCoin(Coin.DIME.getWeight(), Coin.DIME.getDiameter(), Coin.DIME.getWidth()));
        assertEquals(.1, coinAcceptor.getInsertedValue());
    }

    @Test
    public void getInsertedValueAfterNickel() {
        assertTrue(coinAcceptor.insertCoin(Coin.NICKEL.getWeight(), Coin.NICKEL.getDiameter(), Coin.NICKEL.getWidth()));
        assertEquals(.05, coinAcceptor.getInsertedValue());
    }

}