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
    public void insertQuarterReturnsTrueValue25Cents() {
        assertTrue(coinAcceptor.insertCoin(Coin.QUARTER.getWeight(), Coin.QUARTER.getDiameter(), Coin.QUARTER.getWidth()));
        assertEquals(.25, coinAcceptor.getInsertedValue());
    }

    @Test
    public void insertDimeReturnsTrueValue10Cents() {
        assertTrue(coinAcceptor.insertCoin(Coin.DIME.getWeight(), Coin.DIME.getDiameter(), Coin.DIME.getWidth()));
        assertEquals(.1, coinAcceptor.getInsertedValue());
    }

    @Test
    public void insertNickelReturnsTrueValue5Cents() {
        assertTrue(coinAcceptor.insertCoin(Coin.NICKEL.getWeight(), Coin.NICKEL.getDiameter(), Coin.NICKEL.getWidth()));
        assertEquals(.05, coinAcceptor.getInsertedValue());
    }

    @Test
    public void insertPennyOrOtherReturnsFalseHasNoValue() {
        assertFalse(coinAcceptor.insertCoin(Coin.NICKEL.getWeight(), Coin.NICKEL.getDiameter(), Coin.QUARTER.getWidth()));
        assertEquals(0.0, coinAcceptor.getInsertedValue());
    }

}