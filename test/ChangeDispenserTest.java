import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class ChangeDispenserTest {

    CoinAcceptor coinAcceptor;
    ChangeDispenser changeDispenser;

    @Before
    public void setUp() {
        coinAcceptor = new CoinAcceptor();
    }

    private void addQuartersToCoinAcceptor(int quarters) {
        for (int i = 0; i < quarters; i++) {
            coinAcceptor.insertCoin(Coin.QUARTER);
        }
    }

    @Test
    public void inserted75CentsDispense25CentsReturnsOneQuarter() {
        addQuartersToCoinAcceptor(3);
        changeDispenser = new ChangeDispenser(coinAcceptor);
        List<Coin> changeExpected = new ArrayList<>();
        changeExpected.add(Coin.QUARTER);
        List<Coin> changeDispensed = changeDispenser.dispenseChange(.25);

        assertTrue(changeExpected.equals(changeDispensed));
    }

    @Test
    public void inserted50CentsDispense75CentsReturnsTwoQuarters() {
        addQuartersToCoinAcceptor(2);
        changeDispenser = new ChangeDispenser(coinAcceptor);
        List<Coin> changeExpected = new ArrayList<>();
        changeExpected.add(Coin.QUARTER);
        changeExpected.add(Coin.QUARTER);
        List<Coin> changeDispensed = changeDispenser.dispenseChange(.75);
        assertTrue(changeExpected.equals(changeDispensed));
    }

    @Test
    public void inserted75CentsDispense10CentsReturnsDime() {
        addQuartersToCoinAcceptor(3);
        changeDispenser = new ChangeDispenser(coinAcceptor);
        List<Coin> changeExpected = new ArrayList<>();
        changeExpected.add(Coin.DIME);
        List<Coin> changeDispensed = changeDispenser.dispenseChange(.10);

        assertTrue(changeExpected.equals(changeDispensed));
    }

}