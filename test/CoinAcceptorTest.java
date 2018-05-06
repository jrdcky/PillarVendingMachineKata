import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CoinAcceptorTest {

    private CoinAcceptor coinAcceptor;

    @Before
    public void setUp() {
        coinAcceptor = new CoinAcceptor(100, 100, 100);
    }

    @Test
    public void insertQuarterReturnsTrueValue25Cents() {
        assertTrue(coinAcceptor.insertCoin(Coin.QUARTER));
        assertEquals(.25, coinAcceptor.getInsertedValue());
    }

    @Test
    public void insertDimeReturnsTrueValue10Cents() {
        assertTrue(coinAcceptor.insertCoin(Coin.DIME));
        assertEquals(.1, coinAcceptor.getInsertedValue());
    }

    @Test
    public void insertNickelReturnsTrueValue5Cents() {
        assertTrue(coinAcceptor.insertCoin(Coin.NICKEL));
        assertEquals(.05, coinAcceptor.getInsertedValue());
    }

    @Test
    public void insertPennyOrOtherReturnsFalseHasNoValue() {
        Coin badCoin = new Coin(1, .3, .098);
        assertFalse(coinAcceptor.insertCoin(badCoin));
        assertEquals(0.0, coinAcceptor.getInsertedValue());
    }

    @Test
    public void whenNotLowOnChangeThenDoNotNeedExactChange() {
        assertFalse(coinAcceptor.getNeedExactChange());
    }

}